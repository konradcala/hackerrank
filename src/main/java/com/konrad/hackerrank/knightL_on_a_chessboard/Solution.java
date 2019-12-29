package com.konrad.hackerrank.knightL_on_a_chessboard;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
public class Solution {

    // Complete the knightlOnAChessboard function below.
    static int[][] knightlOnAChessboard(int n) {
        int[][] output = new int[n - 1][n - 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                output[i][j] = countMinimumMoves(i + 1, j + 1, n);
                output[j][i] = output[i][j];
            }
        }
        return output;
    }

    private static int countMinimumMoves(int i, int j, int n) {
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<Position> moves = new LinkedList<>();
        moves.add(new Position(0, 0, 0));
        while (!moves.isEmpty()) {
            Position p = moves.poll();
            Position[] nextMoves = generateNextPositions(p, i, j);
            for (Position next : nextMoves) {
                if (next.i == n - 1 && next.j == n - 1) {
                    return next.numberOfMoves;
                }
                if (isValid(next, n) && visited[next.i][next.j] != true) {
                    visited[next.i][next.j] = true;
                    moves.add(next);
                }
            }

        }

        return -1;
    }

    private static boolean isValid(Position p, int n) {
        return p.i >= 0 && p.i < n && p.j >= 0 && p.j < n;
    }

    private static Position[] generateNextPositions(Position p, int i, int j) {
        Position[] nextMoves = new Position[8];
        nextMoves[0] = new Position(p.numberOfMoves + 1, p.i - i, p.j - j);
        nextMoves[1] = new Position(p.numberOfMoves + 1, p.i + i, p.j - j);
        nextMoves[2] = new Position(p.numberOfMoves + 1, p.i - i, p.j + j);
        nextMoves[3] = new Position(p.numberOfMoves + 1, p.i + i, p.j + j);
        nextMoves[4] = new Position(p.numberOfMoves + 1, p.i - j, p.j - i);
        nextMoves[5] = new Position(p.numberOfMoves + 1, p.i + j, p.j - i);
        nextMoves[6] = new Position(p.numberOfMoves + 1, p.i - j, p.j + i);
        nextMoves[7] = new Position(p.numberOfMoves + 1, p.i + j, p.j + i);
        return nextMoves;
    }

    static class Position {
        int numberOfMoves;
        int i;
        int j;

        public Position(int numberOfMoves, int i, int j) {
            this.numberOfMoves = numberOfMoves;
            this.i = i;
            this.j = j;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] result = knightlOnAChessboard(n);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                bufferedWriter.write(String.valueOf(result[i][j]));

                if (j != result[i].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
