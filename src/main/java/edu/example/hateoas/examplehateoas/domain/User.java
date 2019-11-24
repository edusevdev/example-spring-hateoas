package edu.example.hateoas.examplehateoas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID_USER", nullable = false)
    private String idUser;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASS", nullable = false)
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME1")
    private String surname1;
    @Column(name = "SURNAME2")
    private String surname2;

    public User(){

    }

    public User(String username, String password, String name, String surname1, String surname2) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
}
