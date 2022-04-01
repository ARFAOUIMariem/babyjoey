package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.ActivityEntity;


import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<ActivityEntity> getAllActivities();

    ActivityEntity getActivityByID(long id);

    ActivityEntity addActivity(ActivityEntity activity);

    ActivityEntity updateActivity(ActivityEntity updateactivity, long id);

    void deleteActivity(long id);

    Optional<ActivityEntity> getActivityByIdResponse(long id);
}

