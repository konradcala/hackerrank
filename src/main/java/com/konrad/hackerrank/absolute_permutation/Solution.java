package com.konrad.hackerrank.absolute_permutation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;


//https://www.hackerrank.com/challenges/absolute-permutation/problem

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        if (k == 0) {
            return IntStream.range(1, n + 1).toArray();
        }
        if (k > n / 2) {
            return new int[]{-1};
        }

        int[] arr = new int[n];


        int sign = 1;
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (l == k) {
                l = 0;
                sign = sign * -1;
            }
            l++;

            arr[i] = (i+1) + k * sign;
            if(arr[i] > n) {
                return new int[]{-1};
            }
        }

        if(IntStream.of(arr).distinct().count() == n) {
            return arr;
        }

        return new int[]{-1};
    }

    private static boolean isValid(int positive, int[] arr, int[] used) {
        return positive > 0 && positive <= arr.length && used[positive - 1] == 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
