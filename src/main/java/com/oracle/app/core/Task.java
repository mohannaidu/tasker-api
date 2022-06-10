package com.oracle.app.core;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.Date;

@Entity
@Table(name = "task")
@NamedQuery(
        name = "com.oracle.app.core.Task.findAll",
        query = "SELECT t FROM Task t"
)
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="dueDate")
    private Date dueDate;

    @Column(name="complete")
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
