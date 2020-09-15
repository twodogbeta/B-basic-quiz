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
    @NotBlank(message = "姓名不能为空")
    @Size(max = 16 ,message = "参数不合法：名字长度范围应为1 - 128 bytes")
    private String name;
    @NotNull(message = "年龄不能为空")
    @Min(value = 17, message = "参数不合法：年龄取值范围应该大于16")
    private long age;
    @NotBlank(message = "头像不能为空")
    @Size(min = 8, max = 512, message = "参数不合法:头像图片链接地址的度范围应为8 - 512 bytes")
    private String avatar;
    @Size(min = 0, max = 1024, message = "参数不合法:个人介绍信息长度范围应为0 - 1024 bytes")
    private String description;
}
