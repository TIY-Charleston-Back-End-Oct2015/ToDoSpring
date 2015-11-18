package com.theironyard.controllers;

import com.theironyard.entities.ToDoItem;
import com.theironyard.services.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zach on 11/17/15.
 */
@RestController
public class ToDoSpringController {
    @Autowired
    ToDoItemRepository toDoItems;

    @RequestMapping("/items")
    public Iterable<ToDoItem> items() {
        return toDoItems.findAll();
    }

    // this is a route for adding to-do items
    @RequestMapping("/add-item")
    public void addItem(HttpServletResponse response, String text) throws IOException {
        response.sendRedirect("/");
        ToDoItem item = new ToDoItem();
        item.text = text;
        toDoItems.save(item);
    }
}
