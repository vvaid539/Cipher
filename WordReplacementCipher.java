//CSCI 1913 Fall 2022 Project 2
//Author: Vedant Vaid

/**
 * The WordReplacementCipher extends the BaseCipher class. A WordReplacementCipher object has 2
 * attributes which are a String wordToReplaceFrom and a String worldToReplaceTo
 */
public class WordReplacementCipher extends BaseCipher{
    private String wordToReplaceFrom;
    private String wordToReplaceTo;

    /**
     * Constructor for the WorldReplacementCipher object
     * @param wordToReplaceFrom first attribute
     * @param wordToReplaceTo second attribute
     */
    public WordReplacementCipher(String wordToReplaceFrom, String wordToReplaceTo){
        super("WordReplacementCipher");
        this.wordToReplaceFrom = wordToReplaceFrom;
        this.wordToReplaceTo = wordToReplaceTo;
    }

    /**
     * This function encrypts the given String using the wordToReplaceFrom and changing it to wordToReplaceTo
     * @param s The string that will be encrypted
     * @return An encrypted String
     */
    public String encrypt(String s){
        String encryptedString = "";
        int i = 0;
        while(i < s.length()){
            if( (i < s.length() - wordToReplaceFrom.length()) && s.substring(i, i + wordToReplaceFrom.length()).equals(wordToReplaceFrom)){
                encryptedString += wordToReplaceTo;
                i += wordToReplaceFrom.length();
            }
            else{
                encryptedString += s.charAt(i);
                i += 1;
            }
        }
        return encryptedString;
    }

    /**
     * This function decrypts the given String using the wordToReplaceTo and changing it to wordToReplaceFrom
     * @param s The string that will be decrypted
     * @return A decrypted String
     */
    public String decrypt(String s){
        String decryptedString = "";
        int i = 0;
        while(i < s.length()){
            if( (i < s.length() - wordToReplaceTo.length()) && s.substring(i, i + wordToReplaceTo.length()).equals(wordToReplaceTo)){
                decryptedString += wordToReplaceFrom;
                i += wordToReplaceTo.length();
            }
            else{
                decryptedString += s.charAt(i);
                i += 1;
            }
        }
        return decryptedString;
    }

    /**
     * This function returns a string which describes a WordReplacementCipher object
     * @return A string that describes a WordReplacementCipher object
     */
    public String toString(){
        return "WordReplacementCipher(" + wordToReplaceFrom + ", " + wordToReplaceTo + ")";
    }

    /**
     * This function determines if one WordReplacementCipher object has the same attributes as another object
     * @param obj Another object that this object will be compared to
     * @return true, if and only if, both attributes of this object equal the attributes of the other WordReplacementCipher object
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null){
            return false;
        }
        else if(obj instanceof WordReplacementCipher) {
            WordReplacementCipher cipher = (WordReplacementCipher) obj;
            return this.wordToReplaceTo.equals(cipher.wordToReplaceTo) && this.wordToReplaceFrom.equals(cipher.wordToReplaceFrom);
        }
        else{
            return false;
        }
    }
}
