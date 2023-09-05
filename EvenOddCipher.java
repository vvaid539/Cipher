//CSCI 1913 Fall 2022 Project 2
//Author: Vedant Vaid

/**
 * The class EvenOddCipher extends the BaseCipher class.
 * Furthermore, it does not have any attributes
 */
public class EvenOddCipher extends BaseCipher{
    /**
     * This function is the constructor for an EvenOddCipher object
     */
    public EvenOddCipher(){
        super("EvenOddCipher");
    }

    /**
     * This function encrypts the given String using the EvenOddCipher algorithim
     * @param s String that will be encrypted
     * @return A new String that is encrypted
     */
    public String encrypt(String s){
        String newString = "";
        for(int i = 0; i < s.length(); i += 2){
            newString += s.charAt(i);
        }
        for(int j = 1; j < s.length(); j += 2){
            newString += s.charAt(j);
        }
        return newString;
    }

    /**
     * This function decrypts the given String using the EvenOddCipher algorithim
     * @param s String that will be decrypted
     * @return A new String that is decrypted
     */
    public String decrypt(String s){
        String newString = "";
        if(s.length() % 2 != 0) {
            for (int i = 0; i < s.length() / 2; i++) {
                newString += s.charAt(i);
                newString += s.charAt(i + s.length() / 2 + 1);
            }
            newString += s.charAt(s.length()/2);
        }
        else{
            for (int i = 0; i < s.length() / 2; i++) {
                newString += s.charAt(i);
                newString += s.charAt(i + s.length() / 2);
            }
        }
        return newString;
    }

    //Function is not needed to be overridden from the BaseCipher class as they have the same output
    //public String toString(){
        //return "EvenOddCipher";
    //}

    /**
     * This function determines if one EvenOddCipher object equals the another EvenOddCipher object
     * @param obj The object that this will be compared to
     * @return true, if and only if, one EvenOddCipher object equals the another EvenOddCipher object
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null){
            return false;
        }
        else if(obj instanceof EvenOddCipher) {
            return true;
        }
        else{
            return false;
        }
    }
}
