package com.sst.backend_services.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException{
    private long id;
     public ProductNotFoundException(long id,String message){
         super(message);
         this.id=id;
     }

    public String getMessage(String s) {
        return s;
    }
}
