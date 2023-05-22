package com.epita.harrypotterapi.domain.services;

import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.models.wizard.Wizard;

public interface IMailingService {
    void sendMailReservationCreated(Wizard recipient, Reservation reservation);
    void sendMailReservationDeleted(Wizard recipient, Reservation reservation);
}
