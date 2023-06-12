package com.example.finalhotel.repository;

import com.example.finalhotel.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Guest, Long> {
    Guest findBySurname(String surname);

    Guest findByPassport(String passport);
}
