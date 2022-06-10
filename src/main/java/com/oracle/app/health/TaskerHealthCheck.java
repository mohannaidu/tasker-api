package com.oracle.app.health;

import com.codahale.metrics.health.HealthCheck;

public class TaskerHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
