package com.oracle.app;

import com.oracle.app.db.TaskRepository;
import com.oracle.app.health.TaskerHealthCheck;
import com.oracle.app.resources.TaskerResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;

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

    }

    @Override
    public void run(final TaskerConfiguration configuration, final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "oracle");

        final TaskRepository repository  = jdbi.onDemand(TaskRepository.class);

        final TaskerResource resource = new TaskerResource(repository);
        environment.jersey().register(resource);

        final TaskerHealthCheck healthCheck = new TaskerHealthCheck();
        environment.jersey().register(healthCheck);
    }

}
