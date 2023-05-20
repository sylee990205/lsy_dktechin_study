package springrest.exam.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springrest.exam.domain.Person;
import springrest.exam.domain.User;
import springrest.exam.exception.UserNotFoundException;
import springrest.exam.service.UserDaoService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController2 {
    private UserDaoService service;
    public UserController2(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/h_users")
    public CollectionModel<User> retrieveAllUsers(){
        List<User> list = service.findAll();
        String[] images = {"dooly.jpg", "ddochi.jpg", "dauner.png"};
        for(int i=0; i < images.length; i++)
            list.get(i).add(Link.of("http://localhost:8088/images/"+images[i]));

        CollectionModel<User> result = CollectionModel.of(list);
        return result;
    }

    @GetMapping("/h_users/{id}")
    public User retrieveUser(@PathVariable  int id){
        // EntityModel<User>를 리턴하지 않아도 됨
        // User가 RepresentationModel<User> 을 상속하지않는다면 그렇게 해야하지만
        // User는 RepresentationModel<User> 을 상속함
        User user = service.findOne(id);

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
/*        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkTo.withRel("all-users"));*/

        User model = user;
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkTo.withRel("all-users-new"));
        return model;
    }

    @PostMapping("/h_users")
    public User createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        User model = savedUser;
       // EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveUser(user.getId()));
        model.add(linkTo.withRel("save_user"));
        return model;
    }

    @GetMapping("/hateoastest1")
    public ResponseEntity<EntityModel<Person>> hateoasTest1() {
        Person p = new Person("길동", "고");
        EntityModel<Person> model = EntityModel.of(p)
                .add(linkTo(methodOn(getClass()).hateoasTest1()).withSelfRel())
                .add(linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("test1"))
                .add(Link.of("http://localhost:8088/ajaxHome", "test2"))
                .add(linkTo(methodOn(UserController.class).retrieveUser(2)).withRel("test3"));
        return ResponseEntity.ok().body(model);
    }
}
