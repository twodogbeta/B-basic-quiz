package com.thoughtworks.capability.gtb.basicquiz.service;

import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import com.thoughtworks.capability.gtb.basicquiz.dto.UserDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.UserRepository;
import com.thoughtworks.capability.gtb.basicquiz.utils.Transverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(UserDto userDto) {
        User user = Transverter.UserDto2User(userDto);
        return userRepository.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("ID: " + id + " 不存在");
        }
        return userOptional.get();
    }

   /* public Long createNewUser(User user){
       return userRepository.createNewUser(user);
    }

    public User getUserById(long userId) throws UserNotFoundException {
        return userRepository.getUserById(userId);
    }*/
}
