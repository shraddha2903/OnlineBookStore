package com.example.OnlineBookStore.Controller;

import com.example.OnlineBookStore.Models.User;
import com.example.OnlineBookStore.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return "User added successfully";
    }


}
