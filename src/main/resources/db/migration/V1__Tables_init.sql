
create table genre
(
    genre_id   int unsigned auto_increment
        primary key,
    genre_name varchar(50) charset utf8mb3 not null
);

create table publisher
(
    publisher_id int unsigned auto_increment
        primary key,
    name         varchar(255)                 not null,
    homepage     varchar(100)                 null,
    location     varchar(255) charset utf8mb3 null
);

create table status
(
    status_id   int unsigned auto_increment
        primary key,
    status_name varchar(50) not null
);

create table type
(
    type_id   int unsigned auto_increment
        primary key,
    type_name varchar(50) not null
);

create table book
(
    id              int unsigned auto_increment
        primary key,
    title           varchar(255) charset utf8mb3 not null,
    cover           varchar(255)                 null,
    description     varchar(7000)                null,
    isbn            varchar(50)                  not null,
    published_date  date                         not null,
    publisher_id    int unsigned                 not null,
    pages           int                          not null,
    type_id         int unsigned                 not null,
    total_ratings   int                          null,
    average_ratings double                       null,
    total_reviews   int                          null,
    status          tinyint(1) default 1         not null,
    language        varchar(20)                  not null,
    original_title  varchar(255) charset utf8mb3 null,
    country         varchar(50)                  not null,
    constraint book_publisher_publisher_id_fk
        foreign key (publisher_id) references publisher (publisher_id),
    constraint book_type_type_id_fk
        foreign key (type_id) references type (type_id)
);

create table book_genre
(
    book_id  int unsigned not null,
    genre_id int unsigned not null,
    primary key (book_id, genre_id),
    constraint books_genres_books_id_fk
        foreign key (book_id) references book (id),
    constraint books_genres_genres_genre_id_fk
        foreign key (genre_id) references genre (genre_id)
);

create table book_in_bookshelf
(
    bookshelf_id int unsigned not null,
    book_id      int unsigned not null,
    primary key (bookshelf_id, book_id),
    constraint book_in_bookshelf_book_id_fk
        foreign key (book_id) references book (id)
);

create table user
(
    user_id       int unsigned auto_increment
        primary key,
    first_name    varchar(255) charset utf8mb3         not null,
    middle_name   varchar(255) charset utf8mb3         null,
    last_name     varchar(255) charset utf8mb3         not null,
    gender        tinyint(1) default 1                 not null,
    joined_date   datetime   default CURRENT_TIMESTAMP not null,
    overview      varchar(255) charset utf8mb3         null,
    country       int                                  null,
    avatar        varchar(255)                         null,
    isAuthor      tinyint(1) default 0                 not null,
    hash          int                                  null invisible,
    email         varchar(40)                          not null,
    date_of_birth date                                 not null
);

create table book_author
(
    book_id   int unsigned not null,
    author_id int unsigned not null,
    primary key (book_id, author_id),
    constraint book_author_book_id_fk
        foreign key (book_id) references book (id)
            on delete cascade,
    constraint book_author_user_user_id_fk
        foreign key (author_id) references user (user_id)
            on delete cascade
);

create table book_shelf
(
    bookshelf_id   int unsigned auto_increment
        primary key,
    user_id        int unsigned                 not null,
    bookshelf_name varchar(100)                 not null,
    description    varchar(255) charset utf8mb3 null,
    constraint book_shelf_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

create table favorite_genre
(
    genre_id int unsigned not null,
    user_id  int unsigned not null,
    primary key (genre_id, user_id),
    constraint favorite_genre_genre_genre_id_fk
        foreign key (genre_id) references genre (genre_id),
    constraint favorite_genre_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

create table quotes
(
    quote_id      int unsigned auto_increment
        primary key,
    user_id       int unsigned                not null,
    author_id     int unsigned                not null,
    quote_content varchar(50) charset utf8mb3 not null,
    constraint quotes_user_user_id_fk
        foreign key (user_id) references user (user_id),
    constraint quotes_user_user_id_fk2
        foreign key (author_id) references user (user_id)
);

create table user_books
(
    user_id       int unsigned                       not null,
    book_id       int unsigned                       not null,
    status_id     int unsigned                       not null,
    read_date     datetime default CURRENT_TIMESTAMP not null,
    progress      int                                null,
    added_date    datetime default CURRENT_TIMESTAMP not null,
    finished_date datetime default CURRENT_TIMESTAMP null,
    rating        int                                null,
    primary key (user_id, book_id),
    constraint user_books_book_id_fk
        foreign key (book_id) references book (id),
    constraint user_books_status_status_id_fk
        foreign key (status_id) references status (status_id),
    constraint user_books_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

create table user_comments
(
    comment_id int unsigned auto_increment
        primary key,
    parent_id  int unsigned                 null,
    user_id    int unsigned                 not null,
    content    varchar(255) charset utf8mb3 not null,
    constraint user_comments_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

create table user_friends
(
    user1_id   int unsigned                       not null,
    user2_id   int unsigned                       not null,
    added_date datetime default CURRENT_TIMESTAMP not null,
    primary key (user1_id, user2_id),
    constraint user_friends_user_user_id_fk
        foreign key (user1_id) references user (user_id),
    constraint user_friends_user_user_id_fk2
        foreign key (user2_id) references user (user_id)
);

create table user_reviews
(
    review_id   int unsigned auto_increment
        primary key,
    user_id     int unsigned                 not null,
    book_id     int unsigned                 not null,
    posted_date datetime                     not null,
    title       varchar(40)                  not null,
    content     varchar(550) charset utf8mb3 not null,
    constraint user_reviews_book_id_fk
        foreign key (book_id) references book (id),
    constraint user_reviews_user_user_id_fk
        foreign key (user_id) references user (user_id)
);

