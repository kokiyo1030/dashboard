package com.dashboard.dashboard.service;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ArticleServiceImpl {

    Article createArticle(Article article);

    Optional<Article> findArticleById(int id);

    List<Article> findAllArticles(ArticleSearchCond articleSearchCond);

    void updateArticle(int id, ArticleUpdateDto updateDto);

    void deleteArticle(int id);

}
