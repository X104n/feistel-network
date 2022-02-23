package core;

import documents.Main;

public class Operations {

    public static int[] SingleHexToBinary(char hex) {
        int[] binary = new int[4];
        switch (hex) {
            case '0':
                binary = new int[]{0, 0, 0, 0};
                return binary;
            case '1':
                binary = new int[]{0, 0, 0, 1};
                return binary;
            case '2':
                binary = new int[]{0, 0, 1, 0};
                return binary;
            case '3':
                binary = new int[]{0, 0, 1, 1};
                return binary;
            case '4':
                binary = new int[]{0, 1, 0, 0};
                return binary;
            case '5':
                binary = new int[]{0, 1, 0, 1};
                return binary;
            case '6':
                binary = new int[]{0, 1, 1, 0};
                return binary;
            case '7':
                binary = new int[]{0, 1, 1, 1};
                return binary;
            case '8':
                binary = new int[]{1, 0, 0, 0};
                return binary;
            case '9':
                binary = new int[]{1, 0, 0, 1};
                return binary;
            case 'A':
                binary = new int[]{1, 0, 1, 0};
                return binary;
            case 'B':
                binary = new int[]{1, 0, 1, 1};
                return binary;
            case 'C':
                binary = new int[]{1, 1, 0, 0};
                return binary;
            case 'D':
                binary = new int[]{1, 1, 0, 1};
                return binary;
            case 'E':
                binary = new int[]{1, 1, 1, 0};
                return binary;
            case 'F':
                binary = new int[]{1, 1, 1, 1};
                return binary;

        }
        throw new IllegalArgumentException("Char not in index");
    }

    public static int[] XOR(int[] v1, int[] v2) {
        int[] result = new int[v1.length];
        for (int i = 0; i < v1.length; i++) {
            int b = ((v1[i] + v2[i]) % 2);
            result[i] = b;
        }
        return result;
    }

    public static int bitXOR(int b1, int b2) {
        int result;
        int b = (b1 + b2) % 2;
        result = b;
        return result;
    }

    public static int[] AND(int[] v1, int[] v2) {
        int[] result = new int[v1.length];

        for (int i = 0; i < v1.length; i++) {
            if (v1[i] == 1 && v2[i] == 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static int bitAND(int b1, int b2) {
        int result;
        if (b1 == 1 && b2 == 1) {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }

    public static int[] multiply(int[] A, int[] B, int[] polymerVector) {
        int[] result = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            if (B[i] == 1) {
                int[] shift = A.clone();
                Main.printArray(A);
                for (int j = 0; j < i; j++) {
                    boolean overflow = (shift[(A.length - 1)] == 1);
                    shift = shifter(shift);
                    if (overflow) {
                        shift = Operations.XOR(shift, polymerVector);
                    }
                    System.out.print("After shifting ");
                    Main.printArray(shift);
                }
                result = Operations.XOR(result, shift);
            }
        }
        return result;
    }

    public static int[] shifter(int[] input) {
        for (int i = (input.length - 1); i >= 1; i--) {
            input[i] = input[i - 1];
        }
        input[0] = 0;
        return input;
    }
}
