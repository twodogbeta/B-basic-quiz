package com.thoughtworks.capability.gtb.basicquiz.api;

import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import com.thoughtworks.capability.gtb.basicquiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

}