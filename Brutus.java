/**
 * The Brutus class provides methods for analyzing and decrypting a Caesar cipher.
 * @author Ayham Ahmed
 */
public class Brutus {
    /** The Given frequency distribution of English letters. */
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    /**
     * A methed to Count the occurrences of each letter in the given text.
     * 
     * @param text The text to count occurrences of letters.
     * @return An array containing the count of each letter occurrence.
     */
    public static int[] count (String text){
     // Initialize the array to hold the letter frequencies
     int[] letterCounts = new int[26];
     for (int i = 0; i < text.length(); i++) {
        char currentChar = text.charAt(i);
        if (Character.isLetter(currentChar)) {
            char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
            // Increment the corresponding frequency counter
            letterCounts[currentChar - base]++;
            }
       }
     return letterCounts;
    }
     /**
     * Calculates the frequency of each letter in the given text.
     * 
     * @param text The text to calculate letter frequencies.
     * @return An array containing the frequency of each letter.
     */
    public static double[] frequency(String text){
        double[] letterFreq = new double[26];
        int totalLetters = 0;
        // Get the letter counts
        int[] letterCounts = count(text);
        // count total num of letters
        for (int i = 0; i < letterCounts.length; i++) {
            int count = letterCounts[i];
            totalLetters += count;
        }
         // Normalize by dividing by the total number of letters
         for (int i = 0; i < letterCounts.length; i++) {
            letterFreq[i] = (double) letterCounts[i] / totalLetters;
        }
        return letterFreq;
        
    }
    /**
     * Calculates the chi-squared score between observed and expected frequencies.
     * 
     * @param observed The observed frequencies (from text).
     * @param expected The expected frequencies (Given). 
     * @return The chi-squared score.
     */
    public static double chiSquared(double[] observed, double[] expected){
         double chiSquared = 0.0;
        for (int i = 0; i < observed.length; i++) {
            chiSquared += Math.pow(observed[i] - expected[i], 2) / expected[i];
        }
        return chiSquared;
    }

    /**
     * main method
     * Decrypts the given ciphertext using the Caesar cipher with the best shift.
     * @param args We expext ane argument only, which is the cipher text.
     */
    public static void main(String[] args){
        if (args.length > 1){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
        }
        else if (args.length < 1){
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Brutus \"cipher text\"");
        }
        else{
        String cryptotext = args[0];
        // Initialize variables to store the best decryption and its score
        String bestDecryption = "";
        double bestScore = Double.POSITIVE_INFINITY;
         // Iterate over all possible shift values (0 to 25)
         for (int shift = 0; shift < 26; shift++) {
            // Decrypt the cryptotext using the current shift
            StringBuilder decryptionBuilder = new StringBuilder();
            for (int i = 0; i < cryptotext.length(); i++) {
                char currentChar = cryptotext.charAt(i);
                if (Character.isLetter(currentChar)) {
                    char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                    char decryptedChar = (char) (base + (currentChar - base + shift) % 26);
                    decryptionBuilder.append(decryptedChar);
                } else {
                    decryptionBuilder.append(currentChar);
                }
            }
            String decryption = decryptionBuilder.toString();

            // Calculate letter frequencies of the decrypted text
            double[] decryptedFrequencies = frequency(decryption);

            // Calculate chi-squared score between decrypted frequencies and English frequencies
            double score = chiSquared(decryptedFrequencies, english);

            // If the current decryption has a lower score, update the best decryption and score
            if (score < bestScore) {
                bestScore = score;
                bestDecryption = decryption;
            }
        }
        System.out.println(bestDecryption);
    }
        
}
}