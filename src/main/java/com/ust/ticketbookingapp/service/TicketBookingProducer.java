package com.ust.ticketbookingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendBookingConfirmation(String message) {
        kafkaTemplate.send("booking_confirmation_topic", message);
    }
}
