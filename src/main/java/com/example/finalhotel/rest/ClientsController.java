package com.example.finalhotel.rest;

import com.example.finalhotel.domain.Guest;
import com.example.finalhotel.dto.ClientDto;
import com.example.finalhotel.service.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientsController {

    @Autowired
    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping("/clients")
    public ResponseEntity<Void> save(@RequestBody Guest guest) {
        clientService.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/client/passport/{passport}")
    public ResponseEntity<ClientDto> findByPassport(@PathVariable String passport) {
        try {
            return ResponseEntity.ok(clientService.findByPassport(passport));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/client/surname/{surname}")
    public ResponseEntity<ClientDto> findBySurname(@PathVariable String surname) {
        try {
            return ResponseEntity.ok(clientService.findBySurname(surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientsDto) {
        Guest guest = clientService.findById(id);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        guest.setName(clientsDto.getName());
        guest.setSurname(clientsDto.getSurname());
        guest.setPassport(clientsDto.getPassport());
        clientService.save(guest);
        return ResponseEntity.ok().build();
    }
}
