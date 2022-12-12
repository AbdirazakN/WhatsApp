import whatsApp.service.impl.PersonImpl;
import whatsApp.service.impl.WhatsAppImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PersonImpl personImpl = new PersonImpl();
        WhatsAppImpl whatsAppImpl = new WhatsAppImpl();

        Scanner switchScanner = new Scanner(System.in);
        while (true) {
            command();
            System.out.print(">>> : ");
            int switchNumber = switchScanner.nextInt();
            switch (switchNumber) {
                case 1:
                    System.out.println(personImpl.createPassport());
                    break;
                case 2:
                    System.out.println(whatsAppImpl.installWhatsApp());
                    break;
                case 3:
                    System.out.println(whatsAppImpl.getAllWhatsAppUsers());
                    break;
                case 4:
                    System.out.println(whatsAppImpl.getAllWhatsAppStatuses());
                    break;
                case 5:
                    System.out.println(personImpl.findPassportByName());
                    break;
                case 6:
                    System.out.println(personImpl.getAllCountries());
                    break;
                case 7:
                    System.out.println(personImpl.getAllPassports());
                    break;
                case 8:
                    System.out.println(whatsAppImpl.changeStatus());
                    break;
                case 9:
                    System.out.println(whatsAppImpl.getProfile());
                    break;
                case 10:
                    System.out.println(whatsAppImpl.getWhatsAppStatus());
                    break;
                case 11:
                    System.out.println(whatsAppImpl.addContact());
                    break;
                case 12:
                    whatsAppImpl.chats();
                    break;
                case 0:
                    System.out.println("<<<<<<<<<<<PROGRAM FINISHED!>>>>>>>>>>>");
                    return;
                default:
                    System.out.println("Enter only in commands number!");
                    break;
            }
        }
    }

    private static void command() {
        System.out.println("""
                \n<<<<<<<<<<<<<<<<<<<<<<<<<<   WHATSAPP COMMANDS   >>>>>>>>>>>>>>>>>>>>>>>>>>\n
                    <1>  ====== Create Passport            <7>  ====== Get all passports
                    <2>  ====== Install WhatsApp           <8>  ====== Change status
                    <3>  ====== Get all users              <9>  ====== Get profile
                    <4>  ====== Get all statuses           <10> ====== Get status
                    <5>  ====== Find Person by name        <11> ====== Add contact
                    <6>  ====== Get all countries          <12> ====== Send message
                    
                                        <0>  ====== Stop program
                """);
    }
}