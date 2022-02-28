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
        System.out.println(getArray(function.getKey()));
        Encryption e = new Encryption(text, function);
        System.out.println(getArray(e.plaintext));
        System.out.println(getArray(e.run(8)));


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
        String result = "";
        for(int i = 0; i<array.length; i++){
            result = result + array[i] + "";
        }
        return result;
    }
}
