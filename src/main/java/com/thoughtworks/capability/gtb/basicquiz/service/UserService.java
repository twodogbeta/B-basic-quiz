package com.thoughtworks.capability.gtb.basicquiz.service;

import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public Long createNewUser(User user){
       return userRepository.createNewUser(user);
    }

    public User getUserById(long userId) throws UserNotFoundException {
        return userRepository.getUserById(userId);
    }
}
