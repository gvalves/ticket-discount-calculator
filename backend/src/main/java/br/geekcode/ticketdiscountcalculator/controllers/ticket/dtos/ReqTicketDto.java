package br.geekcode.ticketdiscountcalculator.controllers.ticket.dtos;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ReqTicketDto {
    @NotNull
    private ClientDto owner;
    @FutureOrPresent
    private LocalDate scheduleDay;

    public ClientDto getOwner() {
        return owner;
    }

    public void setOwner(ClientDto owner) {
        this.owner = owner;
    }

    public LocalDate getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(LocalDate scheduleDay) {
        this.scheduleDay = scheduleDay;
    }
}

