package main;

public class Function {

    int[] key;
    int[] polymer;

    public Function(String initialKey, int[] field){
        this.key = keyConverter(initialKey);
        this.polymer = field;
    }

    /**
     *  This converts the key from hex to binary
     * @param key The original key
     * @return The original key in binary form
     */
    public int[] keyConverter(String key){
        int[] result = new int[key.length()*4];
        for(int i = 0; i<key.length(); i++){
            char c = key.charAt(i);
            int[] temp = Operations.hexToBinary(c);
            System.arraycopy(temp, 0, result, (i * 4), temp.length);
        }
        return result;
    }

    /**
     * F(x, k) = x^2 * k + x * k^2 is the function that is being used in the assignment
     *
     * @param rightSide Half of the block that is used as input
     * @param round what round it is, so we can use the right key
     * @return output of the function
     */
    public int[] calculate(int[] rightSide, int round){
        int[] result1;
        int[] result2;
        int[] roundKey = Operations.roundKey(this.key, round);

        result1 = Operations.multiply(rightSide, rightSide, polymer);
        result1 = Operations.multiply(result1, roundKey, polymer);

        result2 = Operations.multiply(roundKey, roundKey, polymer);
        result2 = Operations.multiply(result2, rightSide, polymer);

        return Operations.XOR(result1, result2);

    }

    public int[] getKey(){
        return key;
    }

}
