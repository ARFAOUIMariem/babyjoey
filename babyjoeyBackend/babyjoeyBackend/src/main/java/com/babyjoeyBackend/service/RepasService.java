package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.RepasEntity;

import java.util.List;
import java.util.Optional;

public interface RepasService {
    List<RepasEntity> getAllRepas();

    RepasEntity getRepasByID(long id_repas);

    RepasEntity addRepas(RepasEntity repas);

    RepasEntity updateRepas(RepasEntity updateuser, long id_repas);

    void deleteRepas(long id_repas);

    Optional<RepasEntity> getRepasByIdResponse(long id_repas);

}
