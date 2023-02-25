package br.geekcode.ticketdiscountcalculator.models;

public class Ticket {
    private Client owner;
    private double price;

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
