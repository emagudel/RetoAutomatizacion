package com.company.certification.reto.exceptions;

public class BuyArticleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BuyArticleException(Exception e) {
        super(e);
    }

}
