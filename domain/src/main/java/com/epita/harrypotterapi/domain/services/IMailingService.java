package com.epita.harrypotterapi.domain.services;

import com.epita.harrypotterapi.domain.models.Wizard;

public interface IMailingService {
    void sendMail(Wizard recipient);
}
