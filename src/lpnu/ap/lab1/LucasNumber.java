package lpnu.ap.lab1;

import java.util.Arrays;
import java.util.Scanner;

/** @author Oleksandr Panchuk */
public class LucasNumber {
    /**
     * {@code long} arrLucas - array of Lucas numbers
     * {@code int} num - id of member Lucas numbers
     * {@code long} valueNum - value of member Lucas numbers
     * {@code int} digit - last digit
     */
    private static long [] arrLucas;
    private int num;
    private long valueNum;
    private int digit;

    /** constructor of class
     * @param num
     * @param  digit
     * */
    public LucasNumber(int num, int digit) {
        this.num = num;
        this.digit = digit;
        getResult();
    }
    /** getter num */
    public int getNum() {
        return num;
    }
    /** getter digit */
    public int getDigit() {
        return digit;
    }

    /** getter value of number */
    public long getValueNum() {
        return valueNum;
    }

    /** static method for creating an array of hatch numbers */
    public static void createArrLucas() {
        long [] array = new long[90];
        long n1 = 1, n2 = 3;
        int j = 0;
        array[j++] = n1;
        array[j++] = n2;

        for (int i = 0; i < 90 - 2; i++) {
            long temp = n1;
            n1 = n2;
            n2 += temp;
            array[j++] = n2;
        }
        arrLucas = Arrays.copyOf(array, j);
    }
    /** method of obtaining the result
    * @return an array of long numbers ending with the given digit
    */
    public long [] getResult() {
        long [] array = new long[num];
        int j = 0;

        for (int i = 0; i < num; i++) {
            if (arrLucas[i] % 10 == digit) array[j++] = arrLucas[i];
        }
        this.valueNum = arrLucas[num - 1];
        return Arrays.copyOf(array, j);
    }

    /** method main
     *  the loop will continue until "-1" is entered
     *  output the result to the user at the end of method
     *  */
    public static void main(String[] args) {

        int indexLimit = 100;
        int index = 0;
        LucasNumber.createArrLucas();
        LucasNumber [] numbers = new LucasNumber[indexLimit];

        System.out.println("Welcome to LucasNumbers programme!!! (N <= 90) Input '-1' to finish!");
        while (true) {

            Scanner scanner = new Scanner(System.in);       // input N
            System.out.print("Input 'N': ");
            int N = scanner.nextInt();
            if (N == -1) {
                System.out.println("\nResult!\n");
                break;
            }
            if (N < 1) {
                System.out.println("\n N < 0 \t\t Try again!!\n");
                continue;
            }
            if (index + 1 == indexLimit) {
                System.out.println("\nEnd of array! Lets check for results!\n");
                break;
            }

            if (N > 90) {
                System.out.println("\n N > 90 \t\t Try again!!\n");
                continue;
            }

            System.out.print("Input 'digit': ");
            int digit = scanner.nextInt();

            /* add instance of LucasNumber to array */
            numbers[index++] = new LucasNumber(N, digit);
        }

        for (int i = 0; i < index; i++) {
            System.out.println("\nTest " + (i + 1) +
                    "\n\tValue of ( N = " + numbers[i].getNum() + " ) = " + numbers[i].getValueNum() +
                    "\n\tDigit = " + numbers[i].getDigit() + "\nResult: ");
            /* print result */
            if (numbers[i].getResult().length != 0)
                System.out.println(Arrays.toString(numbers[i].getResult()));
            else
                System.out.println("There are no such numbers that end in a given digit!"); // print if the array is empty
        }
    }
}