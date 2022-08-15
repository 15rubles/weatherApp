package com.task.weatherApp.cadence.activities;

import com.uber.cadence.activity.ActivityMethod;

public interface PostWeatherInfActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    void postWeatherInf(String city, Double temp);
}
