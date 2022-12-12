package whatsApp.service;

import whatsApp.classes.Passport;
import whatsApp.enums.Country;

import java.util.List;

public interface PersonService {
    List<Passport> findPassportByName();

    List<Passport> getAllPassports();

    List<Country> getAllCountries();

    String createPassport();


}
