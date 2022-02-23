package core;

import documents.Main;

public class Multiplication {

    int field;
    int[] polymerVector;

    public Multiplication(int finiteField, int[] vector) {
        this.field = finiteField;
        this.polymerVector = vector;
    }

    public int[] multiply(int[] A, int[] B) {
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

    public int[] shifter(int[] input) {
        for (int i = (input.length - 1); i >= 1; i--) {
            input[i] = input[i - 1];
        }
        input[0] = 0;
        return input;
    }

}
