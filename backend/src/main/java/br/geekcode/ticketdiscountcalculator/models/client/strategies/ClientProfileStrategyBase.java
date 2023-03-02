package br.geekcode.ticketdiscountcalculator.models.client.strategies;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.models.client.ClientProfileStrategy;
import org.springframework.stereotype.Component;

@Component
public class ClientProfileStrategyBase implements ClientProfileStrategy {
    public ClientProfile getClientProfile(Client client, ClientDto clientDto) {
        if (client.getAge() <= 10) return ClientProfile.CHILD;
        if (client.getAge() >= 60) return ClientProfile.ELDER;

        if (clientDto.isStudent()) {
            if (clientDto.isStudentCard()) return ClientProfile.STUDENT_WITH_CARD;
            return ClientProfile.STUDENT;
        }

        return ClientProfile.NONE;
    }
}
