package com.dashboard.dashboard.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleSearchCond {

    private int articleNo;
    private String title;
    private Timestamp createdAt;
    private int lookCount;
    private int recCount;

    public ArticleSearchCond() {
    }

    public ArticleSearchCond(String title, Timestamp createdAt, int lookCount, int recCount) {
        this.title = title;
        this.createdAt = createdAt;
        this.lookCount = lookCount;
        this.recCount = recCount;
    }
}
