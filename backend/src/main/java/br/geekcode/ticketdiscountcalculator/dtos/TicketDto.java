package br.geekcode.ticketdiscountcalculator.dtos;

import br.geekcode.ticketdiscountcalculator.models.Client;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TicketDto {
    @NotNull
    private Client owner;
    @FutureOrPresent
    private LocalDate scheduleDay;

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public LocalDate getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(LocalDate scheduleDay) {
        this.scheduleDay = scheduleDay;
    }
}

