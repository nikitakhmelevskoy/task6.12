import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double x = readNum("Enter x = ");
        if (isXMatchInterval(x)) {
            System.out.println("Enter the correct spacing (-R,R) : (-1 < x < 1)");
            return;
        }

        int n = (int) readNum("Enter n = ");
        if (isNPositiveAndInteger(n)) {
            System.out.println("Enter n > 0 and Integer");
            return;
        }

        double epsilon = readNum("Enter epsilon = ");

        printResults(x, n, epsilon);

    }

    static double readNum(String text) {
        System.out.print(text);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

    static boolean isXMatchInterval(double num) {
        return (num <= -1 || num >= 1);
    }

    static boolean isNPositiveAndInteger(int num) {
        return !(num > 0 && num % 1 == 0);
    }

    static double nextTerm(double previous, int i, double x) {
        return previous * (i - 2) * x * x / i;
    }

    static double calculateSumOfSequence(double x, int n) {
        double firstTerm = x;
        double sum = 0;

        for (int i = 3; i < 2 * n + 2; i += 2) {
            sum += firstTerm;
            firstTerm = nextTerm(firstTerm, i, x);
        }
        return sum * 2;
    }

    static double calculateSumOfSequenceMoreThanEpsilon(double x, double e, int n) {
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

    static double calculateLogarithm(double x) {
        return Math.log((1 + x) / (1 - x));
    }

    static void writeSumOfSequence(double sumN) {
        System.out.println("The sum of n terms of a given form = " + sumN);
    }

    static void writeSumOfSequenceMoreThanEpsilon(double sumE, String e) {
        System.out.println("The sum of those terms that are greater in absolute value than e" + e + " = " + sumE);
    }

    static void writeLogarithm(double SumLogarithm) {
        System.out.println("Function value using Math methods = " + SumLogarithm);
    }

    static void printResults(double num1, int num2, double num3) {

        double x = num1;
        int n = num2;
        double e = num3;

        writeSumOfSequence(calculateSumOfSequence(x, n));
        writeSumOfSequenceMoreThanEpsilon(calculateSumOfSequenceMoreThanEpsilon(x, e, n), "");
        writeSumOfSequenceMoreThanEpsilon(calculateSumOfSequenceMoreThanEpsilon(x, e / 10, n), "/10");
        writeLogarithm(calculateLogarithm(x));
    }

}