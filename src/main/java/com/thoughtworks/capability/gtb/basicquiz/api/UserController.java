package com.thoughtworks.capability.gtb.basicquiz.api;

import com.thoughtworks.capability.gtb.basicquiz.domain.User;
import com.thoughtworks.capability.gtb.basicquiz.dto.UserDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User createNewUser(@RequestBody @Valid UserDto userDto) {
        return userService.createNewUser(userDto);
    }

    @GetMapping("/{id}")
    public User getUserBasicInformation(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

}
