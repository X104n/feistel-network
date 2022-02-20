package core;

import java.util.ArrayList;

public class Operations {

    public int[] SingleHexToBinary(char hex) {
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
        return binary;
    }
}
