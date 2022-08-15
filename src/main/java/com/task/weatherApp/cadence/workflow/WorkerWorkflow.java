package com.task.weatherApp.cadence.workflow;

import com.uber.cadence.workflow.WorkflowMethod;

public interface WorkerWorkflow {
    String TASK_LIST = "getWeather";

    @WorkflowMethod(executionStartToCloseTimeoutSeconds = 10, taskList = TASK_LIST)
    Double getWeather(String city);
}

