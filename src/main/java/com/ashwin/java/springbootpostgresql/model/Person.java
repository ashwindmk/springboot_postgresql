package com.ashwin.java.springbootpostgresql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Person {
    @JsonProperty("id")
    @NotNull
    private final UUID id;

    @JsonProperty("name")
    @NotBlank
    private String name;

    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
