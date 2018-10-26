package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
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

    // TODO 4
    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public ResponseEntity<Object> handleApiFailedException(NumberFormatException ex) {

        // TODO 5
        String message = messageSourceAccessor.getMessage("error.message");

        ErrorMessageDto errorMessageDto = new ErrorMessageDto(message, ex);
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
