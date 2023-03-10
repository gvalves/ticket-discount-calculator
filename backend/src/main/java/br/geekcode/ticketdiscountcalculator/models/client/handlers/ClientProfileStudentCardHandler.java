package br.geekcode.ticketdiscountcalculator.models.client.handlers;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileHandler;

public class ClientProfileStudentCardHandler extends ClientProfileHandler {
    public ClientProfile handle(Client client, ClientDto clientDto) {
        if (clientDto.isStudent()) {
            if (clientDto.isStudentCard()) return ClientProfile.STUDENT_WITH_CARD;
            return ClientProfile.STUDENT;
        }
        return getNextHandler().handle(client, clientDto);
    }
}
