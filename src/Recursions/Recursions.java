package Recursions;

public class Recursions {
    public static void main(String[] args) {
        System.out.println("Factorial: " + factorial(5));
        System.out.println("Fabonacci: " + fibonacciNumber(6));

        int[] arr = new int [10];

        arr = fillArrayWithFibonacciNumbers(arr, 0);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    static int factorial(int num) {
        if (num > 1) {
            num = factorial(num - 1) * num;
        }
        return num;
    }

    static int fibonacciNumber(int num) {
        if (num > 1) {
            num = fibonacciNumber(num - 1) + fibonacciNumber(num - 2);
        }
        return num;
    }

    static int[] fillArrayWithFibonacciNumbers(int[] arr, int index) {
        if(index < arr.length){
            arr[index] = fibonacciNumber(index);
            fillArrayWithFibonacciNumbers(arr, ++index);
        }
        return arr;
    }
}
