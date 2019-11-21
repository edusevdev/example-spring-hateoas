package edu.example.hateoas.examplehateoas.resourcesupport;

import edu.example.hateoas.examplehateoas.controller.MainController;
import edu.example.hateoas.examplehateoas.domain.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class UserWrapper extends ResourceSupport {

    private final User user;

    public UserWrapper(User user) {
        super();
        add(linkTo(methodOn(MainController.class).getUserByUsername(user.getUsername())).withSelfRel());
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void add(Link link) {
        super.add(link);
    }

    @Override
    public List<Link> getLinks(String rel) {
        return super.getLinks(rel);
    }
}
