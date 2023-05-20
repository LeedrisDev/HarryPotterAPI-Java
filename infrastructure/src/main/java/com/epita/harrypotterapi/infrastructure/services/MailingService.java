package com.epita.harrypotterapi.infrastructure.services;

import com.epita.harrypotterapi.domain.models.wizard.Wizard;
import com.epita.harrypotterapi.domain.services.IMailingService;

public class MailingService implements IMailingService {

    public void sendMail(Wizard recipient) {
        System.out.println("Sending mail to " + recipient.getEmail() + "...");
    }
}
