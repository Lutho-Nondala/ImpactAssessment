package com.impact;

import java.util.Scanner;

public class Main implements NumberRangeSummarizer {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter list of numbers:");
        String numbers = scanner.nextLine().replaceAll(" ", "");
        System.out.println(main.summarizeCollection(main.collect(numbers)));
    }

    @Override
    public int[] collect(String input) {
        String[] numbers = input.split(",");
        int[] numbersConverted = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            try {
                numbersConverted[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException numberFormatException){

            }
        }
        return numbersConverted;
    }

    @Override
    public String summarizeCollection(int[] input) {
        String results = "";
        boolean flag = false;

        int count = 1;
        for (int i = 0; i < input.length; i++){
            if (input[i] + count == input[i + count]){
                while (input[i] + count == input[i + count]){
                    count++;
                    if (i + count >= input.length - 1){
                        flag = true;
                        break;
                    }
                }
                count--;

                if (i == 0){
                    results = results + input[i] + "-"+ (input[i] + count);
                } else {
                    results = results + ", " + input[i] + "-"+ (input[i] + count);
                }

                if (!(i == input.length - 1)){
                    i+=count;
                }
                if (flag){
                    if (i + 1 == input.length - 1){
                        results += ", " + input[i + 1];
                    }
                    i += 3;
                }
                count = 1;
            } else if (i == 0){
                results += input[i];
            } else {
                results += ", " + input[i];
                if (i + 1 == input.length - 1){
                    results += ", " + input[i + 1];
                    i += 3;
                }
            }
        }
        return results;
    }
}