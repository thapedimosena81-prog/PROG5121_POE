/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121_poe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thape
 */
public class MessageTest {
    
    @Test
    public void testCheckMessageID() {
        
        Message msg = new Message ("0012345678","+27684448740","Hi tonight",0);
        
        assertTrue(msg.checkMessageID());    
    }
    
    @Test
    public void testCheckRecipientCell() {
         
        Message msg = new Message("0012345678","+27684448740","Hi tonight",0);
        
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());       
    }
    
    @Test
    public void testCheckMessageLength() {
        
        Message msg = new Message("0012345678","+27684448740","Hi tonight",0);
        
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }
    
    @Test
    public void testCreateMessageHash() {
        
        Message msg = new Message("0012345678","+27684448740","Hi tonight",0);
        
        assertEquals("00:0:Hi tonight", msg.createMessageHash());   
    }
    
    @Test
    public void testSentMessagesArray(){
        
        Message.sentMessage.clear();
        
        Message.sentMessage.add("Did you get the cake?");
        Message.sentMessage.add("It is dinner time!");
        
        assertEquals("Did you get the cake?", Message.sentMessage.get(0));
        assertEquals("It is dinner time!", Message.sentMessage.get(1));
    }
    @Test
    public void testLongestMessage() {
        
        String longest = "Where are you? You are late! I have asked you to be on time.";
        
        assertEquals("Where are you? You are late! I have asked you to be on time.",longest);
    }
    @Test
    public void testSearchMessageID(){
        
        Message.messageIDs.clear();
        
        Message.messageIDs.add("0838884567");
        
        assertTrue(Message.messageIDs.contains("0838884567"));
    }
    @Test
    public void testSearchRecipient() {
         
        String recipient = "+27838884567";
        
        assertEquals("+27838884567",recipient);
    }
    @Test
    public void testDeleteMessaageHash(){
        
        Message.messageHashes.clear();
        
        Message.messageHashes.add("00:1:WHEREONTIME");
        
        boolean removed = Message.messageHashes.remove("00:1:WHEREONTIME");
        
        assertTrue(removed);
    }
    @Test
    public void testDisplayReport() {
        
        Message.storedMessages.clear();
        
        Message.storedMessages.add("Did you get the cake?");
        
        assertEquals(1,Message.storedMessages.size());
    }
    
}
