package hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;


public class SaltHash {

    public static StringBuffer encrypt(String message, int key){
        StringBuffer encrypted = new StringBuffer();

        System.out.println(message);

        char[] chars = message.toCharArray();

        for(char c : chars){
            key ++;
            c+= key;
            encrypted.append(c);
        }
        return encrypted;
    }

    public static void decrypt(StringBuffer encryptedMessage, int key){
        System.out.println(encryptedMessage);

        String message = encryptedMessage.toString();

        char[] chars = message.toCharArray();

        for(char c : chars){
            key ++;
            c -= key;
            System.out.print(c);
        }
    }

    public static StringBuilder saltGenerator(int min, int max) {

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringf = new StringBuilder();

        boolean complete = false;
        while (!complete) {
            if(stringf.length() < 32){
                char randomChar = (char) (secureRandom.nextInt(max - min) + min);
                if (randomChar > 47 && randomChar <= 57 || randomChar >= 64 && randomChar <= 90 ||
                        randomChar > 96 && randomChar <= 122) {
                    stringf.append(randomChar);
                }
            }else{complete = true;}
        }
        System.out.println(stringf.length());
        return stringf;
    }
//SHA-256
    public static String currentEncrypt(String str, String hashAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(hashAlgorithm);

        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        String s = new String(hash, StandardCharsets.US_ASCII);
        System.out.println(s.length());
        return s;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        System.out.println("Customer Hashed Passwords: ");
//        System.out.println(currentEncrypt("goodcC6pBupjrv9ZHXwfCFAwQrRbp5curir3", "SHA-256"));
//        System.out.println(currentEncrypt("goodcC6pBupjrv9ZHXwfCFAwQrRbp5curir3", "SHA-256").toString());
//        System.out.println(currentEncrypt("foodwUOpfmTKoRnr6AeBQZVKpS@82vTtRtNn", "SHA-256"));
//        System.out.println(currentEncrypt("bananay5D8gkCKXqgXsnSRZcQ8DEajRwfrz`T5", "SHA-256"));
//        System.out.println(currentEncrypt("riceVLASga@XUDdHXAmmiZ0TVobGl2FORgvl", "SHA-256"));
//        System.out.println("Employee Hashed Passwords: ");
//        System.out.println(currentEncrypt("password1IFiI9hVQdrfSq4vsDttyao@xnbtPKJvB", "SHA-256"));
//        System.out.println(currentEncrypt("password2RhqArzpgiSqzWYi2mMLeTPSNTKLcRcvr", "SHA-256"));
//        System.out.println(currentEncrypt("password3C1nJh396WSQx0rFdYnShFXd4y6z84aSI", "SHA-256"));
//        System.out.println(currentEncrypt("password4V5SboFYmrB4PmdvERcq7cxU`Ox4fWVxC", "SHA-256"));
//        System.out.println("Manager Hashed Passwords: ");
//        System.out.println(currentEncrypt("cats2BhkMR4zC8j2oSfP5WRXH9Pu6hEDVlDQ", "SHA-256"));
//        System.out.println(saltGenerator(33, 127));

            String password = "Hi";
            String s = currentEncrypt(password.concat(saltGenerator(48, 127).toString()), "SHA-256");
            System.out.println(s);

        //        for(int i  = 0; i < byteArray.length; i++){
        //        System.out.print(byteArray[i]);
        //        }
    }
}