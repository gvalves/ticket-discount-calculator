package br.geekcode.ticketdiscountcalculator.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    @NotBlank
    private String name;
    @Past
    private LocalDate birthday;
    private boolean student;
    private boolean studentCard;

    public int getAge() {
        LocalDate now = LocalDate.now();
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
}
