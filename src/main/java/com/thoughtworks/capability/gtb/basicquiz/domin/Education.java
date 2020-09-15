package com.thoughtworks.capability.gtb.basicquiz.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Education {
    private long year;
    private String title;
    private String description;
}
