/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog5121_poe;
import java.util.Scanner;
/**
 *
 * @author thape
 */
public class PROG5121_POE_Part1_Part2_Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Scanner input = new Scanner(System.in);
     
    System.out.print("Enter username:");
    String username = input.nextLine();
    
    System.out.print("Enter password:");
    String password = input.nextLine();
    
    System.out.print("Enter cellphone number:");
    String cellPhoneNumber = input.nextLine();
    
            Login login = new Login ( username,password,cellPhoneNumber);
            
            System.out.println( login.registerUser());
            System.out.println( login.registerPassword());
           System.out.println( login.registerCellPhone());
    
           
    System.out.print("Enter username to login: ");
    String loginUsername = input.nextLine();
    
    System.out.print("Enter password to login:");
    String loginPassword = input.nextLine();
    
    boolean loginStatus = login.loginUser(loginUsername, loginPassword);
    
    System.out.println(login.returnLoginStatus(loginStatus));
     
    if(loginStatus){
        
        System.out.println("\nWelcome to QuickChat");
        
        System.out.print("How many messages would you like to send?");
        int numberOfMessages = input.nextInt();
        input.nextLine();
        
        int choice;
        
        do {
            System.out.println("\n1. send Message");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.println("4.Stored Messages");
            System.out.println("4. Search by Recipient");
            System.out.println("5. Delete by Message Hash");
            System.out.println("6. Display Report");
            
            System.out.print("Choose an option:");
            choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
                
                case 1 -> {
                    for(int i = 0; i < numberOfMessages; i++){
                        
                       String messageID = String.valueOf((long)(Math.random()* 10000000000L));
                       
                        System.out.print("Enter Recipient Number;");
                        String recipient = input.nextLine();
                        
                        System.out.print("Enter Message;");
                        String message = input.nextLine();
                        
                        Message msg = new Message(
                                messageID,
                                recipient,
                                message,i);
                        
                        System.out.println(msg.checkRecipientCell());
                        System.out.println(msg.checkMessageLength());
                        System.out.println("Message Hash:"+ msg.createMessageHash());
                        
                        System.out.println("\n1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message");
                 
                        
                        System.out.println("Choose an option");
                        int option = input.nextInt();
                        input.nextLine();
                        
                        System.out.println( msg.sendMessage(option));
                        
                        if(option == 1){
                            
                            Message.sentMessage.add(message);
                            Message.messageHashes.add(msg.createMessageHash());
                            Message.messageIDs.add(messageID);
                        }
                        
                        else if(option == 2){
                            
                            Message.disregardedMessages.add(message);
                        }
                        
                        else if(option == 3){
                            
                            Message.storedMessages.add(message);
                            Message.messageHashes.add(msg.createMessageHash());
                            Message.messageIDs.add(messageID);
                            
                            
                        }
                        
                        if(option == 3) {
                            
                            msg.storeMessageTOJSON();
                            
                        }
                        
                        System.out.println( msg.printMessages());
                    }
                }
                
                case 2 -> System.out.println("Coming soon.");
                  
                case 3 -> System.out.println("Goodbye.");
                
                case 4 -> {
                    
                    System.out.println("\n1. Display Stored Messages");
                    System.out.println("2. Longest Stored Message");
                    System.out.println("3.Search by Message ID");
                    
                    int storedOption = input.nextInt();
                    input.nextLine();
                    
                    switch(storedOption) {
                        
                        case 1 -> {
                            for(String msg : Message.storedMessages) {
                                
                                System.out.println(msg);
                            }
                        }
                        
                        case 2 -> {
                            String longest = "";
                            
                            for(String msg : Message.storedMessages){
                                
                                if(msg.length() > longest.length()){
                                    
                                    longest = msg;
                                }
                            }
                            
                            System.out.println("Longest Message:"+ longest);
                        }
                        
                        case 3 -> {
                            
                            System.out.print("Enter Message ID:");
                            
                            String searchID = input.nextLine();
                            
                            if(Message.messageIDs.contains(searchID)){
                                
                                System.out.println("Message Found");
                            }
                            else{
                                System.out.println("Message Not Found");
                            }
                        }
                        
                        case 4 -> {
                            
                            System.out.print("Enter Recipient Number:");
                            String searchRecipient = input.nextLine();
                            
                            boolean found = false;
                            
                            for(String msg : Message.storedMessages){
                                
                                if(msg.contains(searchRecipient)){
                                    
                                    System.out.println(msg);
                                    found = true;
                                }
                            }
                            
                            if(!found){
                                
                                System.out.println("Recipient Not Found");
                            }
                        }
                        
                        case 5 -> {
                            
                            System.out.println("Enter Message Hash:");
                            
                            String hash = input.nextLine();
                            
                            if(Message.messageHashes.remove(hash)){
                                
                                System.out.println("Message deleted successfully");
                            }
                            else{
                                System.out.println("Hash not found");
                            }
                        }
                        
                        case 6 -> {
                            
                            System.out.println("\n===== Full Report =====");
                            
                            for(String msg : Message.storedMessages){
                                
                                System.out.println(msg);
                            }
                            
                            System.out.println("Total Stored Messages:"+ Message.storedMessages.size());
                        }
                    }
                }
                    

                    
                default -> System.out.println("Invaid option.");               
            }
            
        } while(choice != 3);
        
    }
      
    input.close();
}
  
}

