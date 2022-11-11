package com.educaweb.projetow.Controller.exceptions;


import com.educaweb.projetow.Services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;


@ControllerAdvice
public class ResourceExceptionHandler {

        /*Vai interceptar qualquer erro do tipo NotFound*/
      @ExceptionHandler(ResourceNotFoundException.class)
      public ResponseEntity<StandardError> CapturarErro (ResourceNotFoundException e, HttpServletRequest request){

          String msg_erro = "Not Found";
          HttpStatus status= HttpStatus.NOT_FOUND;
          StandardError error = new StandardError(Instant.now(), status.value(), msg_erro, e.getMessage(), request.getRequestURI());

          return ResponseEntity.status(status).body(error);
      }





}
