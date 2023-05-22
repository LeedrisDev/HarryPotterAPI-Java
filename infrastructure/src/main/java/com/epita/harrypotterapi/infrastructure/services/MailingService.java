package com.epita.harrypotterapi.infrastructure.services;

import com.epita.harrypotterapi.domain.models.Reservation;
import com.epita.harrypotterapi.domain.models.wizard.Wizard;
import com.epita.harrypotterapi.domain.services.IMailingService;
import org.springframework.stereotype.Service;

@Service
public class MailingService implements IMailingService {

    public void sendMailReservationCreated(Wizard recipient, Reservation reservation) {
        System.out.println("Sending mail to " + recipient.getEmail() + "...");
        System.out.println("Your reservation" + reservation.getId()
                + "has been created for the room " + reservation.getRoom().getName()
                + " from " + reservation.getBeginDate() + " to " + reservation.getEndDate() + ".");
        System.out.println("Thank you for using our services.");
    }

    public void sendMailReservationDeleted(Wizard recipient, Reservation reservation) {
        System.out.println("Sending mail to " + recipient.getEmail() + "...");
        System.out.println("We have the regret to inform you that your reservation" + reservation.getId()
                + "has been deleted for the room " + reservation.getRoom().getName()
                + " from " + reservation.getBeginDate() + " to " + reservation.getEndDate() + ".");
        System.out.println("We are sorry for the inconvenience.");
    }
}
