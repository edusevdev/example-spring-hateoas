package edu.example.hateoas.examplehateoas.repository;

import edu.example.hateoas.examplehateoas.domain.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserRepositoryMock {

    private List<User> mockList = Arrays.asList(
            new User("pepe", "passwordPepe","NamePepe","Surname1Pepe","Surname2Pepe"),
            new User("ana", "passwordAna","NameAna","Surname1Ana","Surname2Ana"),
            new User("gato", "passwordGato","NameGato","Surname1Gato","Surname2Gato")
    );

    public List<User> findAll() {
        return mockList;
    }

    public User getUserByUsername(String username) {
        return mockList.stream().filter(item -> item.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }

}
