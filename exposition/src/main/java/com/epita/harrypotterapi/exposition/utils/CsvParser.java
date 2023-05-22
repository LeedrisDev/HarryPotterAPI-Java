package com.epita.harrypotterapi.exposition.utils;

import com.epita.harrypotterapi.domain.exceptions.RoomException;
import com.epita.harrypotterapi.domain.models.room.Room;
import com.epita.harrypotterapi.domain.models.room.RoomType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvParser {

    public List<Room> parseCsv(MultipartFile file, String creatorName) throws RoomException, IOException {
        var rooms = new ArrayList<Room>();

        if (file.isEmpty())
            throw new RoomException("File is empty");


        var inputStream = file.getInputStream();
        var reader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            lineCount++;
            var values = line.split(";");

            if (values.length != 3)
                throw new RoomException("Invalid file format (expected 3 values per line separated by ';')");

            var name = values[0].trim();
            var type = values[1].trim();
            var area = parseDouble(values[2].trim(), lineCount);

            checkType(type, name, lineCount);

            var room = new Room.Builder()
                    .name(name)
                    .type(RoomType.valueOf(type))
                    .area(area)
                    .creationDate(LocalDate.now())
                    .creatorName(creatorName)
                    .build();

            rooms.add(room);
        }

        return rooms;
    }

    private double parseDouble(String value, int line) throws RoomException {
        try {
            return Double.parseDouble(value);
        }
        catch (Exception e) {
            throw new RoomException("Invalid area value at line " + line + " (expected a double)");
        }
    }

    private void checkType(String type, String roomName, int line) throws RoomException {
        try {
            RoomType.valueOf(type);
        }
        catch (IllegalArgumentException e) {
            throw new RoomException("Invalid room type for room " + roomName + " at line " + line + " (expected a valid room type)");
        }
    }
}
