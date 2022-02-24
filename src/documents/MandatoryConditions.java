package documents;

import core.Multiplication;
import core.Operations;

public class MandatoryConditions {

    String mandatoryKey = "3ACDDEF2";
    String mandatoryPlaintext = "1F2A0E341F2A0E34";
    String mandatoryCiphertext = "AAAAAAAAAAAAAAAA";
    Multiplication m;
    int[] poly = new int[] {1,1,1,1};

    /**
     * The function is: F(x, k) = x^2 * k + x * k^2
     *
     * @param key The key
     * @param input the right part of the block
     * @return Cipher
     */
    public int[] mandatoryFunction(int[] key, int[] input){
        int[] result;
        int[] result2;
        result = Operations.multiply(input, input, poly);
        result = Operations.multiply(result, key, poly);

        result2 = Operations.multiply(key, key, poly);
        result2 = Operations.multiply(result2, input, poly);

        result = Operations.XOR(result, result2);
        return result;
    }

    public static int[] mandatoryPolymer(String input){
        int[] result = new int[input.length()*4];
        for(int i = 0; i < input.length(); i++){
            int[] temp = Operations.hexToBinary(input.charAt(i));
            result = add(result, temp);
            for(int j = 0; j < temp.length; j++){
                result[i] = temp[j];
            }
        }
        return result;
    }

    public static int[] add(int[] a, int[] b){
        int j = 0;
        for(int i = (a.length - 1); i < (a.length + b.length - 2); i++){
            a[i] = b[j];
            j++;
        }
        return a;
    }
}
