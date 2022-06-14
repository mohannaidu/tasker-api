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
        return Response.ok(taskRepository.getAllActive()).build();
    }

    @POST
    public Response createTask(@NotNull @Valid Task task){
        Long taskId = taskRepository.insert(task);
        Task savedTask = taskRepository.findById(taskId);
        return Response.ok(savedTask).build();
    }

    @PUT
    public Response updateTask(@NotNull @Valid Task task){
        Integer taskId = null;
        if(taskRepository.findById(task.getId()) !=null) {
            taskId = taskRepository.update(task);
            if (taskId == 0)
                return Response.status(Response.Status.BAD_REQUEST).build();
            else
                return Response.ok(taskId).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Id not found").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteTask(@PathParam(value="id") @Min(0) @Max(Long.MAX_VALUE) Long id){
        Integer taskId = null;
        if(taskRepository.findById(id) !=null) {
            taskId = taskRepository.deleteById(id);
            if (taskId == 0)
                return Response.status(Response.Status.BAD_REQUEST).build();
            else
                return Response.ok().build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Id not found").build();
        }
    }
}
