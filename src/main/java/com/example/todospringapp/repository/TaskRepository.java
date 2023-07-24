package com.example.todospringapp.repository;

import com.example.todospringapp.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TaskRepository {
    List<Task> taskList = new ArrayList<>();


    public Task findById(int id){
        Task task = null;
        for (Task t : taskList){
            if(t.getId() == id){
                task = t;
            }
        }
        return task;
    }

    public List<Task> getAllTasks(){
        return taskList;
    }

    public void addTask(Task task){
        taskList.add(task);
    }

    public void editTask(Task task){

    }

    public void deleteTask(int id){
        Task task = findById(id);
        if(task != null) taskList.remove(task);
    }
}
