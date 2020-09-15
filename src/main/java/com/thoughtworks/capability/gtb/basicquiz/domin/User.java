package com.thoughtworks.capability.gtb.basicquiz.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private String name;
    private long age;
    private String avatar;
    private String description;
}