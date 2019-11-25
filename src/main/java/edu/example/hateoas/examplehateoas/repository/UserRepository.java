package edu.example.hateoas.examplehateoas.repository;

import edu.example.hateoas.examplehateoas.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public interface UserRepository extends JpaRepository<User, Long> {

    public Page<User> findAll(Pageable pageable);

    @Query("select u from User u where u.username = :username")
    public User findByUsername(String username);
}
