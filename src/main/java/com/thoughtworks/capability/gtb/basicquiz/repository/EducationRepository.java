package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EducationRepository {
    public static Map<Long, ArrayList<EducationDto>> educationMap = new HashMap<>();

    public EducationDto education2educationDto (Education education,long userId){
        EducationDto educationDto = EducationDto.builder()
                .userId(userId)
                .title(education.getTitle())
                .description(education.getDescription())
                .year(education.getYear()).build();
        return educationDto;
    }

    public Long addUserEducationsByUserId(long userId, Education education) throws UserNotFoundException {
        ArrayList<EducationDto> educationInfo = educationMap.get(userId);
        if (educationInfo == null) {
            throw new UserNotFoundException("User does not exist!");
        } else {
            educationInfo.add(education2educationDto(education,userId));
            return userId;
        }
    }


    public ArrayList<EducationDto> getUserEducationsByUserId(long userId) throws UserNotFoundException {

        ArrayList<EducationDto> educationInfo = educationMap.get(userId);
        if (educationInfo == null) {
            throw new UserNotFoundException("User does not exist!");
        } else {
            return educationInfo;
        }
    }
}
