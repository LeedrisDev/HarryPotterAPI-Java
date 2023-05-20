package com.epita.harrypotterapi.domain.exceptions;

public class ReservationException extends ApplicationException {
    public ReservationException() {
        super();
    }

    public ReservationException(String message) {
        super(message);
    }

    public ReservationException(String message, Throwable cause) {
        super(message, cause);
    }
}
