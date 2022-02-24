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

    public String getArray(int[] array){
        String result = "";
        for(int i = 0; i<array.length; i++){
            result = result + array[i] + " ";
        }
        return result;
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
