package com.company.certification.reto.exceptions;

public class ExpectedResultErr extends AssertionError {

    public static final String EXPECTED_RESULT = "The expected result is not successful";

    public ExpectedResultErr(String mensaje) {super(mensaje); }
    public ExpectedResultErr(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
