package com.epita.harrypotterapi.exposition.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoomRequest {
    private String name;
    private String type;
    private int area;
    private Date createdAt;
    private String createdBy;
}
