create table articles
(
    article_no int primary key auto_increment,
    title varchar(20),
    content varchar(200),
    created_at timestamp not null default current_timestamp,
    look_count int default 0,
    rec_count int default 0,
    not_rec_count int default 0
);