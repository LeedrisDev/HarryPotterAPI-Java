package com.epita.harrypotterapi.infrastructure.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_RESERVATIONS")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @ManyToOne
    @JoinColumn(name = "wizard_id")
    private WizardEntity wizard;
    private LocalDate beginDate;
    private LocalDate endDate;

    public ReservationEntity() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public WizardEntity getWizard() {
        return wizard;
    }

    public void setWizard(WizardEntity wizard) {
        this.wizard = wizard;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReservationEntity{" +
                "id=" + id +
                ", room=" + room +
                ", wizard=" + wizard +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
