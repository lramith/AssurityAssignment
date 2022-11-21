package com.assurityconsulting.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Item {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("CanRelist")
    private Boolean canRelist;

    @JsonProperty("Promotions")
    private List<Promotion> Promotions;

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
        return Promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        Promotions = promotions;
    }
}
