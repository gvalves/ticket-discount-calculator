package br.geekcode.ticketdiscountcalculator.models.client.handlers;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileHandler;

public class ClientProfileElderHandler extends ClientProfileHandler {
    public ClientProfile handle(Client client, ClientDto clientDto) {
        if (client.getAge() >= 60) return ClientProfile.ELDER;
        return getNextHandler().handle(client, clientDto);
    }
}