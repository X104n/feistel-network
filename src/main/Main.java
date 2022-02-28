package main;


import java.util.Arrays;

/**
 * This is where everything is run from
 */
public class Main {

    static String testKey = "AAAABBBB";
    static String key = "3ACDDEF2";

    static String testText = "123456789ABCDEF0";
    static String text = "1F2A0E341F2A0E34";

    static String testCipher = "3A3DEFF7ABBAC8DB";
    static String cipher = "AAAAAAAAAAAAAAAA";

    static int[] polymer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1};

    public static void main(String[] args) {
        // Mandatory encryption and decryption
        System.out.println("Encrypting mandatory conditions");
        encrypt(key, text);
        System.out.println("Decrypting mandatory conditions");
        decrypt(key, cipher);

        // Test data encryption and decryption
        System.out.println("Encrypting test conditions");
        encrypt(testKey, testText);
        System.out.println("Decrypting test conditions");
        decrypt(testKey, testCipher);
    }


    private static void encrypt(String key, String text) {
        Function function = new Function(key, polymer);

        System.out.print("Key: ");
        System.out.println(Arrays.toString(function.getKey()));

        Encryption e = new Encryption(text, function);

        System.out.print("Plaintext: ");
        System.out.println(Arrays.toString(e.plaintext));

        System.out.print("Decrypted message: ");
        System.out.println(Arrays.toString(e.runEncryption(8, true))+"\n");
    }

    private static void decrypt(String key, String cipher){
        Function testFunction = new Function(key, polymer);

        System.out.print("Key: ");
        System.out.println(Arrays.toString(testFunction.getKey()));

        Encryption e = new Encryption(cipher, testFunction);

        System.out.print("Cipher: ");
        System.out.println(Arrays.toString(e.plaintext));

        System.out.print("Encrypted message: ");
        System.out.println(Arrays.toString(e.runEncryption(8, false))+"\n");
    }

}
