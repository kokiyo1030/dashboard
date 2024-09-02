package com.dashboard.dashboard.service;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;
import com.dashboard.dashboard.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Transactional
class ArticleServiceTest {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceTest(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @BeforeEach
    void setUp() {
        log.info("articleRepository: {}", articleRepository);
    }

    @Test
    void createArticle() {
        Article article = new Article("title", "content");
        articleRepository.save(article);
        assertThat(article.getTitle()).isEqualTo("title");
        assertThat(article.getContent()).isEqualTo("content");
    }

    @Test
    void findArticleById() {
        Article article = new Article("title", "content");
        articleRepository.save(article);
        Article findArticle = articleRepository.findById(article.getArticleNo()).orElseThrow();

        assertThat(findArticle.getTitle()).isEqualTo("title");
        assertThat(findArticle.getContent()).isEqualTo("content");
    }

    @Test
    void findAllArticles() {
        Article article1 = new Article("title1", "content2");
        Article article2 = new Article("title2", "content2");
        articleRepository.save(article1);
        articleRepository.save(article2);

        ArticleSearchCond cond = new ArticleSearchCond();
        List<Article> allArticles = articleRepository.findAll(cond);
        assertThat(allArticles.size()).isEqualTo(2);
    }

    @Test
    void updateArticle() {
        Article article = new Article("title", "content");
        Article savedArticle = articleRepository.save(article);
        int articleNo = savedArticle.getArticleNo();

        ArticleUpdateDto updateDto = new ArticleUpdateDto("title2", "content2");
        articleRepository.update(articleNo, updateDto);

        Article findArticle = articleRepository.findById(articleNo).orElseThrow();
        log.info("findArticle: {}", findArticle);
        assertThat(findArticle.getTitle()).isEqualTo("title2");
        assertThat(findArticle.getContent()).isEqualTo("content2");
    }

    @Test
    void deleteArticle() {
        Article article = new Article("title", "content");
        Article savedArticle = articleRepository.save(article);
        int articleNo = savedArticle.getArticleNo();
        articleRepository.delete(articleNo);

        assertThat(articleRepository.findById(articleNo).isPresent()).isFalse();
    }
}