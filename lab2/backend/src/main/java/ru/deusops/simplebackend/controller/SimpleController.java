package ru.deusops.simplebackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.deusops.simplebackend.dao.UsersDAO;
import ru.deusops.simplebackend.model.SimpleUser;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final UsersDAO usersDAO;

    @GetMapping
    public List<SimpleUser> index() {
        return usersDAO.getAllUsers();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        usersDAO.delete(id);
    }

    @GetMapping("/add/{name}")
    public void add(@PathVariable String name) {
        var user = new SimpleUser();
        user.setName(name);
        usersDAO.save(user);
    }
}
