package com.example.todospringapp.controller;

import com.example.todospringapp.model.Task;
import com.example.todospringapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskRepository.getAllTasks();
        model.addAttribute("tasks", tasks);
        int id = tasks.size() == 0 ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        Task task = new Task(id);
        model.addAttribute("task", task);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") Task task, Model model) {
        taskRepository.addTask(task);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id){
        taskRepository.deleteTask(id);
        return "redirect:/";
    }
}
