package br.geekcode.ticketdiscountcalculator.services.ticket.discount.impl;

import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.services.ticket.discount.TicketDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

@Service
public class TicketDiscountServiceElderCard implements TicketDiscountService {
    @Autowired
    private TicketDiscountService ticketDiscountServiceBase;

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

    public double calculateTicketPriceForMonday(Client client) {
        return calculateTicketPriceForMonday(client.getProfile());
    }

    public double calculateTicketPriceForMonday(ClientProfile profile) {
        var price = ticketDiscountServiceBase.calculateTicketPriceForMonday(profile);
        var priceForElder = ticketDiscountServiceBase.calculateTicketPriceForMonday(ClientProfile.ELDER);
        var priceForElderCard = profile.getTicketPrice() * 0.9;

        if (profile == ClientProfile.ELDER_WITH_CARD) {
            return Math.min(priceForElder, priceForElderCard);
        }
        return price;
    }

    public double calculateTicketPriceForTuesday(Client client) {
        return calculateTicketPriceForTuesday(client.getProfile());
    }

    public double calculateTicketPriceForTuesday(ClientProfile profile) {
        var price = ticketDiscountServiceBase.calculateTicketPriceForTuesday(profile);
        var priceForElder = ticketDiscountServiceBase.calculateTicketPriceForTuesday(ClientProfile.ELDER);
        var priceForElderCard = profile.getTicketPrice() * 0.9;

        if (profile == ClientProfile.ELDER_WITH_CARD) {
            return Math.min(priceForElder, priceForElderCard);
        }
        return price;
    }

    public double calculateTicketPriceForWednesday(Client client) {
        return calculateTicketPriceForWednesday(client.getProfile());
    }

    public double calculateTicketPriceForWednesday(ClientProfile profile) {
        var price = ticketDiscountServiceBase.calculateTicketPriceForWednesday(profile);
        var priceForElder = ticketDiscountServiceBase.calculateTicketPriceForWednesday(ClientProfile.ELDER);
        var priceForElderCard = profile.getTicketPrice() * 0.9;

        if (profile == ClientProfile.ELDER_WITH_CARD) {
            return Math.min(priceForElder, priceForElderCard);
        }
        return price;
    }

    public double calculateTicketPriceForThursday(Client client) {
        return calculateTicketPriceForThursday(client.getProfile());
    }

    public double calculateTicketPriceForThursday(ClientProfile profile) {
        var price = ticketDiscountServiceBase.calculateTicketPriceForThursday(profile);
        var priceForElder = ticketDiscountServiceBase.calculateTicketPriceForThursday(ClientProfile.ELDER);
        var priceForElderCard = profile.getTicketPrice() * 0.9;

        if (profile == ClientProfile.ELDER_WITH_CARD) {
            return Math.min(priceForElder, priceForElderCard);
        }
        return price;
    }

    public double calculateTicketPriceForFriday(Client client) {
        return calculateTicketPriceForFriday(client.getProfile());
    }

    public double calculateTicketPriceForFriday(ClientProfile profile) {
        var price = ticketDiscountServiceBase.calculateTicketPriceForFriday(profile);
        var priceForElder = ticketDiscountServiceBase.calculateTicketPriceForFriday(ClientProfile.ELDER);
        var priceForElderCard = profile.getTicketPrice() * 0.9;

        if (profile == ClientProfile.ELDER_WITH_CARD) {
            return Math.min(priceForElder, priceForElderCard);
        }
        return price;
    }

    public double calculateTicketPriceForWeekendAndHoliday(Client client) {
        return ticketDiscountServiceBase.calculateTicketPriceForWeekendAndHoliday(client);
    }

    public double calculateTicketPriceForWeekendAndHoliday(ClientProfile profile) {
        return ticketDiscountServiceBase.calculateTicketPriceForWeekendAndHoliday(profile);
    }
}
