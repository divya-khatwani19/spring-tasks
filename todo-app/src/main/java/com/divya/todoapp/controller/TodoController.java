package com.divya.todoapp.controller;

import com.divya.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("todos", service.getAll());
        return "home";
    }

    @PostMapping("/add")
    public String add(@RequestParam String task) {
        service.add(task);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/";
    }
}
