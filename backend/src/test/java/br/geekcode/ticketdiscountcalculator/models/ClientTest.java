package br.geekcode.ticketdiscountcalculator.models;

import br.geekcode.ticketdiscountcalculator.models.client.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ClientTest {
    @Test
    @DisplayName("getAge should returns full years of difference between client birthday and now")
    public void getAge_Should_Returns_Full_Years_Of_Difference_Between_Birthday_And_Now() {
        Client client = new Client();
        client.setBirthday(LocalDate.parse("2001-02-11"));
        Assertions.assertEquals(22, client.getAge());

        client.setBirthday(LocalDate.parse("2023-02-11"));
        Assertions.assertEquals(0, client.getAge());

        client.setBirthday(LocalDate.parse("2022-08-11"));
        Assertions.assertEquals(0, client.getAge());
    }
}
