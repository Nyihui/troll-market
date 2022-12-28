package com.indocyber.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MerchandiseDto {

    private int id;

    @NotNull
    private String name;

    @NotNull
    private String category;

    @NotNull
    private String description;

    private BigDecimal price;

    private boolean isDiscontinue;

    public MerchandiseDto(){}

    public MerchandiseDto(int id, String name, String category, String description, BigDecimal price, boolean isDiscontinue) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.isDiscontinue = isDiscontinue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean getIsDiscontinue() {
        return isDiscontinue;
    }

    public void setIsDiscontinue(boolean discontinue) {
        isDiscontinue = discontinue;
    }
}
