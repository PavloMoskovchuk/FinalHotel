package com.example.finalhotel.rest;

import com.example.finalhotel.domain.Booking;
import com.example.finalhotel.dto.ReservationDto;
import com.example.finalhotel.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping("/reservation")
    public ResponseEntity<Void> save(@RequestBody Booking booking) {
        reservationService.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/reservation/{reservationId}/room/{roomId}")
    public ResponseEntity<Void> update(@PathVariable Long roomId, @PathVariable Long reservationId) {
        reservationService.changeRoom(roomId, reservationId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void delete(@PathVariable Long reservationId) {
        reservationService.deleteById(reservationId);
    }
}