package com.thoughtworks.capability.gtb.basicquiz.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
public class User {
    private long id;
    @NotBlank
    @Size(max = 16)
    private String name;
    @NotNull
    @Min(17)
    private long age;
    @NotBlank
    @Size(min = 8, max = 512)
    private String avatar;
    @Size(min = 0, max = 1024)
    private String description;
}
