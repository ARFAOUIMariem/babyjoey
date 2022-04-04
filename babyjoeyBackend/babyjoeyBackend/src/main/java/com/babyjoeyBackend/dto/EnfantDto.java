package com.babyjoeyBackend.dto;

import lombok.Data;

@Data
public class EnfantDto {
    private Integer id_enf;
    private String nom;
    private  String prenon;
    private  String data_naissance;
    private long num_inscription;
    private boolean allergie;
    private String type;
    private String description;
    private String image_enf;

    public EnfantDto() {
    }

    public EnfantDto(Integer id_enf, String non, String prenon, long num_inscription, boolean allergie , String type , String description , String data_naissance, String image_enf) {
        this.id_enf = id_enf;
        this.nom=non;
        this.prenon=prenon;
        this.num_inscription=num_inscription;
        this.allergie=allergie;
        this.type=type;
        this.description=description;
        this.data_naissance=data_naissance;
        this.image_enf= image_enf;
    }

    public Integer getId_enf() {
        return id_enf;
    }

    public void setId_enf(Integer id_enf) {
        this.id_enf = id_enf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenon() {
        return prenon;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
    }

    public long getNum_inscription() {
        return num_inscription;
    }

    public void setNum_inscription(long num_inscription) {
        this.num_inscription = num_inscription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAllergie() {
        return allergie;
    }

    public void setAllergie(boolean allergie) {
        this.allergie = allergie;
    }

    public String getData_naissance() {
        return data_naissance;
    }

    public void setData_naissance(String data_naissance) {
        this.data_naissance = data_naissance;
    }

    public String getImage_enf() {
        return image_enf;
    }

    public void setImage_enf(String image_enf) {
        this.image_enf = image_enf;
    }
}
