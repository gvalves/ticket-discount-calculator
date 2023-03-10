package br.geekcode.ticketdiscountcalculator.models.client.handlers;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileHandler;

public class ClientProfileChildHandler extends ClientProfileHandler {
    public ClientProfile handle(Client client, ClientDto clientDto) {
        if (client.getAge() <= 10) return ClientProfile.CHILD;
        return getNextHandler().handle(client, clientDto);
    }
}
