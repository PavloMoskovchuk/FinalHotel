package com.example.finalhotel.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private String name;
    private String surname;
    private String passport;
    private String phone;
    private String sex;
    private List<Long> reservationsId;

}
