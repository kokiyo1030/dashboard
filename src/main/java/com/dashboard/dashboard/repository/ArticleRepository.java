package com.dashboard.dashboard.repository;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepository implements ArticleRepositoryImpl {

    private final ArticleMapper articleMapper;

    public ArticleRepository(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public Article save(Article article) {
        articleMapper.save(article);
        return article;
    }

    @Override
    public Optional<Article> findById(int id) {
        return articleMapper.findById(id);
    }

    @Override
    public List<Article> findAll(ArticleSearchCond cond) {
        return articleMapper.findAll(cond);
    }

    @Override
    public void update(int articleNo, ArticleUpdateDto articleUpdateDto) {
        articleMapper.update(articleNo, articleUpdateDto);
    }

    @Override
    public void delete(int no) {
        articleMapper.delete(no);
    }
}
