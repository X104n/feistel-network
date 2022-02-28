package main;


/**
 * This class will have controll over the function you have choosen.
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
        return this.key;
    }


    public int[] keyConverter(String key){

        int[] result = new int[4*key.length()];
        for(int i = 0; i<key.length(); i++){
            int j = 0;
            char c = key.charAt(i);
            int[] temp = Operations.hexToBinary(c);
            for(int k : temp){
                result[(i*4)+j] = k;
                j++;
            }
        }
        return result;
    }
}
