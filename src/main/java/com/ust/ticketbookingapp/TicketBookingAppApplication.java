package com.ust.ticketbookingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication

public class TicketBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingAppApplication.class, args);
	}

}
