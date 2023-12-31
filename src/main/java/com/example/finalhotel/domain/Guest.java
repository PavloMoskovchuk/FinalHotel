package com.example.finalhotel.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"phone", "passport"})})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String passport;

    @Column
    private String phone;
    @Column
    private String sex;


    @OneToMany(mappedBy = "guestId")
    private List<Booking> booking;
}