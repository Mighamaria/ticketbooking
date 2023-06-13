package com.ust.ticketbookingapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingConsumer {
    @KafkaListener(topics = "booking_confirmation_topic", groupId = "ticket-booking-group")
    public void receiveBookingConfirmation(String message) {
        // Process the booking confirmation message
        System.out.println("Received Booking Confirmation: " + message);
    }
}

