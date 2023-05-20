package com.epita.harrypotterapi.domain.models;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;

import java.time.LocalDate;

public class Reservation {
    private Room room;
    private LocalDate beginDate;
    private LocalDate endDate;

    public Room getRoom() {
        return room;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private Reservation() { }

    public static class Builder {
        private Room room;
        private LocalDate beginDate;
        private LocalDate endDate;

        public Builder room(Room room, Boolean toBookReservation) throws ReservationException {
            switch (room.getType()) {
                case CommonRoom, Office ->
                        throw new ReservationException("Petrificus Totalus ! You can't reserve this room ! " +
                                "Only Potion, Spell, Herbology and Quidditch rooms are bookable.");
                default -> {
                    this.room = room;
                    return this;
                }
            }
        }

        public Builder room(Room room) throws ReservationException {
            this.room(room, false);
            return this;
        }

        public Builder beginDate(LocalDate beginDate) throws ReservationException {
            var now = LocalDate.now();
            var maxReservationDate = now.plusMonths(1);

            if (beginDate.isAfter(maxReservationDate))
                throw new ReservationException("You can't reserve a room more than one month in advance !");

            if (beginDate.isBefore(now))
                throw new ReservationException("You can't reserve a room in the past ! " +
                        "Usage of Time-Turners is strictly prohibited");

            this.beginDate = beginDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) throws ReservationException {
            if (endDate.isBefore(this.beginDate))
                throw new ReservationException("Begin date must be before end date ! This magic doesn't exist yet !");

            this.endDate = endDate;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.room = this.room;
            reservation.beginDate = this.beginDate;
            reservation.endDate = this.endDate;
            return reservation;
        }
    }
}