package com.task.weatherApp.cadence.activities;

import com.uber.cadence.activity.ActivityMethod;

public interface GetWeatherRespondActivity {
    @ActivityMethod(scheduleToCloseTimeoutSeconds = 2)
    Double getResponse(String city);
}
