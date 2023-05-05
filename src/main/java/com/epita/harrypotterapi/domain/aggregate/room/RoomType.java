package com.epita.harrypotterapi.domain.aggregate.room;

public enum RoomType {
    COMMON_ROOM,
    HERBOLOGY,
    OFFICE,
    POTION,
    QUIDDITCH,
    SPELL;


    @Override
    public String toString() {
        return switch (this) {
            case COMMON_ROOM -> "Salle commune";
            case HERBOLOGY -> "Botanique";
            case OFFICE -> "Bureau";
            case POTION -> "Potion";
            case QUIDDITCH -> "Quidditch";
            case SPELL -> "Sortilège";
        };
    }

    public static RoomType fromString(String type) throws IllegalArgumentException {
        return switch (type) {
            case "Salle commune" -> COMMON_ROOM;
            case "Botanique" -> HERBOLOGY;
            case "Bureau" -> OFFICE;
            case "Potion" -> POTION;
            case "Quidditch" -> QUIDDITCH;
            case "Sortilège" -> SPELL;
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        };
    }
}