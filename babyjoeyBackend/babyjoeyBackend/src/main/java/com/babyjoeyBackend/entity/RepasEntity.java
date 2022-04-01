package com.babyjoeyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;
@Entity
@Table(name = "repas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id_repas")
public class RepasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_repas;
    private String nom;
    private String description;
    private String image;
    public Integer getId_repas() {
        return id_repas;
    }

    public void setId_repas(Integer id_repas) {
        this.id_repas = id_repas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "RepasEntity{" +
                "id_repas=" + id_repas +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
