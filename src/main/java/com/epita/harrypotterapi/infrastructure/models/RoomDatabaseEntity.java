package com.epita.harrypotterapi.infrastructure.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class RoomDatabaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private RoomType Type;
    private int area;
    private Date creationDate;
    private String creatorName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ReservationDatabaseEntity> reservations;
}
