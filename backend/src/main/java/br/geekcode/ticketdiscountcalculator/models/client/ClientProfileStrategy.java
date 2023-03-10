package br.geekcode.ticketdiscountcalculator.models.client;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import org.springframework.stereotype.Component;

@Component
public interface ClientProfileStrategy {
    ClientProfile getClientProfile(Client client, ClientDto clientDto);
}
