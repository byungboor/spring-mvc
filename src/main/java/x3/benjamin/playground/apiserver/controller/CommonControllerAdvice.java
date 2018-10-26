package x3.benjamin.playground.apiserver.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import x3.benjamin.playground.apiserver.exception.ApiValidationException;
import x3.benjamin.playground.apiserver.model.ErrorMessageDto;

import java.util.Random;


@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<Object> handleApiFailedException(NumberFormatException ex) {

        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage(), ex);
        HttpHeaders headers = new HttpHeaders();
        headers.add("transaction-id", String.valueOf(new Random().nextInt()));


        return new ResponseEntity(errorMessageDto, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ApiValidationException.class)
    @ResponseBody
    public ResponseEntity<Object> handleApiValidationException(ApiValidationException ex) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage(), ex);
        return new ResponseEntity(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
