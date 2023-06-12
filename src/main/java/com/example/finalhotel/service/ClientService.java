package com.example.finalhotel.service;

import com.example.finalhotel.domain.Guest;
import com.example.finalhotel.dto.ClientDto;
import com.example.finalhotel.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map((Guest guest) -> buildClientDto(guest))
                .collect(Collectors.toList());
    }

    public void save(Guest guest) {
        clientRepository.save(guest);
    }
    private static ClientDto buildClientDto(Guest guest) {

        return ClientDto.builder()
                .name(guest.getName())
                .surname(guest.getSurname())
                .passport(guest.getPassport())
                .phone(guest.getPhone())
                .sex(guest.getSex())
                .reservationsId(guest.getBooking()
                        .stream()
                        .map(reservation -> reservation.getId())
                        .collect(Collectors.toList()))
                .build();
    }
    public ClientDto findBySurname(String surname) {
        return buildClientDto(clientRepository.findBySurname(surname));
    }

    public ClientDto findByPassport(String passport) {
        return buildClientDto(clientRepository.findByPassport(passport));
    }

    public Guest findById(Long id) {
        return clientRepository.findById(id).get();
    }
}