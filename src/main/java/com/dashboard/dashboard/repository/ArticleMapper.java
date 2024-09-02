package com.dashboard.dashboard.repository;

import com.dashboard.dashboard.domain.Article;
import com.dashboard.dashboard.domain.ArticleSearchCond;
import com.dashboard.dashboard.domain.ArticleUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ArticleMapper {

    void save(Article article);

    Optional<Article> findById(int id);

    List<Article> findAll(ArticleSearchCond cond);

    void update(@Param("articleNo") int articleNo, @Param("updateDto") ArticleUpdateDto articleUpdateDto);

    void delete(int no);

}
