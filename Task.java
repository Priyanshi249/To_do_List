package com.example.todolist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public boolean isCompleted;

    public Task(String title) {
        this.title = title;
        this.isCompleted = false;
    }

    // ✅ ADD THIS
    public String getTitle() {
        return title;
    }
}
