package com.example.finalhotel.service;

import com.example.finalhotel.domain.Booking;
import com.example.finalhotel.dto.ReservationDto;
import com.example.finalhotel.repository.ReservationRepository;
import com.example.finalhotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationService::buildReservationListDto)
                .collect(Collectors.toList());
    }

    private static ReservationDto buildReservationListDto(Booking booking) {
        return ReservationDto.builder()
                .orderDate(booking.getOrderDate())
                .checkIn(booking.getCheckIn())
                .checkOut(booking.getCheckOut())
                .roomName(booking.getRoomId().getName())
                .clientName(booking.getGuestId().getName())
                .build();
    }

    public void save(Booking booking) {

        booking.setOrderDate(new Date());


        if (isReserveExists(booking)) {
            throw new IllegalArgumentException("Reservation already exists");

        } else {
            reservationRepository.save(booking);
        }
    }

    private boolean isReserveExists(Booking booking) {
        return reservationRepository.existsByRoomIdAndCheckInAndCheckOut(
                booking.getRoomId(), booking.getCheckIn(), booking.getCheckOut());
    }

    public void changeRoom(Long roomId, Long reservationId) {

        var reservation = reservationRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoomId(room);

        if (isReserveExists(reservation)) {
            throw new IllegalArgumentException("Reservation already exists");

        } else {
            reservationRepository.save(reservation);
        }
    }


    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
