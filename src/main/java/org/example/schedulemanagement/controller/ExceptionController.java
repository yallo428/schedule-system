package org.example.schedulemanagement.controller;


import org.example.exception.EntityValueNullCheckException;
import org.example.exception.PasswordMatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(PasswordMatchException.class)
    public ResponseEntity<String> errorHandler(){
        return new ResponseEntity<>("비밀번호가 일치하지 않습니다", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<String> dtoNullHandler(){
        return new ResponseEntity<>("올바르지 않은 형태입니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> parameterNullHandler(){
        return new ResponseEntity<>("비밀번호가 입력되지 않았습니다.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityValueNullCheckException.class)
    public ResponseEntity<String> nullPointerHandler(){
        return new ResponseEntity<>("입력된 데이터가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
    }
}
