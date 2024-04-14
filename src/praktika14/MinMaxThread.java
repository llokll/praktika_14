package praktika14;

import java.util.Scanner;

public class MinMaxThread {

    static int maxValue;
    static int minValue;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a comma-separated numeric sequence:");
            String input = scanner.nextLine();
            String[] numbers = input.split(",");
            int[] intNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i].trim());
            }
            Thread maxThread = new Thread(() -> {
                maxValue = Integer.MIN_VALUE;
                for (int num : intNumbers) {
                    if (num > maxValue) {
                        maxValue = num;
                    }
                }
            });
            Thread minThread = new Thread(() -> {
                minValue = Integer.MAX_VALUE;
                for (int num : intNumbers) {
                    if (num < minValue) {
                        minValue = num;
                    }
                }
            });
            maxThread.start();
            minThread.start();
            try {
                maxThread.join();
                minThread.join();
            } catch (InterruptedException e) {
            }
            System.out.println("Max: " + maxValue);
            System.out.println("Min: " + minValue);
            }
    }
}