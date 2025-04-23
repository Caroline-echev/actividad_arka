package com.actividad.arka.domain.exception.notfound;

public class ProductNotFoundException extends RuntimeException{
    //L: ProductNotFoundException extiende de RuntimeException, y puede ser utilizada en cualquier lugar donde se espera una RuntimeException sin romper el comportamiento esperado del sistema
    public ProductNotFoundException(String message) {
        super(message);
    }
}
