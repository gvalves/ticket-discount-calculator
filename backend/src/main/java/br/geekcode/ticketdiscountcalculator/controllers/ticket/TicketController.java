package br.geekcode.ticketdiscountcalculator.controllers.ticket;

import br.geekcode.ticketdiscountcalculator.controllers.ticket.dtos.ReqTicketDto;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileStrategy;
import br.geekcode.ticketdiscountcalculator.models.ticket.Ticket;
import br.geekcode.ticketdiscountcalculator.services.ticket.discount.TicketDiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {
    @Autowired
    @Qualifier("ticketDiscountServiceElderCard")
    private TicketDiscountService ticketDiscountService;
    @Autowired
    @Qualifier("clientProfileStrategyElderCard")
    private ClientProfileStrategy clientProfileStrategy;

    @PostMapping("/buy")
    public ResponseEntity<Ticket> getTicketWithDiscount(@RequestBody @Valid ReqTicketDto reqTicketDto) {
        var client = Client.create(reqTicketDto.getOwner(), clientProfileStrategy);

        var date = reqTicketDto.getScheduleDay() != null ? reqTicketDto.getScheduleDay() : LocalDate.now();
        var dayOfWeek = date.getDayOfWeek();
        var price = ticketDiscountService.calculateTicketPrice(client, dayOfWeek);

        var ticket = Ticket.create();
        ticket.setOwner(client);
        ticket.setPrice(price);

        return ResponseEntity.status(HttpStatus.OK).body(ticket);
    }
}
