package com.babyjoeyBackend.dto;

import com.babyjoeyBackend.entity.RepasEntity;


public class RepasCreationDto {
    private RepasEntity repas;


    private String message;

    public RepasCreationDto(RepasEntity repas, String message ) {
        this.repas = repas;
        this.message=message;
    }

    public RepasEntity getRepas() {
        return repas;
    }

    public void setRepas(RepasEntity repas) {
        this.repas = repas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
