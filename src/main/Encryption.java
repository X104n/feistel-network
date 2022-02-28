package main;

/**
 * This will encrypt the plaintext to the ciphertext using a Feistel Network
 */
public class Encryption {

    Function function;
    int[] plaintext;


    public Encryption(String text, Function f){
        this.function = f;
        this.plaintext = binaryText(text);
    }

    public int[] binaryText(String text){
        return function.keyConverter(text);
    }

    public int[] run(int rounds){
        //Copy left side of the plain text
        int[] left = new int[plaintext.length/2];
        for(int i = 0; i < plaintext.length/2; i++){
            left[i] = plaintext[i];
        }
        //Copy the right side of the plain text
        int[] right = new int[plaintext.length/2];
        for(int i =  plaintext.length/2; i < plaintext.length; i++){
            right[i-plaintext.length/2] = plaintext[i];
        }
        //How many rounds we should run the network
        for(int i = 0; i < rounds; i++){

            //Put right into function
            int[] rightFunction = function.calculate(right, i);

            //xor function with left
            int[] tempRight = Operations.XOR(rightFunction, left);

            left = right.clone();
            right = tempRight.clone();
        }

//        int[] result = new int[plaintext.length];
//        for(int i = 0; i < result.length; i++){
//            if(i < result.length/2){
//                result[i] = left[i];
//            }else {
//                System.out.println(plaintext.length);
//                result[i] = right[i-(result.length/2)];
//            }
//            System.out.println("No");
//        }

        return right;
    }

}
