package com.excellent_reads.models;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    private Set<Book> books = new HashSet<>();
    private Long publisherId;
    private String name;
    private String homepage;
    private String country;
}
