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
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        List<Task> tasks = taskRepository.getAllTasks();
        int id = tasks.size() == 0 ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        Task task = new Task(id);
        model.addAttribute("task", task);
        return "add-task";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute("task") Task task, Model model) {
        taskRepository.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Task task = taskRepository.findById(id);
        System.out.println(task.toString());
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/edit-task")
    public String editTask(@ModelAttribute("task") Task task, Model model) {
        System.out.println(task.toString());
        taskRepository.editTask(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskRepository.deleteTask(id);
        return "redirect:/";
    }
}
