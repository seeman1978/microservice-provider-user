package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id)
    {
        User findOne = this.userRepository.findById(id).orElse(null);
        if (findOne == null) {
            findOne = new User();
            findOne.id = 1L;
            findOne.age = 20;

            findOne.username = "wq";
            findOne.name = "seeman";
        }
        return findOne;
    }

    @GetMapping("/get")
    public  User get(User user){
        return user;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
        return user;
    }
}