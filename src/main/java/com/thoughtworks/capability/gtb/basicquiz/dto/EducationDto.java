package com.thoughtworks.capability.gtb.basicquiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EducationDto {
    private long year;
    private String title;
    private String description;
}
