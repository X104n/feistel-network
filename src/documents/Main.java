package documents;

public class Main {
    public static void main(String[] args) {

        printArray(MandatoryConditions.mandatoryPolymer("AAAABBBB"));
//        int[] test = new int[] {1,1,0,0};
//        int[] test2 = new int[] {1,0,1,1};
//        int[] irr = new int[] {1,1,0,0};
//        Multiplication multi = new Multiplication(30, irr);
//        printArray(multi.multiply(test, test2));
        //printArray(multi.shifter(test));
        //printArray(multi.shifter(test2));
        //printArray(multi.shifter(irr));
    }

    public static void printArray(int[] array){
        System.out.print("[ ");
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }
}
