package br.geekcode.ticketdiscountcalculator.models.ticket;

import br.geekcode.ticketdiscountcalculator.models.client.Client;

public class Ticket {
    private Client owner;
    private double price;

    public static Ticket create() {
        var ticket = new Ticket();
        return ticket;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
