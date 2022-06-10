package com.oracle.app.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;
import java.util.Date;

public class Task{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dueDate;
    private Boolean complete;

    @ConstructorProperties({"description", "dueDate","complete"})
    public Task(String description, Date dueDate, Boolean complete) {
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonCreator
    public void setDescription(@JsonProperty("description") String description) {
        this.description = description;
    }

    @JsonProperty("dueDate")
    public Date getDueDate() {
        return dueDate;
    }

    @JsonCreator
    public void setDueDate(@JsonProperty("dueDate") Date dueDate) {
        this.dueDate = dueDate;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonCreator
    public void setComplete(@JsonProperty("complete") Boolean complete) {
        this.complete = complete;
    }
}
