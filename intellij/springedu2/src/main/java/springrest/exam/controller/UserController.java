package springrest.exam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springrest.exam.domain.User;
import springrest.exam.exception.UserNotFoundException;
import springrest.exam.service.UserDaoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService service;
    public UserController(UserDaoService service){
        this.service=service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable  int id){
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        return user;
    }

    @PostMapping("/users")
    public void createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if(user==null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }
}
