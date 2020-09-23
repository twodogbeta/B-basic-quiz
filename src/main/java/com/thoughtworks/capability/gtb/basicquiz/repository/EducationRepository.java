package com.thoughtworks.capability.gtb.basicquiz.repository;

import com.thoughtworks.capability.gtb.basicquiz.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM education WHERE user_id = :userId")
    List<Education> findAllByUserId(Long userId);

       // public static Map<Long, ArrayList<EducationDto>> educationMap = new HashMap<>();

  /*  public EducationDto education2educationDto (Education education,long userId){
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


    public List<EducationDto> getUserEducationsByUserId(long userId) throws UserNotFoundException {

        ArrayList<EducationDto> educationInfo = educationMap.get(userId);
        if (educationInfo == null) {
            throw new UserNotFoundException("User does not exist!");
        } else {
            return educationInfo.stream()
                    .sorted(Comparator.comparing(EducationDto::getYear).reversed())
                    .collect(Collectors.toList());
      *//*      Collections.sort(educationInfo, new Comparator<EducationDto>(){
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
            });*//*

        }
    }*/
}
