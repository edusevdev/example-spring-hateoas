package edu.example.hateoas.examplehateoas.controller;

import edu.example.hateoas.examplehateoas.domain.User;
import edu.example.hateoas.examplehateoas.repository.UserRepository;
import edu.example.hateoas.examplehateoas.resourcesupport.UserListWrapper;
import edu.example.hateoas.examplehateoas.resourcesupport.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public UserListWrapper findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                   @RequestParam(value = "size", defaultValue = "10", required = false) int size,
                                   @RequestParam(value = "sort", defaultValue = "username", required = false) String sort) {

        Pageable pageable = new PageRequest(page, size, ASC, sort);

        Page<User> pagedUsers = userRepository.findAll(pageable);
        List<UserWrapper> userWrapperList = new ArrayList<>();
        pagedUsers.getContent().forEach(user -> {
            userWrapperList.add(new UserWrapper(user));
        });

        Page<UserWrapper> pagedUserWrapper = new PageImpl<>(userWrapperList, pagedUsers.getPageable(), pagedUsers.getTotalElements());
        return new UserListWrapper(pagedUserWrapper);
    }

    @GetMapping("/user/{username}")
    public UserWrapper getUserByUsername(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return new UserWrapper(user);
    }

}
