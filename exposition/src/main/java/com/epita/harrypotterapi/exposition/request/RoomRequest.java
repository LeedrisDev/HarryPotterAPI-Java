package com.epita.harrypotterapi.exposition.request;

import java.util.Date;

public class RoomRequest {
    private String name;
    private String type;
    private int area;
    private Date createdAt;
    private String createdBy;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}
