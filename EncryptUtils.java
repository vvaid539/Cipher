/**
 * This class EncryptUtils creates functions to encrypt or decrypt an array of strings many times
 */
public class EncryptUtils {
    /**
     * This function encrypts an array of Strings through a BaseCipher Object
     * @param obj Determines the type of encryption done
     * @param stringArray the Strings of this array will be encrypted
     * @return a new array of Strings that are encrypted
     */
    public static String[] encryptMany(BaseCipher obj, String[] stringArray){
        String[] newStringArray = new String[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            String s = obj.encrypt(stringArray[i]);
            newStringArray[i] = s;
        }
        return newStringArray;
    }

    /**
     * This function decrypts an array of Strings through a BaseCipher Object
     * @param obj Determines the type of decryption done
     * @param stringArray the Strings of this array will be decrypted
     * @return a new array of Strings that are decrypted
     */
    public static String[] decryptMany(BaseCipher obj, String[] stringArray){
        String[] newStringArray = new String[stringArray.length];
        for(int i = 0; i < stringArray.length; i++){
            String s = obj.decrypt(stringArray[i]);
            newStringArray[i] = s;
        }
        return newStringArray;
    }
}
