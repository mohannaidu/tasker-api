package com.oracle.app.db;

import com.oracle.app.core.Task;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TaskRepository {

    @SqlQuery("select * from Task where complete = 0")
    @RegisterBeanMapper(Task.class)
    List<Task> getAllActive();

    @SqlQuery("select * from Task where ID = :id")
    @RegisterBeanMapper(Task.class)
    Task findById(@Bind("id") Long id);

    @SqlUpdate("delete from Task where ID = :id")
    int deleteById(@Bind("id") Long id);

    @SqlUpdate("update Task set DESCRIPTION = :description, DUEDATE = :dueDate, COMPLETE = :complete where ID = :id")
    @RegisterBeanMapper(Task.class)
    int update(@BindBean Task task);

    @SqlUpdate("insert into Task (DESCRIPTION, DUEDATE, COMPLETE) values ( :description, :dueDate, :complete)")
    @GetGeneratedKeys("ID")
    @RegisterBeanMapper(Task.class)
    Long insert(@BindBean Task task);
}
