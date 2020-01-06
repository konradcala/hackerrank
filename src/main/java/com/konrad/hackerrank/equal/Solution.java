package com.konrad.hackerrank.equal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/equal/problem
public class Solution {

    // Complete the equal function below.
    static int equal(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int result = Integer.MAX_VALUE;

        int i = 0;
        while (i < 5) {
            int target = min - i;
            int[] diff = Arrays.stream(arr).map(el -> el - target).toArray();
            int moves = Arrays.stream(diff).map(el -> reduce(el)).sum();
            result = Math.min(result, moves);
            i++;
        }
        return result;
    }

    private static int reduce(int el) {
        int moves = 0;
        moves += el / 5;
        moves += el % 5 / 2;
        moves += el % 5 % 2;
        return moves;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int result = equal(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
