package whatsApp.service.impl;

import whatsApp.classes.Contact;
import whatsApp.classes.Profile;
import whatsApp.enums.Status;
import whatsApp.service.WhatsAppService;

import java.util.*;

public class WhatsAppImpl implements WhatsAppService {

    private List<Profile> profileList = new ArrayList<>();

    public List<Profile> getProfileList() {
        return profileList;
    }

    public void setProfileList(List<Profile> profileList) {
        this.profileList = profileList;
    }

    private TreeMap<Integer, List<String[]>> chatMap = new TreeMap<>();

    public TreeMap<Integer, List<String[]>> getChatMap() {
        return chatMap;
    }

    public void setChatList(TreeMap<Integer, List<String[]>> chatMap) {
        this.chatMap = chatMap;
    }

    private int chatCounter = 0;

    @Override
    public String installWhatsApp() {
        Profile newProfile;
        boolean isInstalled = false;
        try {
            System.out.print("Write your ID : ");
            Scanner idScanner = new Scanner(System.in);
            long id = idScanner.nextLong();
            System.out.print("Write a phone number : ");
            Scanner phoneScanner = new Scanner(System.in);
            String phoneNumber = phoneScanner.nextLine();
            System.out.print("Create a password : ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.nextLine();
            System.out.print("Write a username : ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.nextLine().toLowerCase();

            if (username.length() < 4) throw new Exception("Username can't be short");
            if (!phoneNumber.startsWith("+996") && phoneNumber.length() != 13)
                throw new Exception("Invalid Phone number!");
            if (password.length() < 5 && !password.matches("[0-9]*"))
                throw new Exception("Password can't be short and most be contain numbers!.");

            for (Profile profile : profileList) {
                if (profile.getUserName().equals(username))
                    throw new Exception("This username is used. Write different USERNAME.");
                if (profile.getId() == id)
                    throw new Exception("This ID is used. Write different ID.");
                if (profile.getPhoneNumber().equals(phoneNumber))
                    throw new Exception("This phone number is used. Write different phone number.");
            }

            ArrayList<Contact> contact = new ArrayList<>();
//            ArrayList<Profile> contacts = new ArrayList<>();
            Map<String, Integer> messageChat = new TreeMap<>();
            Stack<String> messages = new Stack<>();

            newProfile = new Profile(id, username, password, messages, Status.НА_СВВЯЗИ, "DEFAULT_IMAGE", phoneNumber, messageChat, contact);

            isInstalled = profileList.add(newProfile);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isInstalled ? "Profile created successfully." : "Profile not created!";
    }


    @Override
    public List<Profile> getAllWhatsAppUsers() {
        return profileList;
    }


    @Override
    public void chats() {
        try {
            System.out.print("Write your username : ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.nextLine().toLowerCase();
            System.out.print("Write your password : ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.nextLine();

            for (Profile profile : profileList) {
                if (profile.getUserName().equals(username) && profile.getPassword().equals(password)) {
                    if (profile.getContacts().size() == 0)
                        throw new Exception("You haven't any contacts!");

                    System.out.println("Your contacts : " + profile.getContacts());
                    System.out.print("Write username that you want to message: ");
                    String chatUsername = new Scanner(System.in).nextLine().toLowerCase();

                    if(profile.getChats().isEmpty()){
                        for (Profile profile1 : profileList) {
                            if(profile1.getUserName().equals(chatUsername)){
                                profile.getChats().put(profile1.getUserName(), chatCounter);
                                profile1.getChats().put(profile.getUserName(), chatCounter);
                                chatMap.put(chatCounter,new ArrayList<>(List.of(new String[][]{{"Message","...."}} )));
                                chatCounter++;
                            }
                        }
                    }
                    int id = profile.getChats().get(chatUsername);
                    List<String[]> chatMessages = chatMap.get(id);

                    while (true){
                        for (String[] chatMessage : chatMessages) {
                            if(chatMessage != null)
                                System.out.println(chatMessage[0] + " :: " +chatMessage[1]);
                        }

                        System.out.print("Message : ");
                        String message = new Scanner(System.in).nextLine();
                        if (message.equals("close")) break;
                        if(message.isEmpty()) System.err.println("Write someone text!");

                        String[] newMessage = {profile.getUserName(),message};
                        chatMessages.add(newMessage);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public String addContact() {
        boolean isAdded = false;
        System.out.print("Write your username : ");
        Scanner usernameScanner = new Scanner(System.in);
        String username = usernameScanner.nextLine().toLowerCase();
        System.out.print("Write your password : ");
        Scanner passwordScanner = new Scanner(System.in);
        String password = passwordScanner.nextLine();

        for (Profile profile : profileList) {
            if (profile.getUserName().equals(username) && profile.getPassword().equals(password)) {
                System.out.print("Write a phone number : ");
                Scanner phoneScanner = new Scanner(System.in);
                String phoneNumber = phoneScanner.nextLine();
                System.out.print("Write a contact username : ");
                Scanner contactScanner = new Scanner(System.in);
                String contactUserName = contactScanner.nextLine().toLowerCase();

                for (Profile profile1 : profileList) {
                    if (profile1.getUserName().equals(contactUserName) && profile1.getPhoneNumber().equals(phoneNumber)) {
                        Contact newContact = new Contact(profile1.getUserName(), profile1.getPhoneNumber());
                        List<Contact> newContactList = new ArrayList<>(profile.getContacts());
                        newContactList.add(newContact);
                        profile.setContacts(newContactList);
                        isAdded = true;
                        break;
                    }
                }
            }
        }
        return isAdded ? "Contact added successfully!" : "Contact Failed!";
    }

    @Override
    public List<Status> getAllWhatsAppStatuses() {
        return new ArrayList<>(List.of(Status.values()));
    }

    @Override
    public String changeStatus() {
        try {
            System.out.print("Write your username : ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.nextLine().toLowerCase();
            System.out.print("Write your password : ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.nextLine();
            boolean isTrue = false;

            for (Profile profile : profileList) {
                if (profile.getUserName().equals(username) && profile.getPassword().equals(password)) {
                    isTrue = true;
                    int counter = 0;
                    System.out.println("Statuses: ");
                    for (Status value : Status.values()) {
                        System.out.println(counter + ":  " + value);
                        counter++;
                    }
//                    System.out.println("STATUS LIST : " + Arrays.toString(Status.values()));
//                    System.out.print("Enter your status index : ");
                    Scanner indexScanner = new Scanner(System.in);
                    int index = indexScanner.nextInt();
                    profile.setStatus(Status.values()[index]);
                    break;
                }
            }
            if (!isTrue)
                throw new Exception("Not Found! Please try again!");
            if (isTrue)
                System.out.println("Status changed successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public Status getWhatsAppStatus() {
        try {
            System.out.print("Write your username : ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.nextLine().toLowerCase();
            System.out.print("Write your password : ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.nextLine();

            for (Profile profile : profileList) {
                if (profile.getUserName().equals(username) && profile.getPassword().equals(password))
                    return profile.getStatus();
            }
            throw new Exception("Not Found!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Profile getProfile() {
        try {
            System.out.print("Write your username : ");
            Scanner usernameScanner = new Scanner(System.in);
            String username = usernameScanner.nextLine().toLowerCase();
            System.out.print("Write your password : ");
            Scanner passwordScanner = new Scanner(System.in);
            String password = passwordScanner.nextLine();

            for (Profile profile : profileList) {
                if (profile.getUserName().equals(username) && profile.getPassword().equals(password))
                    return profile;
            }
            throw new Exception("Not found this Username!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
