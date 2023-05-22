package com.epita.harrypotterapi.domain.models;

import com.epita.harrypotterapi.domain.exceptions.ReservationException;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.models.wizard.Wizard;

import java.time.LocalDate;

public class Reservation {
    private long id;
    private Room room;
    private Wizard reservedBy;
    private LocalDate beginDate;
    private LocalDate endDate;

    public long getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public Wizard getReservedBy() {
        return reservedBy;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private Reservation() { }

    public static class Builder {
        private long id = 0;
        private Room room;
        private Wizard reservedBy;
        private LocalDate beginDate;
        private LocalDate endDate;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder room(Room room, Boolean toBookReservation) throws ReservationException {
            if (toBookReservation) {
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

            this.room = room;
            return this;
        }

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        public Builder reservedBy(Wizard guest) {
            this.reservedBy = guest;
            return this;
        }

        public Builder beginDate(LocalDate beginDate, Boolean toBookReservation) throws ReservationException {
            if (toBookReservation) {
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

            this.beginDate = beginDate;
            return this;
        }

        public Builder beginDate(LocalDate beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public Builder endDate(LocalDate endDate, Boolean toBookReservation) throws ReservationException {
            if (toBookReservation) {
                if (endDate.isBefore(this.beginDate))
                    throw new ReservationException("Begin date must be before end date ! This magic doesn't exist yet !");

                this.endDate = endDate;
                return this;
            }

            this.endDate = endDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.id = this.id;
            reservation.room = this.room;
            reservation.reservedBy = this.reservedBy;
            reservation.beginDate = this.beginDate;
            reservation.endDate = this.endDate;
            return reservation;
        }
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", room=" + room +
                ", reservedBy=" + reservedBy +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
