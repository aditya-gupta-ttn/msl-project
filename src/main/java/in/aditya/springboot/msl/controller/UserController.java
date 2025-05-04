package in.aditya.springboot.msl.controller;

import in.aditya.springboot.msl.model.User;
import in.aditya.springboot.msl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody User user) {
        userService.save(user);
        return "User saved";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getById(id);
    }
}
