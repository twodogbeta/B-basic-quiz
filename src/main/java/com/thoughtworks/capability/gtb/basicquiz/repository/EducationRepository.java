package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

// GTB: - 如果 EducationRepository.education2educationDto() 不放到 repo 里就好了
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
            Collections.sort(educationInfo, new Comparator<EducationDto>(){
                public int compare(EducationDto o1, EducationDto o2) {
                    //排序属性
                    if(o1.getYear() < o2.getYear()){
                        return -1;
                    }
                    if(o1.getYear() == o2.getYear()){
                        return 0;
                    }
                    return 1;
                }
            });
            return educationInfo;
        }
    }
}
