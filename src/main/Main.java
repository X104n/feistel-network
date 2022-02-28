package main;


/**
 * This is where everything is run from
 */
public class Main {

    static String key = "AAAABBBB";
    static String text = "123456789ABCDEF0";
    static int[] polymer = {1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        Function function = new Function(key, polymer);

        System.out.println("Key: ");
        System.out.println(getArray(function.getKey()));

        Encryption e = new Encryption(text, function);

        System.out.println("Plaintext:");
        System.out.println(getArray(e.plaintext));

        System.out.println("Decrypted message:");
        System.out.println(getArray(e.run(7)));

        System.out.println("Round keys: ");
        System.out.println(getArray(Operations.roundKey(function.getKey(), 0)));
        System.out.println(getArray(Operations.roundKey(function.getKey(), 8)));

//        System.out.println(getArray(Operations.roundKey(function.getKey(), 1)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 2)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 3)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 4)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 5)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 6)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 7)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 8)));
//        System.out.println(getArray(Operations.roundKey(function.getKey(), 9)));



        /**
        int[] test = new int[8];
        test[0] = 1;
        test[7] = 1;
        System.out.println(function.getArray(test));
        Operations.roundKey(test, 4);
        System.out.println(function.getArray(test));
*/
        //Encryption mandatoryEncryption = new Encryption(key, text, function);
    }

    public static String getArray(int[] array){
        StringBuilder result = new StringBuilder();
        for (int j : array) {
            result.append(j);
        }
        return result.toString();
    }

}
