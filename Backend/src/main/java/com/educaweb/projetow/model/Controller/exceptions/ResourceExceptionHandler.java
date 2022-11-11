package com.educaweb.projetow.model.Controller.exceptions;

import com.educaweb.projetow.Services.exceptions.DataBaseException;
import com.educaweb.projetow.Services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;


/*A annotation indica que vai capturar as exceptions geradas*/
@ControllerAdvice
public class ResourceExceptionHandler {

      /*A annotation indica que Vai interceptar erro do tipo NotFound*/
      @ExceptionHandler(ResourceNotFoundException.class)
      public ResponseEntity<StandardError> CapturarErro (ResourceNotFoundException e, HttpServletRequest request){

          HttpStatus status= HttpStatus.NOT_FOUND;

          StandardError error = new StandardError();
          error.setTimestamp(Instant.now());
          error.setStatus(status.value());
          error.setError("Not Found");
          error.setMessage(e.getMessage());
          error.setPath(request.getRequestURI());

          return ResponseEntity.status(status).body(error);
      }



    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> DataBase (DataBaseException e, HttpServletRequest request){

          HttpStatus status= HttpStatus.BAD_REQUEST;

          StandardError error = new StandardError();
            error.setTimestamp(Instant.now());
            error.setStatus(status.value());
            error.setError("Database exception");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());

            return ResponseEntity.status(status).body(error);
    }










}
