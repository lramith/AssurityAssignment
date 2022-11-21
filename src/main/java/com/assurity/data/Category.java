package com.assurity.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * <h1>Category Pojo Class</h1>
 * This class has required variables for an Category object
 *
 * @author Ramith Wanniarachchi
 */
public class Category {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("CanRelist")
    private Boolean canRelist;

    @JsonProperty("Promotions")
    private List<Promotion> promotions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCanRelist() {
        return canRelist;
    }

    public void setCanRelist(Boolean canRelist) {
        this.canRelist = canRelist;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
