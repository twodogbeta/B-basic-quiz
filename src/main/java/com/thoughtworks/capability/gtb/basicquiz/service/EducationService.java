package com.thoughtworks.capability.gtb.basicquiz.service;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EducationService {
    private final EducationRepository educationRepository = new EducationRepository();

    public Long addUserEducationsByUserId(long userId, Education education) throws UserNotFoundException {
       return educationRepository.addUserEducationsByUserId(userId,education);
    }

    public ArrayList<EducationDto> getUserEducationsByUserId(long userId) throws UserNotFoundException {
        return educationRepository.getUserEducationsByUserId(userId);
    }


}
