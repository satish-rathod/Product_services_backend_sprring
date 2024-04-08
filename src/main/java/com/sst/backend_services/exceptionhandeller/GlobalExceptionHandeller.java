package com.sst.backend_services.exceptionhandeller;

import com.sst.backend_services.DTOs.ExceptionDto;
import com.sst.backend_services.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeller {

        @ExceptionHandler(Exception.class)
        public String handleException(Exception e){
            return e.getMessage();
        }

        @ExceptionHandler(ProductNotFoundException.class)
        public ResponseEntity handleProductNotFoundException (ProductNotFoundException e){
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.setMessage(e.getMessage("Invalid product id"+e.getId()+" provided"));
            exceptionDto.setResolution("Please try again with a valid product id");
            return new ResponseEntity(exceptionDto, HttpStatus.NOT_FOUND);
        }

}
