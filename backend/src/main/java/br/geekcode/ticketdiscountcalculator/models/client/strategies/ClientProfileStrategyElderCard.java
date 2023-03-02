package br.geekcode.ticketdiscountcalculator.models.client.strategies;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientProfileStrategyElderCard implements ClientProfileStrategy {
    @Autowired
    private ClientProfileStrategy clientProfileStrategyBase;

    public ClientProfile getClientProfile(Client client, ClientDto clientDto) {
        var profile = clientProfileStrategyBase.getClientProfile(client, clientDto);
        return profile == ClientProfile.ELDER && clientDto.isElderCard() ? ClientProfile.ELDER_WITH_CARD : profile;
    }
}
