package com.babyjoeyBackend.dto;
import com.babyjoeyBackend.entity.EnfantEntity;

public class EnfantCreationDto {
    private EnfantEntity enfant;
    private String message;

    public EnfantCreationDto(EnfantEntity enfant , String message) {
        this.enfant = enfant;
        this.message=message;
    }

    public EnfantEntity getEnfant() {
        return enfant;
    }

    public void setEnfant(EnfantEntity enfant) {
        this.enfant = enfant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
