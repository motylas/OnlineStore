import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.*;

public class EncryptionDecryptionAES {
    static Cipher cipher;
    static SecretKey secretKey;

    static public void prepareHash() throws Exception {
        File file = new File("secretkey.txt");
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        try{
            secretKey = (SecretKey) ois.readObject();
        } finally {
            ois.close();
        }
        cipher = Cipher.getInstance("AES");
    }

    public static void main(String[] args) throws Exception {
        /*
         create key
         If we need to generate a new key use a KeyGenerator
         If we have existing plaintext key use a SecretKeyFactory
        */
        File file = new File("secretkey.txt");
        FileInputStream in = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(in);
        try{
            secretKey = (SecretKey) ois.readObject();
        } finally {
            ois.close();
        }
        /*
          Cipher Info
          Algorithm : for the encryption of electronic data
          mode of operation : to avoid repeated blocks encrypt to the same values.
          padding: ensuring messages are the proper length necessary for certain ciphers
          mode/padding are not used with stream cyphers.
         */
        cipher = Cipher.getInstance("AES"); //SunJCE provider AES algorithm, mode(optional) and padding schema(optional)
        String plainText = "AES Symmetric Encryption Decryption";
        System.out.println("Plain Text Before Encryption: " + plainText);

        String encryptedText = encrypt(plainText);
        System.out.println("Encrypted Text After Encryption: " + encryptedText);

        String decryptedText = decrypt(encryptedText);
        System.out.println("Decrypted Text After Decryption: " + decryptedText);
    }

    public static String encrypt(String plainText)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText)
            throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}