package KeyEncryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class AES {
    // Algorithm name
    private static final String algo = "AES";

    private AES() {
    }

    // Generate AES key
    public static SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algo);
            keyGenerator.init(128);
            return keyGenerator.generateKey();
        } catch (Exception exception) {

        }
        return null;
    }

    // Transform Key String to SecretKey
    public static SecretKey decodeKey(String keyString) {
        try {
            byte[] decodedString = Base64.getDecoder().decode(keyString);
            SecretKey secretKey = new SecretKeySpec(decodedString, algo);
            return secretKey;
        } catch (Exception exception) {

        }
        return null;
    }

    // Encrypt Text
    public static byte[] encryptTextByte(SecretKey secretKey, byte[] encryptByte) {
        try {
            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return cipher.doFinal(encryptByte);
        } catch (Exception exception) {

        }

        return null;

    }

    // Decrypt Text
    public static byte[] decryptTextByte(SecretKey secretKey, byte[] decryptByte) {
        try {
            Cipher cipher = Cipher.getInstance(algo);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(decryptByte);
        } catch (Exception ex) {

        }
        return null;
    }

}
