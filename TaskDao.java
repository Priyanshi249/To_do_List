package com.example.todolist.dao;
import com.example.todolist.model.Task;
import androidx.lifecycle.LiveData;
import androidx.room.*;
import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert(Task task);

    @Delete
    void delete(Task task);

    @Update
    void update(Task task);

    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> getAllTasks();
}
