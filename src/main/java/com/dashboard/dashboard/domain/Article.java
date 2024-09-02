package com.dashboard.dashboard.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {

    private int articleNo;
    private String title;
    private String content;
    private Timestamp createdAt;
    private int lookCount;
    private int recCount;
    private int notRecCount;

    public Article() {

    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
