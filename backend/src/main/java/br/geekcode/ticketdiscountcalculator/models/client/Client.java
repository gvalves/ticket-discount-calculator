package br.geekcode.ticketdiscountcalculator.models.client;

import br.geekcode.ticketdiscountcalculator.dtos.ClientDto;
import br.geekcode.ticketdiscountcalculator.enums.ClientProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String name;
    private LocalDate birthday;
    @JsonIgnore
    private ClientProfile profile;

    public static Client create(ClientDto clientDto, ClientProfileStrategy profileStrategy) {
        var client = new Client();

        BeanUtils.copyProperties(clientDto, client);
        client.setProfile(profileStrategy.getClientProfile(client, clientDto));

        return client;
    }

    public int getAge() {
        var now = LocalDate.now();
        return Period.between(birthday, now).getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ClientProfile getProfile() {
        return profile;
    }

    public void setProfile(ClientProfile profile) {
        if (this.profile == null) {
            this.profile = profile;
        }
    }
}
