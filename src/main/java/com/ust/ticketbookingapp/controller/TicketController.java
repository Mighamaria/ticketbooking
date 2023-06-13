package com.ust.ticketbookingapp.controller;

import com.ust.ticketbookingapp.entity.Ticket;
import com.ust.ticketbookingapp.repository.TicketRepository;
import com.ust.ticketbookingapp.repository.TrainRepository;
import com.ust.ticketbookingapp.service.TicketBookingConsumer;
import com.ust.ticketbookingapp.service.TicketBookingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketBookingProducer ticketBookingProducer;

     @PostMapping("/login")
     public ResponseEntity<String> bookTicket(@RequestBody Ticket id) {
         // Save the ticket details to the database
         ticketRepository.save(id);

         // Send booking confirmation message
         ticketBookingProducer.sendBookingConfirmation("Ticket booked successfully!");

         return ResponseEntity.ok("Ticket booked successfully!");
     }

    // Update an existing ticket
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTicket(@PathVariable Long id, @RequestBody Ticket updatedTicket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatus(updatedTicket.getStatus());
            ticket.setId(updatedTicket.getId());

            ticketRepository.save(ticket);
            return ResponseEntity.ok("Ticket updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            ticketRepository.deleteById(id);
            return ResponseEntity.ok("Ticket deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


