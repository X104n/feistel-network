package main;


/**
 * This class will have control over the function you have chosen.
 * As for the mandatory this function is: F(x, k) = x^2 * k + x * k^2
 */
public class Function {

    int[] key;
    int[] polymer;

    public Function(String initialKey, int[] field){
        this.key = keyConverter(initialKey);
        this.polymer = field;
    }


    /**
     * F(x, k) = x^2 * k + x * k^2
     * @param rightSide
     * @param round
     * @return
     */
    public int[] calculate(int[] rightSide, int round){
        int[] result = new int[rightSide.length];
        int[] result2 = new int[rightSide.length];
        int[] roundKey = Operations.roundKey(this.key, round);


        result = Operations.multiply(rightSide, rightSide, polymer);
        result = Operations.multiply(result, roundKey, polymer);

        result2 = Operations.multiply(roundKey, roundKey, polymer);
        result2 = Operations.multiply(result2, rightSide, polymer);

        result = Operations.XOR(result, result2);
        return result;

    }

    public int[] getKey(){
        return this.key;
    }


    public int[] keyConverter(String key){

        int[] result = new int[4*key.length()];
        for(int i = 0; i<key.length(); i++){
            char c = key.charAt(i);
            int[] temp = Operations.hexToBinary(c);
            for(int k = 0; k < temp.length; k++){
                result[(i*4)+k] = temp[k];
            }
        }
        return result;
    }
}
