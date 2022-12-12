package whatsApp.classes;

import whatsApp.enums.Country;
import whatsApp.enums.Gender;

import java.time.LocalDate;

public class Passport {
    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private Country country;
    private LocalDate dateOfBirth;

    public Passport() {
    }

    public Passport(long id, String name, String surname, Gender gender, Country country, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country placeOfBirth) {
        this.country = placeOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\n<<<<<<<<<<<<<<<<<<<<<   Passport   >>>>>>>>>>>>>>>>>>>>>" +
                "\nID:              " + id +
                "\nName:            " + name +
                "\nSurname:         " + surname +
                "\nDate Of Birth:   " + dateOfBirth +
                "\nPlace Of Birth:  " + country +
                "\nGender:          " + gender +
                "\n";
    }
}
