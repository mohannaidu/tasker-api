package com.oracle.app.resources;


import com.oracle.app.core.Task;
import com.oracle.app.db.TaskRepository;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskerResource {

    private final TaskRepository taskRepository;

    public TaskerResource(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GET
    public Response getActiveTasks() {
        List<String> tasks = Arrays.asList("Task 1", "Task 2", "Task 3");
        return Response.ok(tasks).build();
    }

    @POST
    public Response createTask(@NotNull @Valid Task task){
        Task savedTask =null ;//taskRepository.save(task);
        return Response.ok(savedTask).build();
    }

    @PUT
    public Response updateTask(@NotNull @Valid Task task){
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteTask(@PathParam(value="id") @Min(0) @Max(Long.MAX_VALUE) Long id){
        return Response.ok().build();
    }
}
