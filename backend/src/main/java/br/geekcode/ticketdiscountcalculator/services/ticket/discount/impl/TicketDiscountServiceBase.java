package br.geekcode.ticketdiscountcalculator.services.ticket.discount.impl;

import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.services.ticket.discount.TicketDiscountService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class TicketDiscountServiceBase implements TicketDiscountService {
    /*
    * Método que recebe um dia da semana e utiliza o cálculo para o respetivo dia
    * */
    public double calculateTicketPrice(Client client, DayOfWeek day) {
        return switch (day) {
            case MONDAY -> calculateTicketPriceForMonday(client);
            case TUESDAY -> calculateTicketPriceForTuesday(client);
            case WEDNESDAY -> calculateTicketPriceForWednesday(client);
            case THURSDAY -> calculateTicketPriceForThursday(client);
            case FRIDAY -> calculateTicketPriceForFriday(client);
            case SATURDAY, SUNDAY -> calculateTicketPriceForWeekendAndHoliday(client);
        };
    }

    /*
     * Calculo de disconto para segunda-feira
     * Retorna com disconto de:
     * 10% para criança, estudante, idoso
     * 35% para estudante com carterinha
     * */
    public double calculateTicketPriceForMonday(Client client) {
        return calculateTicketPriceForMonday(client.getProfile());
    }

    public double calculateTicketPriceForMonday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        var discountModifier = switch (profile) {
            case STUDENT_WITH_CARD -> 0.65;
            case NONE -> 1;
            default -> 0.9;
        };

        return ticketPrice * discountModifier;
    }

    /*
     * Calculo de disconto para terça-feira
     * Retorna com disconto de:
     * 15% para criança e idoso
     * 5% para estudante
     * 35% para estudante com carterinha
     * */
    public double calculateTicketPriceForTuesday(Client client) {
        return calculateTicketPriceForTuesday(client.getProfile());
    }

    public double calculateTicketPriceForTuesday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        double discountModifier = switch (profile) {
            case CHILD, ELDER -> 0.85;
            case STUDENT -> 0.95;
            case STUDENT_WITH_CARD -> 0.65;
            default -> 1;
        };

        return ticketPrice * discountModifier;
    }

    /*
    * Calculo de disconto para quarta-feira
    * Retorna com disconto de:
    * 30% para criança
    * 50% para estudante com ou sem carterinha
    * 40% para idoso
    * */
    public double calculateTicketPriceForWednesday(Client client) {
        return calculateTicketPriceForWednesday(client.getProfile());
    }

    public double calculateTicketPriceForWednesday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        double discountModifier = switch (profile) {
            case CHILD -> 0.70;
            case STUDENT, STUDENT_WITH_CARD -> 0.5;
            case ELDER -> 0.60;
            default -> 1;
        };

        return ticketPrice * discountModifier;
    }

    /*
     * Calculo de disconto para quinta-feira
     * Retorna com disconto de:
     * 30% para estudante e idoso
     * 35% para estudante com carterinha
     * */
    public double calculateTicketPriceForThursday(Client client) {
        return calculateTicketPriceForThursday(client.getProfile());
    }

    public double calculateTicketPriceForThursday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        double discountModifier = switch (profile) {
            case ELDER, STUDENT -> 0.7;
            case STUDENT_WITH_CARD -> 0.65;
            default -> 1;
        };

        return ticketPrice * discountModifier;
    }

    /*
     * Calculo de disconto para sexta-feira
     * Retorna com disconto de:
     * 11% para criança
     * 35% para estudante com carterinha
     * */
    public double calculateTicketPriceForFriday(Client client) {
        return calculateTicketPriceForFriday(client.getProfile());
    }

    public double calculateTicketPriceForFriday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        double discountModifier = switch (profile) {
            case CHILD -> 0.89;
            case STUDENT_WITH_CARD -> 0.65;
            default -> 1;
        };

        return ticketPrice * discountModifier;
    }

    /*
     * Calculo de disconto para feriados e final de semana
     * Retorna com disconto de:
     * 5% para idoso
     * */
    public double calculateTicketPriceForWeekendAndHoliday(Client client) {
        return calculateTicketPriceForWeekendAndHoliday(client.getProfile());
    }

    public double calculateTicketPriceForWeekendAndHoliday(ClientProfile profile) {
        var ticketPrice = profile.getTicketPrice();

        double discountModifier = switch (profile) {
            case ELDER -> 0.95;
            default -> 1;
        };

        return ticketPrice * discountModifier;
    }
}
