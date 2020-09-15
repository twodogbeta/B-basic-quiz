package com.thoughtworks.capability.gtb.basicquiz.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EducationDto {
    long userId;
    private long year;
    private String title;
    private String description;
}
