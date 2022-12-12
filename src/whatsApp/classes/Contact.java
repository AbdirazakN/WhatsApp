package whatsApp.classes;

public class Contact {
    private String username;
    private String phoneNumber;

    private WhatsApp chat;

    public Contact(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public WhatsApp getChat() {
        return chat;
    }

    public void setChats(WhatsApp chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return username + " : " + phoneNumber;
    }
}
