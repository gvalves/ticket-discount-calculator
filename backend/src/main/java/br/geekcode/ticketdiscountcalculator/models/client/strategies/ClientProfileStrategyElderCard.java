package br.geekcode.ticketdiscountcalculator.models.client.strategies;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileHandler;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileStrategy;
import br.geekcode.ticketdiscountcalculator.models.client.handlers.ClientProfileChildHandler;
import br.geekcode.ticketdiscountcalculator.models.client.handlers.ClientProfileElderCardHandler;
import br.geekcode.ticketdiscountcalculator.models.client.handlers.ClientProfileStudentCardHandler;
import org.springframework.stereotype.Component;

@Component
public class ClientProfileStrategyElderCard implements ClientProfileStrategy {
    public ClientProfile getClientProfile(Client client, ClientDto clientDto) {
        var handler = ClientProfileHandler.create();

        handler
                .use(ClientProfileChildHandler.class)
                .use(ClientProfileElderCardHandler.class)
                .use(ClientProfileStudentCardHandler.class);

        return handler.handle(client, clientDto);
    }
}
