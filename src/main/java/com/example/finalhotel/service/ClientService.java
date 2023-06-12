package com.example.finalhotel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestService {

//    private final GuestRepository guestRepository;
//
//    public List<GuestDto> findAll() {
//        return guestRepository.findAll().stream()
//                .map((Guest guest) -> buildGuestDto(guest))
//                .collect(Collectors.toList());
//    }
//
//    public void save(Guest guest) {
//        guestRepository.save(guest);
//    }
//    private static GuestDto buildGuestDto(Guest guest) {
//        return GuestDto.builder()
//                .name(guest.getName())
//                .surname(guest.getSurname())
//                .passport(guest.getPassport())
//                .phone(guest.getPhone())
//                .sex(guest.getSex())
//                .reservationsId(guest.getReservation()
//                        .stream()
//                        .map(reservation -> reservation.getId())
//                        .collect(Collectors.toList()))
//                .build();
//    }
//    public GuestDto findBySurname(String surname) {
//        return buildGuestDto(guestRepository.findBySurname(surname));
//    }
//    public GuestDto findByPassport(String passport) {
//        return buildGuestDto(guestRepository.findByPassport(passport));
//    }
//    public Guest findById(Long id) {
//        return guestRepository.findById(id).get();
//    }
}