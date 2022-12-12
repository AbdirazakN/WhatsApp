package whatsApp.service.impl;

import whatsApp.classes.Passport;
import whatsApp.enums.Country;
import whatsApp.enums.Gender;
import whatsApp.service.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonImpl implements PersonService {
    private List<Passport> passportList = new ArrayList<>();

    public List<Passport> getPassportList() {
        return passportList;
    }

    public void setPassportList(List<Passport> passportList) {
        this.passportList = passportList;
    }

    @Override
    public List<Passport> getAllPassports() {
        return passportList;
    }

    @Override
    public List<Passport> findPassportByName() {
        System.out.print("Write a Name : ");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.nextLine();
        List<Passport> resultSearch = new ArrayList<>();
        for (Passport passport : passportList)
            if (passport.getName().equals(name))
                resultSearch.add(passport);
        return resultSearch;
    }

    @Override
    public String createPassport() {
        Passport newPassport;
        boolean isCreated = false;
        try {
            System.out.print("ID : ");
            Scanner idScanner = new Scanner(System.in);
            long id = idScanner.nextLong();
            System.out.print("Write Name : ");
            Scanner nameScanner = new Scanner(System.in);
            String name = nameScanner.nextLine();
            System.out.print("Write Surname : ");
            Scanner surnameScanner = new Scanner(System.in);
            String surname = surnameScanner.nextLine();
            System.out.print("Country : ");
            Scanner countryScanner = new Scanner(System.in);
            String country = countryScanner.nextLine();
            System.out.print("Gender : ");
            Scanner genderScanner = new Scanner(System.in);
            String gender = genderScanner.nextLine();
            System.out.print("Date of birth (yyyy/mm/dd) : ");
            Scanner birthdayScanner = new Scanner(System.in);
            String[] birthDateList = birthdayScanner.nextLine().trim().split("/");

            if (id < 1) throw new Exception("ID can't be 0 and negative!.");
            else {
                for (Passport passport : passportList) {
                    if (passport.getId() == id)
                        throw new Exception("This ID is USED!");
                }
            }
            if ((name.isEmpty() || name.matches(".*[0-9].*")) || (surname.isEmpty() || surname.matches(".*[0-9].*")))
                throw new Exception("First & Last Name validation error!");
            if (country.isEmpty() || !country.matches("[a-zA-Z]+"))
                throw new Exception("Country validation error!");
            if (gender.isEmpty() || !gender.matches("[a-zA-Z]+"))
                throw new Exception("Gender validation error!");
            if (birthDateList.length != 3)
                throw new Exception("Birth Date validation error!");

            else {
                LocalDate dateOfBirth = LocalDate.of(
                        Integer.parseInt(birthDateList[0]),
                        Integer.parseInt(birthDateList[1]),
                        Integer.parseInt(birthDateList[2]));

                if (LocalDate.now().compareTo(dateOfBirth) < 1)
                    throw new Exception("Invalid DATE OF BIRTH!");
                if (!gender.equals("MALE") && !gender.equals("FEMALE"))
                    throw new Exception("Gender most be only 'MALE' or 'FEMALE'!");

                newPassport = new Passport(id, name, surname, Gender.valueOf(gender), Country.valueOf(country), dateOfBirth);
                isCreated = passportList.add(newPassport);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isCreated ? "Passport created successfully." : "Passport not created!";
    }

    @Override
    public List<Country> getAllCountries() {
        return new ArrayList<>(List.of(Country.values()));
    }
}