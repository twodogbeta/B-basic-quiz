package com.thoughtworks.capability.gtb.basicquiz.api;

import com.thoughtworks.capability.gtb.basicquiz.domin.Education;
import com.thoughtworks.capability.gtb.basicquiz.dto.EducationDto;
import com.thoughtworks.capability.gtb.basicquiz.exception.UserNotFoundException;
import com.thoughtworks.capability.gtb.basicquiz.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public Long addUserEducationInfoByUserId(@PathVariable Long id,
                                             @RequestBody @Valid Education education) throws UserNotFoundException {
       return educationService.addUserEducationsByUserId(id, education);
    }

    @GetMapping("/{id}/educations")
    public ArrayList<EducationDto> getUserEducationInfoById(@PathVariable Long id) throws UserNotFoundException {
        return educationService.getUserEducationsByUserId(id);
    }

}
