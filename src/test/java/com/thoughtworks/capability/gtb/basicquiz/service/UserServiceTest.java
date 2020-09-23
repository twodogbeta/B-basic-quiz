package com.thoughtworks.capability.gtb.basicquiz.service;


import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.EducationRepository;
import com.thoughtworks.capability.gtb.basicquiz.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EducationRepository educationRepository;

    @BeforeEach
    void setup() {
        userService = new UserService(userRepository, educationRepository);
    }

    @Test
    public void should_throw_notFound_when_get_with_userId_not_exists() {
        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
    }


}
