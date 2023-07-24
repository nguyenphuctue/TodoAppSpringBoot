package com.example.todospringapp.repository;

import com.example.todospringapp.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    List<Task> taskList = new ArrayList<>();

    public TaskRepository() {
        taskList.add(new Task(1, "Title 1", "This is content 1"));
        taskList.add(new Task(2, "Title 2", "This is content 2"));
    }

    public Task findById(int id) {
        Task task = null;
        for (Task t : taskList) {
            if (t.getId() == id) {
                task = t;
            }
        }
        return task;
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void editTask(Task task) {
        Task t = findById(task.getId());
        if (t != null) {
            taskList.remove(t);
            taskList.add(task);
            System.out.println("Edit successful");
        }else{
            System.out.println("Edit unsuccessful");
        }
    }

    public void deleteTask(int id) {
        Task task = findById(id);
        if (task != null) taskList.remove(task);
    }
}
