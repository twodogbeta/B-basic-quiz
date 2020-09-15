package com.thoughtworks.capability.gtb.basicquiz.service;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.EducationRepository;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    private final EducationRepository educationRepository = new EducationRepository();

    public String addUserEducationsByUserId(long userId, Education education) throws UserNotFoundException {
       return educationRepository.addUserEducationsByUserId(userId,education);
    }


}
