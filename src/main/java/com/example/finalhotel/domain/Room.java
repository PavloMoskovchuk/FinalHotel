package com.example.finalhotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.List;

@Data
@Table(name = "room",uniqueConstraints = { @UniqueConstraint(columnNames = { "name"}) })
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private int floor;
    @Column
    private int numberOfBeds;
    @Column
    private int capacity;

    @OneToMany(mappedBy = "roomId")
    private List<Booking> booking;


}