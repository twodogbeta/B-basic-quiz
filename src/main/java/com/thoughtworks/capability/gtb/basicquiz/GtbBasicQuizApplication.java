package com.thoughtworks.capability.gtb.basicquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// GTB: + 文件组织合理
// GTB: + 使用了自定义的 Repository
// GTB: + 有单独的 EducationDto

@SpringBootApplication
public class GtbBasicQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtbBasicQuizApplication.class, args);
	}

}
