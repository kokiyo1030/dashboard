package com.dashboard.dashboard.controller;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;
import com.dashboard.dashboard.service.ArticleService;
import com.dashboard.dashboard.service.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class ArticleController {

    private final ArticleServiceImpl articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String articles(@ModelAttribute("articlesSearch") ArticleSearchCond cond, Model model) {
        List<Article> allArticles = articleService.findAllArticles(cond);
        model.addAttribute("articles", allArticles);
        return "articles";
    }

    @GetMapping("/{articleNo}")
    public String article(@PathVariable("articleNo") int articleNo, Model model) {
        log.info("article no: {}", articleNo);
        Optional<Article> articleById = articleService.findArticleById(articleNo);
        Article article = articleById.get();
        model.addAttribute("article", article);
        return "article";
    }

    @GetMapping("/add")
    public String addArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "addArticle";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute Article article, RedirectAttributes redirectAttributes) {
        Article savedArticle = articleService.createArticle(article);
        redirectAttributes.addAttribute("articleNo", savedArticle.getArticleNo());
        return "redirect:/{articleNo}";
    }

    @GetMapping("/{articleNo}/edit")
    public String editArticleForm(@PathVariable("articleNo") int articleNo, Model model) {
        Article article = articleService.findArticleById(articleNo).get();
        model.addAttribute("article", article);
        return "editArticle";
    }

    @PostMapping("/{articleNo}/edit")
    public String editArticle(@PathVariable("articleNo") int articleNo, @ModelAttribute ArticleUpdateDto updateDto, RedirectAttributes redirectAttributes) {
        articleService.updateArticle(articleNo, updateDto);
        redirectAttributes.addAttribute("articleNo", articleNo);
        return "redirect:/{articleNo}";
    }

    @GetMapping("/delete")
    public String deleteArticle(int articleNo) {
        log.info("delete articleNo={}", articleNo);
        articleService.deleteArticle(articleNo);
        return "redirect:/";
    }
}
