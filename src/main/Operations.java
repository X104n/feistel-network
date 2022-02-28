package main;

/**
 * This class has all the operations including XOR and multiplication.
 */
public class Operations {

    public static int[] roundKey(int[] key, int round) {
        int[] temp = key.clone();
        for (int j = 0; j < (round*4); j++) {
            int firstBit = temp[temp.length - 1];
            System.arraycopy(temp, 0, temp, 1, temp.length - 1);
            temp[0] = firstBit;
        }
        return temp;
    }

    public static int[] XOR(int[] v1, int[] v2) {
        int[] result = new int[v1.length];
        for (int i = 0; i < v1.length; i++) {
            int b = ((v1[i] + v2[i]) % 2);
            result[i] = b;
        }
        return result;
    }

    public static int[] multiply(int[] A, int[] B, int[] polymerVector) {
        int[] result = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                int[] shift = A.clone();
                for (int j = 0; j < i; j++) {
                    boolean overflow = (shift[(A.length - 1)] == 1);
                    shifter(shift);
                    if (overflow) {
                        shift = Operations.XOR(shift, polymerVector);
                    }
                }
                result = Operations.XOR(result, shift);
            }
        }
        return result;
    }

    public static void shifter(int[] input) {
        if (input.length - 1 >= 0) System.arraycopy(input, 0, input, 1, input.length - 1);
        input[0] = 0;
    }

    public static int[] hexToBinary(char hex) {
        int[] binary;
        switch (hex) {
            case '0' -> {
                binary = new int[]{0, 0, 0, 0};
                return binary;
            }
            case '1' -> {
                binary = new int[]{0, 0, 0, 1};
                return binary;
            }
            case '2' -> {
                binary = new int[]{0, 0, 1, 0};
                return binary;
            }
            case '3' -> {
                binary = new int[]{0, 0, 1, 1};
                return binary;
            }
            case '4' -> {
                binary = new int[]{0, 1, 0, 0};
                return binary;
            }
            case '5' -> {
                binary = new int[]{0, 1, 0, 1};
                return binary;
            }
            case '6' -> {
                binary = new int[]{0, 1, 1, 0};
                return binary;
            }
            case '7' -> {
                binary = new int[]{0, 1, 1, 1};
                return binary;
            }
            case '8' -> {
                binary = new int[]{1, 0, 0, 0};
                return binary;
            }
            case '9' -> {
                binary = new int[]{1, 0, 0, 1};
                return binary;
            }
            case 'A' -> {
                binary = new int[]{1, 0, 1, 0};
                return binary;
            }
            case 'B' -> {
                binary = new int[]{1, 0, 1, 1};
                return binary;
            }
            case 'C' -> {
                binary = new int[]{1, 1, 0, 0};
                return binary;
            }
            case 'D' -> {
                binary = new int[]{1, 1, 0, 1};
                return binary;
            }
            case 'E' -> {
                binary = new int[]{1, 1, 1, 0};
                return binary;
            }
            case 'F' -> {
                binary = new int[]{1, 1, 1, 1};
                return binary;
            }
        }
        throw new IllegalArgumentException("Char not in index");
    }
}
