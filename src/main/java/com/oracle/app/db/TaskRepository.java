package com.oracle.app.db;

import com.oracle.app.core.Task;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TaskRepository {

    @SqlQuery("select * from TASK")
    List<Task> getAll();

    @SqlUpdate("delete from TASK where ID = :id")
    int deleteById(@Bind("id") int id);

//    @SqlUpdate("update TASK set NAME = :name where ID = :id")
//    int update(@BindBean Person person);
//
//    @SqlUpdate("insert into TASK (ID, NAME) values (:id, :name)")
//    int insert(@BindBean Tasker person);
}
