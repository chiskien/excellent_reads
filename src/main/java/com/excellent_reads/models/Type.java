package com.excellent_reads.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Type {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
