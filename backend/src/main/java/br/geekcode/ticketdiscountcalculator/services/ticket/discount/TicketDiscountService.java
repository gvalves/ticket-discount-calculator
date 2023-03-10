package br.geekcode.ticketdiscountcalculator.services.ticket.discount;

import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;

/*
* Interface que cuida da lógica de disconto do bilhete
* Usa o design pattern Visitor visto que são regras diferentes para cada dia da semana
* Caso seja necessária criar uma implementação diferente em apenas um dia basta criar uma nova implementação desse serviço,
* mudando a lógica do dia desejado, e dentro dessa nova implementação usa-se composição da classe TicketDiscountServiceImpl para manter a lógica dos demais dias
* */
@Service
public interface TicketDiscountService {
    double calculateTicketPrice(Client client, DayOfWeek day);
    double calculateTicketPriceForMonday(Client client);
    double calculateTicketPriceForMonday(ClientProfile profile);
    double calculateTicketPriceForTuesday(Client client);
    double calculateTicketPriceForTuesday(ClientProfile profile);
    double calculateTicketPriceForWednesday(Client client);
    double calculateTicketPriceForWednesday(ClientProfile profile);
    double calculateTicketPriceForThursday(Client client);
    double calculateTicketPriceForThursday(ClientProfile profile);
    double calculateTicketPriceForFriday(Client client);
    double calculateTicketPriceForFriday(ClientProfile profile);
    double calculateTicketPriceForWeekendAndHoliday(Client client);
    double calculateTicketPriceForWeekendAndHoliday(ClientProfile profile);
}
