package com.epita.harrypotterapi.domain.aggregate.room;

import com.epita.harrypotterapi.domain.aggregate.reservation.ReservationAggregate;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class RoomAggregate {
    private int id;
    private String name;
    private RoomType type;
    private int area;
    private Date createdAt;
    private String createdBy;

    private Collection<ReservationAggregate> reservations;
}
