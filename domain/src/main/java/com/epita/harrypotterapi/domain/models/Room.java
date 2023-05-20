package com.epita.harrypotterapi.domain.models;

import java.time.LocalDate;

public class Room {
    private String name;
    private RoomType type;
    private int area;
    private LocalDate creationDate;
    private String creatorName;
    private Boolean isBookable;

    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public Boolean getBookable() {
        return isBookable;
    }

    private Room() { }

    public static class Builder {
        private String name;
        private RoomType type;
        private int area;
        private LocalDate creationDate;
        private String creatorName;
        private Boolean isBookable;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(RoomType type) {
            this.type = type;
            switch (type) {
                case Potion, Spell, Herbology, Quidditch -> this.isBookable = true;
                case Office, CommonRoom -> this.isBookable = false;
            }
            return this;
        }

        public Builder area(int area) {
            this.area = area;
            return this;
        }

        public Builder creationDate(LocalDate creationDate) {
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
            room.isBookable = this.isBookable;
            return room;
        }
    }
}