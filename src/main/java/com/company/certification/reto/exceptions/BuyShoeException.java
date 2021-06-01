package com.company.certification.reto.exceptions;

public class BuyShoeException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BuyShoeException(Exception e) {
        super(e);
    }

}
