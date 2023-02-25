package br.geekcode.ticketdiscountcalculator.enums;

import br.geekcode.ticketdiscountcalculator.models.Client;

public enum ClientProfiles {
    NONE(8),
    CHILD(5.5),
    STUDENT(8),
    STUDENT_WITH_CARD(8),

    ELDER(6);

    private double ticketPrice;

    ClientProfiles(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /*
    * Pega o perfil usando a classe cliente
    * Um cliente com menos de 11 anos é considerado criança
    * Um cliente com pelo menos 60 anos é considerado idoso
    * E por último e verificado os perfis de estudante com ou sem carterinha
    * */
    public static ClientProfiles fromClient(Client client) {
        if (client.getAge() <= 10) return CHILD;
        if (client.getAge() >= 60) return ELDER;
        if (client.isStudent()) {
            if (client.isStudentCard()) return STUDENT_WITH_CARD;
            return STUDENT;
        }
        return NONE;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
