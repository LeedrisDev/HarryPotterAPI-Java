package com.epita.harrypotterapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class RoomDatabaseEntity {
    @Id private Long id;
    private String name;
    private RoomType Type;
    private int area;
    private Date creationDate;
    private String creatorName;
}
