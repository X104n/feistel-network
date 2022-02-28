package main;

/**
 * This will encrypt the plaintext to the ciphertext using a Feistel Network
 */
public class Network {

    private final Function function;
    private final int[] plaintext;

    /**
     * Make a new instance of a network when you want to calculate something using a feistel network
     * @param text Text that is being processed
     * @param f Function that is being used in the network
     */
    public Network(String text, Function f) {
        this.function = f;
        this.plaintext = binaryText(text);
    }

    public int[] binaryText(String text) {
        return function.keyConverter(text);
    }

    /**
     * This is where alle the operations is put together to runt the feistel network algorithm
     *
     * @param rounds Amount of rounds the network should cycle
     * @param encrypt Whether to encrypt or not
     * @return the final answer
     */
    public int[] runEncryption(int rounds, boolean encrypt) {
        //Copy left side of the text
        int[] left = new int[plaintext.length / 2];
        System.arraycopy(plaintext, 0, left, 0, plaintext.length / 2);
        //Copy the right side of the text
        int[] right = new int[plaintext.length / 2];
        if (plaintext.length - plaintext.length / 2 >= 0)
            System.arraycopy(plaintext, plaintext.length / 2, right, 0, plaintext.length - plaintext.length / 2);
        // If we are encrypting we begin with round key 0, and if we are decrypting we begin with round key n-1
        if (encrypt) {
            for (int i = 0; i < rounds; i++) {
                // The function part
                int[] rightFunction = function.calculate(right, i);
                // The Xor part
                int[] tempRight = Operations.XOR(rightFunction, left);

                left = right.clone();
                right = tempRight.clone();
            }
        } else {
            for (int i = (rounds - 1); i >= 0; i--) {
                // The function part
                int[] leftFunction = function.calculate(left, i);
                // The Xor part
                int[] tempLeft = Operations.XOR(leftFunction, right);

                right = left.clone();
                left = tempLeft.clone();
            }
        }

        // Append the two arrays into the final answer
        int[] result = new int[plaintext.length];
        for (int i = 0; i < result.length; i++) {
            if (i < result.length / 2) {
                result[i] = left[i];
            } else {
                result[i] = right[i - (result.length / 2)];
            }
        }

        return result;
    }

    public int[] getPlaintext(){
        return this.plaintext;
    }

}

