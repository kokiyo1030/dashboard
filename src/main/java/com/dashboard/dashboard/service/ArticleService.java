package com.dashboard.dashboard.service;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;
import com.dashboard.dashboard.repository.ArticleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements ArticleServiceImpl {

    private final ArticleRepositoryImpl articleRepository;

    public ArticleService(ArticleRepositoryImpl articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> findArticleById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public List<Article> findAllArticles(ArticleSearchCond articleSearchCond) {
        return articleRepository.findAll(articleSearchCond);
    }

    @Override
    public void updateArticle(int id, ArticleUpdateDto updateDto) {
        articleRepository.update(id, updateDto);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.delete(id);
    }
}
