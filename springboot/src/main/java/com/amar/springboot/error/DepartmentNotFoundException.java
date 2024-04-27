package com.amar.springboot.error;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException(){
        super();
    }

    public DepartmentNotFoundException(String exception){
        super(exception);
    }
    
}
