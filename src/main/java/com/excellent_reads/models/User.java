package com.excellent_reads.models;

import jakarta.annotation.Nullable;

public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;

    private String getFullName() {
        return firstName + middleName + lastName;
    }

}
