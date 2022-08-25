package lpnu.ap.lab1;

import java.util.Arrays;
import java.util.Scanner;

public class LucasNumber {
    private int num;
    private long valueNum;
    private int digit;
    public LucasNumber(int num, int digit) {
        this.num = num;
        this.digit = digit;
        getResult();
    }

    public int getNum() {
        return num;
    }

    public int getDigit() {
        return digit;
    }
    public long getValueNum() {
        return valueNum;
    }

    public long [] getResult() {
        long [] array = new long[num];
        long n1 = 1, n2 = 3;
        int j = 0;
        if (n1 == digit) array[j++] = n1;
        if (n2 == digit) array[j++] = n2;

        for (int i = 0; i < num - 2; i++) {
            long temp = n1;
            n1 = n2;
            n2 += temp;

            if (n2 % 10 == digit) array[j++] = n2;
        }
        this.valueNum = n2;
        long [] result = Arrays.copyOf(array, j);
        return result;
    }

    public static void main(String[] args) {

        int indexLimit = 100;
        int index = 0;
        LucasNumber [] numbers = new LucasNumber[indexLimit];

        System.out.println("Welcome to LucasNumbers programme!!! Input '-1' to finish!");
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Input 'N': ");
            int N = scanner.nextInt();
            if (N < 0 || index + 1 == indexLimit) break;
            System.out.print("Input 'digit': ");
            int digit = scanner.nextInt();

            numbers[index++] = new LucasNumber(N, digit);
        }

        for (int i = 0; i < index; i++) {
            System.out.println("\nTest " + (i + 1) +
                    "\n\tValue of ( N = " + numbers[i].getNum() + " ) = " + numbers[i].getValueNum() +
                    "\n\tDigit = " + numbers[i].getDigit() + "\nResult: ");
            if (numbers[i].getResult().length != 0)
                System.out.println(Arrays.toString(numbers[i].getResult()));
            else
                System.out.println("There are no such numbers that end in a given digit!");
        }
    }
}