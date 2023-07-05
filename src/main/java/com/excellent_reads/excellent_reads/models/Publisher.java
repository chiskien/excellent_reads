package com.excellent_reads.excellent_reads.models;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private Long id;
    private Long publisherId;
    private String name;
    private String homepage;
    private String country;

    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }
}
