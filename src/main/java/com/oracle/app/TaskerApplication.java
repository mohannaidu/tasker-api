package com.oracle.app;

import com.oracle.app.health.TaskerHealthCheck;
import com.oracle.app.resources.TaskerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TaskerApplication extends Application<TaskerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TaskerApplication().run(args);
    }

    @Override
    public String getName() {
        return "Tasker";
    }

    @Override
    public void initialize(final Bootstrap<TaskerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final TaskerConfiguration configuration,
                    final Environment environment) {
//        final HelloWorldResource resource = new HelloWorldResource();
//        environment.jersey().register(resource);

        final TaskerResource resource = new TaskerResource();
        environment.jersey().register(resource);

        final TaskerHealthCheck healthCheck = new TaskerHealthCheck();
        environment.jersey().register(healthCheck);
    }

}
