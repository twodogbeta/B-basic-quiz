package com.thoughtworks.capability.gtb.basicquiz.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
public class Education {

    @NotNull
    private long year;
    @Size(min = 1,max = 256)
    private String title;
    @Size(min = 1,max = 4096)
    private String description;
}
