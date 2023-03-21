package com.example.demo.controller;

import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.Optional;

@RestController
public class ValidationController {

    @Autowired
    TaskService taskService;
    Pattern pattern = Pattern.compile("[task-]+[0-9]");

    public static boolean validate(String username,String password){
        if(username.equals("user1") && password.equals("test123")){
            return true;
        }
        return false;
    }

    @PostMapping("/validate")
    public String validation(@RequestBody User user){
        if(validate(user.getUsername(), user.getPassword()))
                return "success";
        return "fail";
    }

    @PostMapping("/add-task")
    public String addTask(@RequestBody Task task) {
        if(taskService.saveTask(task)!=null){
            return "success";
        }
        return "failure";
    }

    @GetMapping("/get-task/task")
    public Optional<Task> getTask(@RequestParam int id) {
        Optional<Task> task = taskService.getTaskById(id);
        if(task!=null ){
            return task;
        }
        return null;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(@RequestParam int id) {
        List<Task> tasks = taskService.getTasks();
        return tasks;
    }

    @GetMapping("/delete-task/task")
    public String deleteTask(@RequestParam int id) {
        Optional<Task> task = taskService.getTaskById(id);
        if(task!=null) {
            taskService.deleteTaskById(id);
            return "deleted";
        }
        return "doesn't exist";
    }
}
