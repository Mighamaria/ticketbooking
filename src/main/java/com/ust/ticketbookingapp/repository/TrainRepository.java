package com.ust.ticketbookingapp.repository;

import com.ust.ticketbookingapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<TrainRepository,Long> {
}
