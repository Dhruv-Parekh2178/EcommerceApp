package com.ecommerce.project.util;

import com.ecommerce.project.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ApiResponse> handleRuntime(HttpMessageNotReadableException ex){
//
////        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
////                .map(e -> e.getDefaultMessage())
////                .collect(Collectors.toList());
//        String errors = ex.getMessage();
//
//        ApiResponse response = new ApiResponse();
//        response.setCode(400);
//        response.setStatus(false);
//        Map<String,Object> error = new HashMap<>();
//        error.put("error",errors);
//        response.setData(error);
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }


}
