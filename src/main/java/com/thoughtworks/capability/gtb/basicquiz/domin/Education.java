package com.thoughtworks.capability.gtb.basicquiz.domin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thoughtworks.capability.gtb.basicquiz.utils.UserSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private long year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonSerialize(using = UserSerializer.class)
    @JsonProperty(value = "userId")
    private User user;
    @Size(min = 1,max = 256, message = "参数不合法：教育经历标题的长度范围应在1 - 256 bytes")
    private String title;
    @Size(min = 1,max = 4096, message = "参数不合法：教育经历描述的长度范围应在1 - 4096 bytes")
    private String description;
}
