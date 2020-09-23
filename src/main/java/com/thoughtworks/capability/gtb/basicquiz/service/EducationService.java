package com.thoughtworks.capability.gtb.basicquiz.service;

import com.thoughtworks.capability.gtb.basicquiz.domain.Education;
import com.thoughtworks.capability.gtb.basicquiz.domain.User;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.repository.EducationRepository;
import com.thoughtworks.capability.gtb.basicquiz.repository.UserRepository;
import com.thoughtworks.capability.gtb.basicquiz.utils.Transverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;

    public EducationService(EducationRepository educationRepository, UserRepository userRepository) {
        this.educationRepository = educationRepository;
        this.userRepository = userRepository;
    }

    public Education addUserEducationsByUserId(Long userId, EducationDto educationDto) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("userId: " + userId + " 不存在");
        }

        Education education = Transverter.EducationDto2Education(educationDto, userOptional.get());
        return educationRepository.save(education);
    }

    public List<Education> getUserEducationsByUserId(Long userId) {
        return educationRepository.findAllByUserId(userId);
    }

    /*public Long addUserEducationsByUserId(long userId, Education education) throws UserNotFoundException {
       //return educationRepository.addUserEducationsByUserId(userId,education);
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new UserNotFoundException(userId + "不存在");
        }

        Education education = Converter.convertEducationVo2Education(educationVo, userOptional.get());
        return educationRepository.save(education);
    }


    public List<EducationDto> getUserEducationsByUserId(long userId) throws UserNotFoundException {
        return educationRepository.getUserEducationsByUserId(userId);
    }*/


}
