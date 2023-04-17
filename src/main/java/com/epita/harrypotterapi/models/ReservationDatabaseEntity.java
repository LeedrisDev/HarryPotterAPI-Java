package com.epita.harrypotterapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ReservationDatabaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomDatabaseEntity room;
}
