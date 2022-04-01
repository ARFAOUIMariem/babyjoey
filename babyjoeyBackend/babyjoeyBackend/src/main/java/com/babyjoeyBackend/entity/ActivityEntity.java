package com.babyjoeyBackend.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

    @Entity
    @Table(name = "activities")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    public class ActivityEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        private String type;

        private String nameact;

        private String descriptionact;


        private String imageact;



        /**
         * @return the id
         */
        public Integer getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /***********Type*************/
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        /*************nameact************/

        public String getNameact() {
            return nameact;
        }

        public void setNameact(String nameact) {
            this.nameact = nameact;
        }

        /**************descriptionact********/

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


        @Override
        public String toString() {
            return "ActivityEntity{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", name='" + nameact +
                    ",desciptionact='" + descriptionact +
                    ",imageact='" + imageact +

                    '}';
        }
    }



