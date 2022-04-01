package com.babyjoeyBackend.repository;

import com.babyjoeyBackend.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity,Integer> {
    public ActivityEntity findBynameact(String nameact);
}
