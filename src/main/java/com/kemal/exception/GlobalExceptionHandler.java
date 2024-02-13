package com.kemal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static com.kemal.exception.ErrorType.BAD_REQUEST_ERROR;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> globalHandler(RuntimeException runtimeException) {

        return new ResponseEntity<>(createErrorMessage(runtimeException,ErrorType.INTERNAL_SERVER_ERROR)
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RandevuException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> RandevuHandler(RandevuException RandevuException){
        return new ResponseEntity<>(createErrorMessage(RandevuException,RandevuException.getErrorType()),
                RandevuException.getErrorType().getHttpStatus());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {

        ErrorType errorType = BAD_REQUEST_ERROR;
        List<String> fields = new ArrayList<>();
        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createErrorMessage(exception,errorType);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, errorType.getHttpStatus());
    }
    private ErrorMessage createErrorMessage(Exception exception,ErrorType errorType){
        System.out.println("Tüm hataların geçtiği nokta...: "+ exception.getMessage());
        return ErrorMessage.builder()
                .message(errorType.getMessage())
                .code(errorType.getCode())
                .build();
    }
}
