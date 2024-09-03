package com.dashboard.dashboard.domain;

import lombok.Data;

@Data
public class ArticleSearchCond {

    private String title;

    public ArticleSearchCond() {
    }

    public ArticleSearchCond(String title) {
        this.title = title;
    }
}
