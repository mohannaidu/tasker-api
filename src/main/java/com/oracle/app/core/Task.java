package com.oracle.app.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.ConstructorProperties;
import java.util.Date;

public class Task{

    private Long id;

    @NotEmpty
    @Size(min = 1, max = 1000)
    @ColumnName("description")
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ColumnName("dueDate")
    private Date dueDate;

    @NotNull
    @ColumnName("complete")
    private Boolean complete;

    @ConstructorProperties({"description", "dueDate","complete"})
    public Task(String description, Date dueDate, Boolean complete) {
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }
}
