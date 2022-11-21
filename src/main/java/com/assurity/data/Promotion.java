package com.assurity.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <h1>Promotion Pojo Class</h1>
 * This class has required variables for a Promotion object
 *
 * @author Ramith Wanniarachchi
 */
public class Promotion {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
