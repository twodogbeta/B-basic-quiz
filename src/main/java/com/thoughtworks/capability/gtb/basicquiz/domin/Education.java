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

    private long year;
    @Size(min = 1,max = 256, message = "参数不合法：教育经历标题的长度范围应在1 - 256 bytes")
    private String title;
    @Size(min = 1,max = 4096, message = "参数不合法：教育经历描述的长度范围应在1 - 4096 bytes")
    private String description;
}
