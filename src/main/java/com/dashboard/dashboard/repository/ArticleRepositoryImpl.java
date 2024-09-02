package com.dashboard.dashboard.repository;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;

import java.util.List;
import java.util.Optional;

public interface ArticleRepositoryImpl {

    Article save(Article article);

    Optional<Article> findById(int id);

    List<Article> findAll(ArticleSearchCond cond);

    void update(int articleNo, ArticleUpdateDto articleUpdateDto);

    void delete(int no);

}
