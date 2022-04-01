package com.babyjoeyBackend.dto;

import lombok.Data;


@Data
public class ActivityDto {
    private Integer id;

    private String type;

    private String nameact;

    private String descriptionact;

    private String imageact;

    public ActivityDto() {
    }

    public ActivityDto(Integer id, String type, String nameact, String descriptionact, String imageact) {
        this.id = id;
        this.type = type;
        this.nameact = nameact;
        this.descriptionact = descriptionact;
        this.imageact = imageact;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameact() {
        return nameact;
    }

    public void setNameact(String nameact) {
        this.nameact = nameact;
    }

    public String getDescriptionact() {
        return descriptionact;
    }

    public void setDescriptionact(String descriptionact) {
        this.descriptionact = descriptionact;
    }

    public String getImageact() {
        return imageact;
    }

    public void setImageact(String imageact) {
        this.imageact = imageact;
    }
}
