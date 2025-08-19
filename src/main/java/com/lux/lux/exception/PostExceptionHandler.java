package com.lux.lux.exception;

import com.lux.lux.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;


@RestControllerAdvice
public class PostExceptionHandler {

       @ExceptionHandler(NonTrovatoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError nonTrovatoExceptionHandler(NonTrovatoException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setDataErrore(LocalDate.now());

        return apiError;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError validationExHandler(ValidationException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setDataErrore(LocalDate.now());

        return apiError;
    }

}
