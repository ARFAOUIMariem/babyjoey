package com.babyjoeyBackend.repository;
import com.babyjoeyBackend.entity.EnfantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnfantRepository extends  JpaRepository<EnfantEntity, Integer> {
    public EnfantEntity findByNom(String nom);
}