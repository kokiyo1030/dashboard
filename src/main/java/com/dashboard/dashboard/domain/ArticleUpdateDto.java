package com.dashboard.dashboard.domain;

public class ArticleUpdateDto {

    private String title;
    private String content;

    public ArticleUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
