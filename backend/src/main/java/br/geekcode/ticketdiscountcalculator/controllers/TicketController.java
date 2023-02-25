package br.geekcode.ticketdiscountcalculator.controllers;

import br.geekcode.ticketdiscountcalculator.dtos.TicketDto;
import br.geekcode.ticketdiscountcalculator.models.Client;
import br.geekcode.ticketdiscountcalculator.models.Ticket;
import br.geekcode.ticketdiscountcalculator.services.TicketDiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {
    @Autowired
    private TicketDiscountService ticketDiscountService;

    @PostMapping("/buy")
    public ResponseEntity<Ticket> getTicketWithDiscount(@RequestBody @Valid TicketDto ticketDto) {
        Client client = new Client();
        Ticket ticket = new Ticket();

        LocalDate date = ticketDto.getScheduleDay() != null ? ticketDto.getScheduleDay() : LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        BeanUtils.copyProperties(ticketDto.getOwner(), client);
        ticket.setOwner(client);
        ticket.setPrice(ticketDiscountService.calculateTicketPrice(client, dayOfWeek));

        return ResponseEntity.status(HttpStatus.OK).body(ticket);
    }
}
