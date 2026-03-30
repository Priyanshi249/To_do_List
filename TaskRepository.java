package com.example.todolist.repository;
import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todolist.dao.TaskDao;
import com.example.todolist.database.TaskDatabase;
import com.example.todolist.model.Task;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTasks;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    public TaskRepository(Application application) {
        TaskDatabase db = TaskDatabase.getInstance(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public void insert(Task task) {
        executor.execute(() -> taskDao.insert(task));
    }

    public void delete(Task task) {
        executor.execute(() -> taskDao.delete(task));
    }

    public void update(Task task) {
        executor.execute(() -> taskDao.update(task));
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
}
