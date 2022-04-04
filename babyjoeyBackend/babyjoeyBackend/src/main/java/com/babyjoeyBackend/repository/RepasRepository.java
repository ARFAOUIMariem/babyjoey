package com.babyjoeyBackend.repository;

import com.babyjoeyBackend.entity.RepasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepasRepository extends  JpaRepository<RepasEntity, Integer> {
    public  RepasEntity findByNom(String nom);

}

