package com.konrad.hackerrank.botclean;

import java.util.*;

//https://www.hackerrank.com/challenges/botclean/problem
public class Solution {

    private static Position target;

    private static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    static Set<Position> dirtyPositions = new HashSet<>();


    static void next_move(int posr, int posc, String[] board) {
        Position start = new Position(posr, posc);
        if (target == null) {
            target = findClosestDirtyPosition(start, dirtyPositions);
        }
        moveToTarget(start);
    }

    private static void moveToTarget(Position start) {
        if (start.row < target.row) {
            System.out.println("DOWN");
            return;
        } else if (start.row > target.row) {
            System.out.println("UP");
            return;
        }

        if (start.col < target.col) {
            System.out.println("RIGHT");
            return;
        } else if (start.col > target.col) {
            System.out.println("LEFT");
            return;
        }
        System.out.println("CLEAN");
        dirtyPositions.remove(target);
        target = null;
    }

    private static Position findClosestDirtyPosition(Position start, Set<Position> dirtyPositions) {
        int minDistance = Integer.MAX_VALUE;
        Position closestPosition = null;
        for (Position p : dirtyPositions) {
            int currentDistance = Math.abs(p.row - start.row) + Math.abs(p.col - start.col);
            if (minDistance > currentDistance) {
                minDistance = currentDistance;
                closestPosition = p;
            }
        }
        return closestPosition;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        String board[] = new String[5];
        for (int i = 0; i < 2; i++) pos[i] = in.nextInt();
        for (int i = 0; i < 5; i++) board[i] = in.next();
        init(board);
        next_move(pos[0], pos[1], board);
    }

    private static void init(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'd') {
                    dirtyPositions.add(new Position(i, j));
                }
            }
        }
    }
}
