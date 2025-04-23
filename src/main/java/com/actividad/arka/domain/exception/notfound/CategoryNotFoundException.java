package com.actividad.arka.domain.exception.notfound;

public class CategoryNotFoundException extends RuntimeException{
    //L: CategoryNotFoundException extiende de RuntimeException, y puede ser utilizada en cualquier lugar donde se espera una RuntimeException sin romper el comportamiento esperado del sistema
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
