package com.archer.other;

import java.util.Scanner;

/**
 * archeryue
 * 8/18/16.
 */
public class Poj1141 {

    private static void printResult(char[] in, int[][] choose, int i, int j) {
        if (i > j) {
            return;
        }

        if (i == j) {
            if (in[i] == '(' || in[i] == ')') {
                System.out.print("()");
            } else {
                System.out.print("[]");
            }
            return;
        }

        if (choose[i][j] == -1) {
            System.out.print(in[i]);
            printResult(in, choose, i + 1, j - 1);
            System.out.print(in[j]);
        } else {
            printResult(in, choose, i, choose[i][j]);
            printResult(in, choose, choose[i][j] + 1, j);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] in = scanner.nextLine().toCharArray();

        int[][] d = new int[in.length][in.length];
        int[][] choose = new int[in.length][in.length];

        for (int i = 0; i < in.length; i++) {
            d[i][i] = 1;
            for (int j = i + 1; j < in.length; j++) {
                choose[i][j] = -1;
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int p = 1; p < in.length; p++) {
            for (int i = 0, j = i + p; j < in.length; i++, j++) {
                for (int k = i; k < j; k++) {
                    if (d[i][k] + d[k + 1][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k + 1][j];
                        choose[i][j] = k;
                    }
                }
                if ((in[i] == '(' && in[j] == ')')
                    || (in[i] =='[' && in[j] == ']')) {
                    if (d[i + 1][j - 1] < d[i][j]) {
                        d[i][j] = d[i + 1][j - 1];
                        choose[i][j] = -1;
                    }
                }
            }
        }

        printResult(in, choose, 0, in.length - 1);
        System.out.println("");
    }

}
