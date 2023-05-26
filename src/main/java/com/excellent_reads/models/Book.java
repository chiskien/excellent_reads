package com.excellent_reads.models;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Book {
    private Long id;
    private String title;
    private String cover;
    private String description;
    private String isbn;
    private Date publishedDate;
    private Publisher publisher;
    private Long publisherId;
    private int pages;
    private Long typeId;
    private Type type;
    private Integer totalRatings;
    private BigDecimal averageRatings;
    private Integer totalReviews;
    private boolean status;
    private String language;
    private String originalTitle;
    private String country;
    public Collection<Genre> genres = new HashSet<>();

    public Book(Long id, String title, String cover, String description, Date publishedDate, int pages) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.description = description;
        this.publishedDate = publishedDate;
        this.pages = pages;
    }

    public Book(Long id, String title, String cover, String description, String isbn, Date publishedDate, Long publisherId, int pages, Long typeId, Integer totalRatings, BigDecimal averageRatings, Integer totalReviews, boolean status, String language, String originalTitle, String country) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.description = description;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.publisherId = publisherId;
        this.pages = pages;
        this.typeId = typeId;
        this.totalRatings = totalRatings;
        this.averageRatings = averageRatings;
        this.totalReviews = totalReviews;
        this.status = status;
        this.language = language;
        this.originalTitle = originalTitle;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Long getType_id() {
        return typeId;
    }

    public void setType_id(Long typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Integer totalRatings) {
        this.totalRatings = totalRatings;
    }

    public BigDecimal getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(BigDecimal averageRatings) {
        this.averageRatings = averageRatings;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
