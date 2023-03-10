package br.geekcode.ticketdiscountcalculator.services.ticket.discount.impl;

import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import br.geekcode.ticketdiscountcalculator.models.client.Client;
import br.geekcode.ticketdiscountcalculator.services.ticket.discount.TicketDiscountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TicketDiscountServiceBaseTest {
    @Autowired
    @Qualifier("ticketDiscountServiceBase")
    private TicketDiscountService ticketDiscountService;

    public Client createClientMock() {
        var clientMock = mock(Client.class);

        doAnswer(invocation -> {
            ClientProfile profile = invocation.getArgument(0);

            Field field = Client.class.getDeclaredField("profile");
            field.setAccessible(true);
            field.set(clientMock, profile);

            return null;
        }).when(clientMock).setProfile(any(ClientProfile.class));

        doAnswer(invocation -> {
            Field field = Client.class.getDeclaredField("profile");
            field.setAccessible(true);
            return field.get(clientMock);
        }).when(clientMock).getProfile();

        clientMock.setProfile(ClientProfile.NONE);

        return clientMock;
    }

    @Test
    @DisplayName("calculateTicketPriceForMonday should return 8 if client has no discount")
    public void calculateTicketPriceForMonday_Should_Return_Eight_If_Client_Has_No_Discount() {
        var client = createClientMock();
        var price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("""
            calculateTicketPriceForMonday should return:
             4.95 for child;
             5.4 for elder;
             7.2 for student;
             5.2 for student with card;
            """)
    public void calculateTicketPriceForMonday_Should_Return_Expected_Price_With_Discount() {
        var client = createClientMock();
        double price;

        client.setProfile(ClientProfile.CHILD);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(4.95, price, 0.001);

        client.setProfile(ClientProfile.ELDER);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(5.4, price, 0.001);

        client.setProfile(ClientProfile.STUDENT);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(7.2, price, 0.001);

        client.setProfile(ClientProfile.STUDENT_WITH_CARD);
        price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForTuesday should return 8 if client has no discount")
    public void calculateTicketPriceForTuesday_Should_Return_Eight_If_Client_Has_No_Discount() {
        var client = createClientMock();
        var price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("""
            calculateTicketPriceForTuesday should return:
             4.675 for child;
             5.1 for elder;
             7.6 for student;
             5.2 for student with card""")
    public void calculateTicketPriceForTuesday_Should_Return_Expected_Price_With_Discount() {
        var client = createClientMock();
        double price;

        client.setProfile(ClientProfile.CHILD);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(4.675, price, 0.001);

        client.setProfile(ClientProfile.ELDER);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(5.1, price, 0.001);

        client.setProfile(ClientProfile.STUDENT);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(7.6, price, 0.001);

        client.setProfile(ClientProfile.STUDENT_WITH_CARD);
        price = ticketDiscountService.calculateTicketPriceForTuesday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForWednesday should return 8 if client has no discount")
    public void calculateTicketPriceForWednesday_Should_Return_Eight_If_Client_Has_No_Discount() {
        var client = createClientMock();
        var price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("""
            calculateTicketPriceForWednesday should return:
             3.85 for child;
             3.6 for elder;
             4 for student;
             4 for student with card""")
    public void calculateTicketPriceForWednesday_Should_Return_Expected_Price_With_Discount() {
        var client = createClientMock();
        double price;

        client.setProfile(ClientProfile.CHILD);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(3.85, price, 0.001);

        client.setProfile(ClientProfile.ELDER);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(3.6, price, 0.001);

        client.setProfile(ClientProfile.STUDENT);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(4, price, 0.001);

        client.setProfile(ClientProfile.STUDENT_WITH_CARD);
        price = ticketDiscountService.calculateTicketPriceForWednesday(client);
        Assertions.assertEquals(4, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForThursday should return 8 if client has no discount")
    public void calculateTicketPriceForThursday_Should_Return_Eight_If_Client_Has_No_Discount() {
        var client = createClientMock();
        var price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("""
            calculateTicketPriceForThursday should return:
             5.5 for child;
             4.2 for elder;
             5.6 for student;
             5.2 for student with card""")
    public void calculateTicketPriceForThursday_Should_Return_Expected_Price_With_Discount() {
        var client = createClientMock();
        double price;

        client.setProfile(ClientProfile.CHILD);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.5, price, 0.001);

        client.setProfile(ClientProfile.ELDER);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(4.2, price, 0.001);

        client.setProfile(ClientProfile.STUDENT);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.6, price, 0.001);

        client.setProfile(ClientProfile.STUDENT_WITH_CARD);
        price = ticketDiscountService.calculateTicketPriceForThursday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }

    @Test
    @DisplayName("calculateTicketPriceForFriday should return 8 if client has no discount")
    public void calculateTicketPriceForFriday_Should_Return_Eight_If_Client_Has_No_Discount() {
        var client = createClientMock();
        var price = ticketDiscountService.calculateTicketPriceForMonday(client);
        Assertions.assertEquals(8, price, 0.001);
    }

    @Test
    @DisplayName("""
            calculateTicketPriceForFriday should return:
             4.895 for child;
             6 for elder;
             8 for student;
             5.2 for student with card""")
    public void calculateTicketPriceForFriday_Should_Return_Expected_Price_With_Discount() {
        var client = createClientMock();
        double price;

        client.setProfile(ClientProfile.CHILD);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(4.895, price, 0.001);

        client.setProfile(ClientProfile.ELDER);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(6, price, 0.001);

        client.setProfile(ClientProfile.STUDENT);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(8, price, 0.001);

        client.setProfile(ClientProfile.STUDENT_WITH_CARD);
        price = ticketDiscountService.calculateTicketPriceForFriday(client);
        Assertions.assertEquals(5.2, price, 0.001);
    }
}
