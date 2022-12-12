package whatsApp.service;

import whatsApp.classes.Profile;
import whatsApp.enums.Status;

import java.util.List;

public interface WhatsAppService {
    String installWhatsApp();

    String changeStatus() throws Exception;

    List<Profile> getAllWhatsAppUsers();

    void chats();

    Profile getProfile() throws Exception;

    List<Status> getAllWhatsAppStatuses();

    String addContact();

    Status getWhatsAppStatus() throws Exception;

}
