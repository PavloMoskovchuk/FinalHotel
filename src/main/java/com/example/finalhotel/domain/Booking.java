package com.example.finalhotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.Date;

@Data
@Table(name = "reservation")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EnableScheduling
@EnableTransactionManagement

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "checkIn")
    @Temporal(TemporalType.DATE)
    private LocalDate checkIn;

    @Column(name = "checkOut")
    @Temporal(TemporalType.DATE)
    private LocalDate checkOut;

    @Column(name = "orderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Guest guestId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;


}
