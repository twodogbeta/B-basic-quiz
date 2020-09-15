package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EducationRepository {
    public static Map<Long, ArrayList<Education>> educationMap = new HashMap<>();

    public Long addUserEducationsByUserId(long userId, Education education) throws UserNotFoundException {
        ArrayList<Education> educationInfo = educationMap.get(userId);
        if (educationInfo == null) {
            throw new UserNotFoundException("User does not exist!");
        } else {
            educationInfo.add(education);
            return userId;
        }
    }

    public ArrayList<Education> getUserEducationsByUserId(long userId) throws UserNotFoundException {
        ArrayList<Education> educationInfo = educationMap.get(userId);
        if (educationInfo == null) {
            throw new UserNotFoundException("User does not exist!");
        } else {
            return educationInfo;
        }
    }
}
