import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readNum("Enter x = ");
        isXMatchInterval(x);

        int n = (int) readNum("Enter n = ");
        isNPositive(n);

        double e = readNum("Enter e = ");

        printResults(x,n,e);

    }

    static double readNum(String text) {
        System.out.print(text);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

    static void isXMatchInterval(double num) {
        if (num <= -1 || num >= 1) {
            System.out.print("Enter the correct spacing (-R,R) : (-1 < x < 1)");
            System.exit(1);
        }
    }

    static void isNPositive(double num) {
        if (num < 0) {
            System.out.print("Enter n > 0");
            System.exit(1);
        }
    }

    static double nextTerm(double last, int i, double x) {
        return last * (i - 2) * x * x / i;
    }

    static double calculateSumN(double x, int n) {
        double firstTerm = x;
        double sum = 0;

        for (int i = 3; i < 2 * n + 2; i += 2) {
            sum += firstTerm;
            firstTerm = nextTerm(firstTerm, i, x);
        }
        return sum * 2;
    }

    static double calculateSumE(double x, double e, int n) {
        double sum = 0;
        double firstTerm = x;

        for (int i = 3; i <= 2 * n + 2; i += 2) {
            if (firstTerm > e) {
                sum += firstTerm;
            } else {
                return sum * 2;
            }
            firstTerm = nextTerm(firstTerm, i, x);
        }
        return sum * 2;
    }

    static double calculateLn(double x) {
        return Math.log((1 + x) / (1 - x));
    }

    static void writeSumN(double sumN) {
        System.out.println("The sum of n terms of a given form = " + sumN);
    }

    static void writeSumE(double sumE, String e) {
        System.out.println("The sum of those terms that are greater in absolute value than e" + e + " = " + sumE);
    }

    static void writeLn(double SumLN) {
        System.out.println("Function value using Math methods = " + SumLN);
    }

    static void printResults(double num1, int num2, double num3) {

        double x = num1;
        int n = num2;
        double e = num3;

        writeSumN(calculateSumN(x, n));
        writeSumE(calculateSumE(x, e, n), "");
        writeSumE(calculateSumE(x, e / 10, n), "/10");
        writeLn(calculateLn(x));
    }

}




