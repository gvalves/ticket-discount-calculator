package br.geekcode.ticketdiscountcalculator.enums;

public enum ClientProfile {
    NONE(8),
    CHILD(5.5),
    STUDENT(8),
    STUDENT_WITH_CARD(8),
    ELDER(6),
    ELDER_WITH_CARD(6);

    private double ticketPrice;

    ClientProfile(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
