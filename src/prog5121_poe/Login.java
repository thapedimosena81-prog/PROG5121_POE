/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog5121_poe;

/**
 *
 * @author thape
 */
public class Login {
    
     private String username;
     private String password;
     private String cellPhoneNumber;
     
     public Login( String username, String password, String cellPhoneNumber ) {
         
     this.username = username;
     this.password = password;
     this.cellPhoneNumber = cellPhoneNumber;
     }
     
     public boolean checkUserName() {
         return
        username.contains("_")&&
        username.length() <= 5;
     }
     
     public boolean checkPasswordComplexity(){
     
         boolean hasCapital = password.matches(".*[A-Z].*");
         boolean hasNumber = password.matches(".*[0-9].*");
         boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
         
            return password.length() >=8 &&
                                        hasCapital &&
                                        hasNumber &&
                                        hasSpecial;
     }
     
     public boolean checkCellPhoneNumber (){
         
         return cellPhoneNumber.matches("^\\+27\\d{9}$");
     }
        
    public String registerCellPhone(){
        
        if (checkCellPhoneNumber()) {
            
           return"Cell number successfully capured.";
        }
         
        return "cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
     
     
     
        public String registerUser(){
     
            if (checkUserName()){
                return "Username successfully captured.";
}
            
                return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length. ";
}

    public String registerPassword(){ 
        
        if (checkPasswordComplexity()){
             
            return "Password successfully captured.";
        }
        
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter , a number, and a special character.";
    }
        
    
    
    
    
    
    
    
        public boolean loginUser(String enteredUsername, String enteredPassword) {
            
            return username.equals(enteredUsername)&& password.equals(enteredPassword);
        }
        
        public String returnLoginStatus(boolean loginStatus) {
            
            if (loginStatus) {
                return "Welcome" + username + ", it is great to see youl''l'l'll'''l'llllll''''''''''ll''''.";
            }
            
            return "Username or password incorrect, please try again.";
        }
    }

