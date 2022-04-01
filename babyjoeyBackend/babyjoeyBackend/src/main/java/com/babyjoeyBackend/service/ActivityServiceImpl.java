package com.babyjoeyBackend.service;

import com.babyjoeyBackend.entity.ActivityEntity;
import com.babyjoeyBackend.exeption.NotFoundExeption;
import com.babyjoeyBackend.repository.ActivityRepository;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    public List<ActivityEntity> getAllactivities() {
        List<ActivityEntity> activities = activityRepository.findAll();
        return activities;
    }

    @SneakyThrows
    public ActivityEntity getActivityByID(long id) {
        ActivityEntity activity = activityRepository.findById((int) id)
                .orElseThrow(() -> new NotFoundExeption("activity not found" + id));

        return activity;
    }


    @Override
    public ActivityEntity addActivity(ActivityEntity activity) {
        activity.setNameact(activity.getNameact());


        return activityRepository.save(activity);
    }

    @Override
    public ActivityEntity updateActivity(ActivityEntity updateactivity, long id) {
        ActivityEntity activity = activityRepository.findById((int) id)
                .orElseThrow(() -> new NotAcceptableStatusException("activity not found"));
        activity.setId(updateactivity.getId());
        activity.setNameact(updateactivity.getNameact());
        activity.setType(updateactivity.getType());
        activity.setDescriptionact(updateactivity.getDescriptionact());
        activity.setImageact(updateactivity.getNameact());
        activityRepository.save(activity);

        return activity;
    }

    @Override
    public void deleteActivity(long Id) {

        activityRepository.deleteById((int) Id);
    }

    @Override
    public Optional<ActivityEntity> getActivityByIdResponse(long id) {
        return activityRepository.findById((int) id);
    }


    @Override
    public List<ActivityEntity> getAllActivities() {

        return activityRepository.findAll();
    }

}



