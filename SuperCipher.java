import java.util.Arrays;

/**
 * The SuperCipher extends the BaseCipher class. It has the attribute of a BaseCipher array.
 */
public class SuperCipher extends BaseCipher{
    private BaseCipher[] cipherCollection;

    /**
     * Constructor for the SuperCipher object
     * @param cipherCollection A BaseCipher[] attribute
     */
    public SuperCipher(BaseCipher[] cipherCollection){
        super("SuperCipher");
        this.cipherCollection = cipherCollection;
    }

    /**
     * Determines whether the inputted key in the SuperCipher object referenced is valid
     * @return true if every single cipher object is valid in the array
     */
    public boolean isValid(){
        boolean isTrue = true;
        for(int i = 0; i < cipherCollection.length; i++){
            if(!cipherCollection[i].isValid()){
                isTrue = false;
            }
        }
        return isTrue;
    }

    /**
     * This function encrypts the given String using every cipher within its attribute BaseCipher[]
     * @param normal String that will be encrypted
     * @return An encrypted string
     */
    public String encrypt(String normal){
        for(int i = 0; i < cipherCollection.length; i++){
            normal = cipherCollection[i].encrypt(normal);
        }
        return normal;
    }

    /**
     *This function decrypts the given String using every cipher within its attribute BaseCipher[]
     * @param normal String that will be decrypted
     * @return A decrypted string
     */
    public String decrypt(String normal){
        for(int i = cipherCollection.length - 1; i >= 0; i--){
            normal = cipherCollection[i].decrypt(normal);
        }
        return normal;
    }

    /**
     * This function returns a string which describes a SuperCipher Object
     * @return String summarizing SuperCipher object
     */
    public String toString(){
        String collection = "";
        for(int i = 0; i < cipherCollection.length; i++){
            if(i == cipherCollection.length - 1){
                collection += cipherCollection[i].toString();
            }
            else{
                collection += cipherCollection[i].toString() + " | ";
            }
        }
        return "SuperCipher(" + collection + ")";
    }

    /**
     * This function determines if one SuperCipher object attribute has the same length of attribute along with the exact same ciphers at each index as another object
     * @param obj The object that this will be compared to
     * @return true, if and only if,one SuperCipher object attribute has the same length of attribute along with the exact same ciphers at each index as another object
     */
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if(obj == null){
            return false;
        }
        else if(obj instanceof SuperCipher) {
            SuperCipher cipher = (SuperCipher) obj;
            return Arrays.equals(this.cipherCollection, cipher.cipherCollection);
        }
        else{
            return false;
        }
    }
}
