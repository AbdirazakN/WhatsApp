package whatsApp.classes;

import java.util.List;

public class WhatsApp {
    private int id;
    private List<String[]> chats;

    public WhatsApp(int id, List<String[]> chats) {
        this.id = id;
        this.chats = chats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String[]> getChats() {
        return chats;
    }

    public void setChats(List<String[]> chats) {
        this.chats = chats;
    }

}