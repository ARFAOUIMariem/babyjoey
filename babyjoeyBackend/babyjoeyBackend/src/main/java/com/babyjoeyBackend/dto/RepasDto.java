package com.babyjoeyBackend.dto;

import lombok.Data;

@Data
public class RepasDto {


    private Integer id_repas;
    private String nom;
    private String description;
    private String image;

    public RepasDto() {
    }

    public RepasDto(Integer id_repas, String nom, String description, String image) {
        this.id_repas = id_repas;
        this.nom = nom;
        this.description = description;
        this.image = image;

    }

    public Integer getId_repas() {
        return id_repas;
    }

    public void setId_repas(Integer id_repas) {
        this.id_repas = id_repas;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
