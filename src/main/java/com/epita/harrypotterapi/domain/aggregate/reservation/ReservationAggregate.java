package com.epita.harrypotterapi.domain.aggregate.reservation;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationAggregate {
    private int id;
    private Date startDate;
    private Date endDate;
    private ReservationAggregate room;
}
