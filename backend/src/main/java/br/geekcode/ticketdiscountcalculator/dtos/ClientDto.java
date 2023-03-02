package br.geekcode.ticketdiscountcalculator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class ClientDto {
    @NotBlank
    private String name;
    @Past
    private LocalDate birthday;
    private boolean student;
    private boolean studentCard;
    private boolean elderCard;

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

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isStudentCard() {
        return studentCard;
    }

    public void setStudentCard(boolean studentCard) {
        this.studentCard = studentCard;
    }

    public boolean isElderCard() {
        return elderCard;
    }

    public void setElderCard(boolean elderCard) {
        this.elderCard = elderCard;
    }
}
