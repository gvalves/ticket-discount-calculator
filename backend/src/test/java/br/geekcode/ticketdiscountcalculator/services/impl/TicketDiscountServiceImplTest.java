package br.geekcode.ticketdiscountcalculator.services.impl;

import br.geekcode.ticketdiscountcalculator.models.Client;
import br.geekcode.ticketdiscountcalculator.services.TicketDiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class TicketDiscountServiceImplTest {
    @Autowired
    private TicketDiscountService ticketDiscountService;

    private Client createClientWithNoneProfile() {
        Client client = new Client();
        client.setBirthday(LocalDate.now().minusYears(20));
        return client;
    }

    private void setClientProfileToChild(Client client) {
        client.setBirthday(LocalDate.now().minusYears(5));
        client.setStudent(false);
        client.setStudentCard(false);
    }

    private void setClientProfileToStudent(Client client) {
        client.setBirthday(LocalDate.now().minusYears(20));
        client.setStudent(true);
        client.setStudentCard(false);
    }

    private void setClientProfileToStudentWithCard(Client client) {
        client.setBirthday(LocalDate.now().minusYears(20));
        client.setStudent(true);
        client.setStudentCard(true);
    }

    private void setClientProfileToElder(Client client) {
        client.setBirthday(LocalDate.now().minusYears(70));
        client.setStudent(false);
        client.setStudentCard(false);
    }

    @Test
    @DisplayName("calculateTicketPriceForMonday should return 8 if client has no discount")
    public void calculateTicketPriceForMonday_Should_Return_Eight_If_Client_Has_No_Discount() {
        Client client = createClientWithNoneProfile();
        double price = ticketDiscountService.calculateTicketPriceForMonday(client);

        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForMonday should return 4.95 for child, 5.4 for elder, 7.2 for student and 5,2 for student with card")
    public void calculateTicketPriceForMonday_Should_Return_Expected_Price_With_Discount() {
        Client client = createClientWithNoneProfile();
        double price;

        setClientProfileToChild(client);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(4.95, price, 0.001);

        setClientProfileToElder(client);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(5.4, price, 0.001);

        setClientProfileToStudent(client);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(7.2, price, 0.001);

        setClientProfileToStudentWithCard(client);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForTuesday should return 8 if client has no discount")
    public void calculateTicketPriceForTuesday_Should_Return_Eight_If_Client_Has_No_Discount() {
        Client client = createClientWithNoneProfile();
        double price = ticketDiscountService.calculateTicketPriceForMonday(client);

        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForTuesday should return 4.675 for child, 5.1 for elder, 7.6 for student and 5,2 for student with card")
    public void calculateTicketPriceForTuesday_Should_Return_Expected_Price_With_Discount() {
        Client client = createClientWithNoneProfile();
        double price;

        setClientProfileToChild(client);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(4.675, price, 0.001);

        setClientProfileToElder(client);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(5.1, price, 0.001);

        setClientProfileToStudent(client);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(7.6, price, 0.001);

        setClientProfileToStudentWithCard(client);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForWednesday should return 8 if client has no discount")
    public void calculateTicketPriceForWednesday_Should_Return_Eight_If_Client_Has_No_Discount() {
        Client client = createClientWithNoneProfile();
        double price = ticketDiscountService.calculateTicketPriceForMonday(client);

        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForWednesday should return 3.85 for child, 3.6 for elder, 4 for student and 4 for student with card")
    public void calculateTicketPriceForWednesday_Should_Return_Expected_Price_With_Discount() {
        Client client = createClientWithNoneProfile();
        double price;

        setClientProfileToChild(client);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(3.85, price, 0.001);

        setClientProfileToElder(client);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(3.6, price, 0.001);

        setClientProfileToStudent(client);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(4, price, 0.001);

        setClientProfileToStudentWithCard(client);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(4, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForThursday should return 8 if client has no discount")
    public void calculateTicketPriceForThursday_Should_Return_Eight_If_Client_Has_No_Discount() {
        Client client = createClientWithNoneProfile();
        double price = ticketDiscountService.calculateTicketPriceForMonday(client);

        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForThursday should return 5.5 for child, 4.2 for elder, 5.6 for student and 5.2 for student with card")
    public void calculateTicketPriceForThursday_Should_Return_Expected_Price_With_Discount() {
        Client client = createClientWithNoneProfile();
        double price;

        setClientProfileToChild(client);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.5, price, 0.001);

        setClientProfileToElder(client);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(4.2, price, 0.001);

        setClientProfileToStudent(client);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.6, price, 0.001);

        setClientProfileToStudentWithCard(client);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForThursday should return 8 if client has no discount")
    public void calculateTicketPriceForFriday_Should_Return_Eight_If_Client_Has_No_Discount() {
        Client client = createClientWithNoneProfile();
        double price = ticketDiscountService.calculateTicketPriceForMonday(client);

        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForFriday should return 4.895 for child, 6 for elder, 8 for student and 5.2 for student with card")
    public void calculateTicketPriceForFriday_Should_Return_Expected_Price_With_Discount() {
        Client client = createClientWithNoneProfile();
        double price;

        setClientProfileToChild(client);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(4.895, price, 0.001);

        setClientProfileToElder(client);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(6, price, 0.001);

        setClientProfileToStudent(client);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(8, price, 0.001);

        setClientProfileToStudentWithCard(client);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }
}
