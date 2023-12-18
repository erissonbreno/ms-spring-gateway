package com.br.edu.infnet.microservices.veiculoservice.exception;

public class VeiculoNotFoundException extends RuntimeException{
    public VeiculoNotFoundException() {
    }

    public VeiculoNotFoundException(String message) {
        super(message);
    }
}
