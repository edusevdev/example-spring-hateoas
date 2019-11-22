package edu.example.hateoas.examplehateoas.repository;

import edu.example.hateoas.examplehateoas.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<User> findPageAll(Pageable pageable) {
        // In a real repository, this pageable will be managed by the database connector. Sublist only is for simulate.
        return new PageImpl<User>(mockList.subList(pageable.getPageNumber(), pageable.getPageSize()), pageable, pageable.getPageSize());
    }

    public User getUserByUsername(String username) {
        return mockList.stream().filter(item -> item.getUsername().equalsIgnoreCase(username)).findFirst().get();
    }

}
