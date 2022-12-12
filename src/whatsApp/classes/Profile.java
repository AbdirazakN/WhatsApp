package whatsApp.classes;

import whatsApp.enums.Status;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Profile {
    private long id;
    private String password;
    private String phoneNumber;
    private String image;
    private String userName;
    private Status status;
    private List<String> message;
    private Map<String, Integer> chats = new TreeMap<>();
    private List<Contact> contacts;

    public Profile() {
    }

    public Profile(long id, String userName, String password, List<String> message, Status status, String image, String phoneNumber, Map<String, Integer> chats, List<Contact> contacts) {
        this.userName = userName;
        this.password = password;
        this.contacts = contacts;
        this.chats = chats;
        this.message = message;
        this.status = status;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public Map<String, Integer> getChats() {
        return chats;
    }

    public void setChats(Map<String, Integer> chats) {
        this.chats = chats;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "\n<<<<<<<<<<<<<<<<<<<<<   Profile   >>>>>>>>>>>>>>>>>>>>>" +
                "\nID:            " + id +
                "\nPhone Number:  " + phoneNumber +
                "\nImage:         " + image +
                "\nUser Name:     " + userName +
                "\nStatus:        " + status +
                "\nPassword:      " + password +
                "\nMessage:       " + chats +
                "\nContact:       " + contacts +
                "\n";
    }
}
