package com.epita.harrypotterapi.domain.services;

import com.epita.harrypotterapi.domain.models.wizard.Wizard;

public interface IMailingService {
    void sendMail(Wizard recipient);
}
