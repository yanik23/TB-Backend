package com.bokafood.tbbackend.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ErrorResponse class representing the error response in the API.
 * Inspired from : https://www.udemy.com/course/the-complete-spring-boot-development-bootcamp/
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Getter
@Setter
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private List<String> message;

    public ErrorResponse(List<String> message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
