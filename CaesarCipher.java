/**
 * The class CaeserCipher extends the BaseCipher class. It
 * creates a CaeserCipher object with a int key attribute.
 */
public class CaesarCipher extends BaseCipher {
    private int key;

    /**
     * Constructor for the CaeserCipher object/class
     * @param key integer through which encryption and decryption is done
     */
    public CaesarCipher(int key){
        super("Caeser Cipher");
        this.key = key;
    }

    /**
     * Determines whether the inputted key in the CaeserCipher object referenced is valid
     * @return true if the key is valid and false if the key is not valid
     */
    public boolean isValid(){
        if(key > 0 && key < 26){
            return true;
        }
        return false;
    }

    /**
     * This function encrypts the given String with the predetermined key in the CaeserCipher object
     * @param unencrypted String that will be encrypted
     * @return A new String that is encrypted
     */
    public String encrypt(String unencrypted){
        String lowerCase = unencrypted.toLowerCase();
        String newString = "";
        for(int i = 0; i < lowerCase.length(); i++){
            if(Character.isAlphabetic(lowerCase.charAt(i)) == true) {
                int num = (int) (lowerCase.charAt(i));
                if (num + key > 122) {
                    num = num + key - 26;
                } else {
                    num += key;
                }
                char chr = (char)(num);
                newString += chr;
            }else {
                newString += lowerCase.charAt(i);
            }
        }
        return newString;
    }

    /**
     * This function decrypts the given String with the predetermined key in the CaeserCipher object
     * @param encrypted String that will be decrypted
     * @return A new String that is decrypted
     */
    public String decrypt(String encrypted){
        String lowerCase = encrypted.toLowerCase();
        String newString = "";
        for(int i = 0; i < lowerCase.length(); i++){
            if(Character.isAlphabetic(lowerCase.charAt(i)) == true) {
                int num = (int) (lowerCase.charAt(i));
                if (num - key < 97) {
                    num = num - key + 26;
                } else {
                    num -= key;
                }
                char chr = (char)(num);
                newString += chr;
            }else {
                newString += lowerCase.charAt(i);
            }
        }
        return newString;
    }

    /**
     * This function returns a string which describes the object
     * @return A string that describes an object
     */
    public String toString(){
        return "Caesar" + "(" + key + ")";
    }

    /**
     * This function determines if one CaeserCipher object has the same key as another object
     * @param obj The object that this will be compared to
     * @return true, if and only if, one CaeserCipher object key equals the another CaeserCipher objects key
     */
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        else if(obj == null){
            return false;
        }
        else if(obj instanceof CaesarCipher) {
            CaesarCipher cipher = (CaesarCipher) obj;
            return this.key == cipher.key;
        }
        else{
            return false;
        }
    }

}
