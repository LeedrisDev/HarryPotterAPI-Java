package com.epita.harrypotterapi.domain.exceptions;

public class RoomException extends ApplicationException {
    public RoomException() {
        super();
    }

    public RoomException(String message) {
        super(message);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
