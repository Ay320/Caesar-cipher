/**
 * The Caesar class provides methods for encrypting messages using the Caesar cipher.
 * @author ayham ahmed
 */
public class Caesar {
    /**
     * Main method.
     * 
     * @param args we expect two arguments only.
     *             args[0] should be the shift value (an integer).
     *             args[1] should be the message to be encrypted.
     */
    public static void main(String[] args) {
        
        if (args.length == 2){
            String encryptedMessage = rotate(Integer.parseInt(args[0]) , args[1]);
            System.out.println(encryptedMessage);
                  }
        else if (args.length >2) {
              System.out.println("Too many parameters! ");
              System.out.println("Usage: java Caesar n \"cipher text\"");
                }
        else{
            System.out.println("Too few parameters! ");
            System.out.println("Usage: java Caesar n \"cipher text\"");
            }   
    }

     /**
     * A method to rotate a string by the specified shift amount.
     * 
     * @param shift The shift value used for encryption.
     * @param message The message to be encrypted.
     * @return The encrypted message.
     */
    public static String rotate(int shift , String message){
        StringBuilder encryptedMessage = new StringBuilder();
        for(int i=0;i<message.length();i++){
            char currentChar = message.charAt(i);
            // shift the char using the other rotate method
            char shiftedChar = rotate(shift, currentChar); 
            encryptedMessage.append(shiftedChar);         
          }
          return encryptedMessage.toString();
    }

    /**
     * A method to rotates a single character by the specified shift amount.
     * 
     * @param shift The shift value used for encryption.
     * @param currentChar The character to be encrypted.
     * @return The encrypted character.
     */
    public static char rotate(int shift, char currentChar){
        if (Character.isLetter(currentChar)) {
            // Determine if the character is uppercase or lowercase
            char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
            // Apply the shift and wrap around the alphabet
            char shiftedChar = (char) (((currentChar - base + shift) % 26 +26)%26+ base);
            return shiftedChar;
            }
        else {
            // If the character is not a letter, keep it unchanged
            char shiftedChar = currentChar;
            return shiftedChar;   
             }
            
  }
}