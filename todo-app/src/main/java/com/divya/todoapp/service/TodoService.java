package com.divya.todoapp.service;

import com.divya.todoapp.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> list = new ArrayList<>();
    private int idCounter = 1;

    public List<Todo> getAll() {
        return list;
    }

    public void add(String task) {
        list.add(new Todo(idCounter++, task));
    }

    public void delete(int id) {
        list.removeIf(todo -> todo.getId() == id);
    }
}
