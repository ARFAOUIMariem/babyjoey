package com.babyjoeyBackend.dto;

import com.babyjoeyBackend.entity.ActivityEntity;


public class ActivityCreationDto {

    private ActivityEntity activity;


    private String message;

    public ActivityCreationDto(ActivityEntity user, String message) {
        this.activity = activity;

        this.message = message;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

