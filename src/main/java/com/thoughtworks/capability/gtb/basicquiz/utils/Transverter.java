package com.thoughtworks.capability.gtb.basicquiz.utils;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.domin.User;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.dto.UserDto;

public class Transverter {

    public static User UserDto2User(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .avatar(userDto.getAvatar())
                .description(userDto.getDescription())
                .build();
    }

    public static Education EducationDto2Education(EducationDto educationDto, User user) {
        return Education.builder()
                .user(user)
                .year(educationDto.getYear())
                .title(educationDto.getTitle())
                .description(educationDto.getDescription())
                .build();
    }
}
