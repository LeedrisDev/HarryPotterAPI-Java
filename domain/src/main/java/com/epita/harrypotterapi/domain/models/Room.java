package com.epita.harrypotterapi.domain.models;

import java.util.Date;

public class Room {
    private String name;
    private RoomType type;
    private int area;
    private Date creationDate;
    private String creatorName;

    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCreatorName() {
        return creatorName;
    }

    private Room() { }

    public static class Builder {
        private String name;
        private RoomType type;
        private int area;
        private Date creationDate;
        private String creatorName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(RoomType type) {
            this.type = type;
            return this;
        }

        public Builder area(int area) {
            this.area = area;
            return this;
        }

        public Builder creationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder creatorName(String creatorName) {
            this.creatorName = creatorName;
            return this;
        }

        public Room build() {
            Room room = new Room();
            room.name = this.name;
            room.type = this.type;
            room.area = this.area;
            room.creationDate = this.creationDate;
            room.creatorName = this.creatorName;
            return room;
        }
    }
}