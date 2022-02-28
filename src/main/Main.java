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

    static String testDecrypt = "3A3DEFF7ABBAC8DB";
    static String decrypt = "";

    static int[] polymer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1};

    public static void main(String[] args) {
        //mandatory();
        testEncrypt();
        testDecrypt();
    }

    private static void mandatory(){
        Function function = new Function(key, polymer);

        System.out.println("Key: ");
        System.out.println(Arrays.toString(function.getKey()));

        Encryption e = new Encryption(text, function);

        System.out.println("Plaintext:");
        System.out.println(Arrays.toString(e.plaintext));

        System.out.println("Decrypted message:");
        System.out.println(Arrays.toString(e.runEncryption(8, true)));
    }

    private static void testDecrypt(){
        Function testFunction = new Function(testKey, polymer);

        System.out.println("Key: ");
        System.out.println(Arrays.toString(testFunction.getKey()));

        Encryption e = new Encryption(testDecrypt, testFunction);

        System.out.println("Cipher:");
        System.out.println(Arrays.toString(e.plaintext));

        System.out.println("Encrypted message:");
        System.out.println(Arrays.toString(e.runEncryption(8, false)));
    }

    private static void testEncrypt(){
        Function testFunction = new Function(testKey, polymer);

        System.out.println("Key: ");
        System.out.println(Arrays.toString(testFunction.getKey()));

        Encryption e = new Encryption(testText, testFunction);

        System.out.println("Plaintext:");
        System.out.println(Arrays.toString(e.plaintext));

        System.out.println("Decrypted message:");
        System.out.println(Arrays.toString(e.runEncryption(8, true)));
    }

}
