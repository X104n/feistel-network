package main;


/**
 * This is where everything is run from
 */
public class Main {

    static String key = "AAABBB";
    static String text = "ABCD";
    static int[] polymer = {1,1,1,1,1,1,1,1};

    public static void main(String[] args) {
        Function function = new Function(key, polymer);
        int[] test = new int[8];
        test[0] = 1;
        test[7] = 1;
        System.out.println(function.getArray(test));
        Operations.roundKey(test, 4);
        System.out.println(function.getArray(test));

        //Encryption mandatoryEncryption = new Encryption(key, text, function);
    }

}
