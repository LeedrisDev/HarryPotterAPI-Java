package com.epita.harrypotterapi.domain.exceptions;

public class UnknownWizardException  extends ApplicationException {
    public UnknownWizardException() {
        super();
    }

    public UnknownWizardException(String message) {
        super(message);
    }

    public UnknownWizardException(String message, Throwable cause) {
        super(message, cause);
    }
}
