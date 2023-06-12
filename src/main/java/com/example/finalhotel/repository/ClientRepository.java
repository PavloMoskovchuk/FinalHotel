package com.example.finalhotel.repository;

import com.example.finalhotel.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Client, Long> {


    Client findBySurname(String surname);

    Client findByPassport(String passport);

}
