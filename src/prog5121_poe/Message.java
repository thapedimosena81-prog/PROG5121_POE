/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121_poe;


import java.util.ArrayList;
/**
 *
 * @author thape
 */
public class Message {
    
    private String messageID;
    private String recipient;
    private String message;
    private int messageNumber;
    
    public static ArrayList<String> sentMessage = new ArrayList<>();
    public static ArrayList<String> disregardedMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> messageHashes = new ArrayList<>();
    public static ArrayList<String> messageIDs = new ArrayList<>();
    
    public Message(String messageID,String recipient,String message, int messageNumber ) {
        
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;        
    }
  
    
    public boolean checkMessageID() {
        
        return messageID.length() <= 10;
    }
    
    public String checkRecipientCell() {
        
        if (recipient.matches("\\+27\\d{9}")) {
            return "cell phone number successfully captured.";
        }
        
        return "cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }
    
    public String checkMessageLength() {
        
        if (message.length() <= 250) {
            
            return "Message ready to send.";      
    }
        
        int difference = message.length() - 250; 
        
        return "Message exceeds 250 characters by"
                + difference
                +", please reduce this size";
        
    }
    
    public String createMessageHash() {
        
        String firstTwo = messageID.substring(0,2);
        String [] words = message.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        
        return firstTwo +
                ":" +
                messageNumber +
                ":" +
                firstWord + 
                lastWord;
    }
    
    public String sendMessage(int option) {
        
        switch(option) {
            
            case 1: return "Message successfully sent.";
            case 2: return "Press 0 to delete the message.";
            case 3: return "Message successfully stored.";
           
            default: return "Invaid option";
        }
    }
    
    public void storeMessageTOJSON() {
        
        try { 
            
            java.io.FileWriter writer =
                    new java.io.FileWriter("message.json", true);
            
            writer.write(
                    "{\n" +
                     "\"MessageID\":\"" + messageID + "\",\n" +
                     "\"Recipent\":\"" + recipient + "\",\n" +
                     "\"Message\":\"" + message + "\"\n" + "}\n"
            );
            
            writer.close();
            
            System.out.println("Message saved to JSON File.");
            
        } catch (Exception e) {
            
            System.out.println("Error storing message.");
            
        }
    }
    
   public String printMessages() {
       
       return "Message ID:" + messageID
               +"\nRecipient:" + recipient
               +"\nMessage:" + message
               +"\nMessage Hash:" + createMessageHash();
   }
   
   public int returnTotalMessage() {
       return messageNumber;
   }
}
  
