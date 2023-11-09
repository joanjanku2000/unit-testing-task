create table if not exists categories
(
    id            int auto_increment
        primary key,
    name          varchar(60) not null,
    date_created  timestamp   not null,
    date_modified timestamp   null
);

create table if not exists users
(
    id            int auto_increment
        primary key,
    username      varchar(60)  not null,
    email         varchar(100) not null,
    password      varchar(255) not null,
    date_created  timestamp    not null,
    date_modified timestamp    null
);

create table if not exists posts
(
    id            int auto_increment
        primary key,
    title         varchar(60)  not null,
    body          varchar(255) not null,
    user_id       int          not null,
    date_created  timestamp    not null,
    date_modified timestamp    null,
    constraint posts_ibfk_1
        foreign key (user_id) references users (id)
);

create table if not exists post_categories
(
    id            int auto_increment
        primary key,
    post_id       int       not null,
    category_id   int       not null,
    date_created  timestamp not null,
    date_modified timestamp null,
    constraint post_categories_ibfk_1
        foreign key (category_id) references categories (id),
    constraint post_categories_ibfk_2
        foreign key (post_id) references posts (id)
);

create index if not exists category_id
    on post_categories (category_id);

create index if not exists  post_id
    on post_categories (post_id);

create index  if not exists  user_id
    on posts (user_id);

