package edu.example.hateoas.examplehateoas.controller;

import edu.example.hateoas.examplehateoas.domain.User;
import edu.example.hateoas.examplehateoas.repository.UserRepositoryMock;
import edu.example.hateoas.examplehateoas.resourcesupport.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepositoryMock userRepositoryMock;

    @GetMapping
    public String hellow() {
        return "Welcome to spring-hateoas example";
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userRepositoryMock.findAll();
    }

    @GetMapping("/user/{username}")
    public UserWrapper getUserByUsername( @PathVariable String username ) {
        User user = userRepositoryMock.getUserByUsername(username);
        return new UserWrapper(user);
    }

}
