package com.example.finalhotel.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {

    private String name;
    private int capacity;
    private int numberOfBeds;
    private int floor;
}