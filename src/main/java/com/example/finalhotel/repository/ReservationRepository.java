package com.example.finalhotel.repository;

import com.example.finalhotel.domain.Booking;
import com.example.finalhotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT CASE WHEN COUNT(rl) > 0 THEN true ELSE false END FROM Booking rl " +
            "WHERE rl.roomId = :roomId " +
            "AND rl.checkIn = :checkIn " +
            "AND rl.checkOut = :checkOut")
    boolean existsByRoomIdAndCheckInAndCheckOut(
            @Param("roomId") Room roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut);
}
