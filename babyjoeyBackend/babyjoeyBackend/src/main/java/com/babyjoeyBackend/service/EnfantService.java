package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.EnfantEntity;

import java.util.List;
import java.util.Optional;

public interface EnfantService {
    List<EnfantEntity> getAllEnfant();

    EnfantEntity getEnfantByID(long id_end);

    EnfantEntity addEnfant (EnfantEntity enfant);

    EnfantEntity updateEnfant(EnfantEntity updateuser, long id_enf);

    void deleteEnfant(long id_enf);

    Optional<EnfantEntity> getEnfantByIdResponse(long id_enf);


}
