package com.thoughtworks.capability.gtb.basicquiz.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    private String time;
    private int status;
    private String error;
    private String message;
}
