package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static int n;
    static int m;

    public static void main(String[] args) {
        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        } else {
            System.out.println("You not input arguments for method main in Task1");
            return;
        }

        if (n - m == -1) {
            getSpacingsDelta(n, m);
        } else if (n % 2 == 0) {
            getSpacings(n, m);
        } else {
            getSpacingsNonEven(n, m);
        }
    }

    public static void getSpacings(int n, int m) {
        List<Integer> path = new ArrayList<>();
        Integer[] arrayA = new Integer[n];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = i + 1;
        }

        int count = 0;
        for (int i = 0; i < n; i = (i + (m - 1)) % n) {
            count++;
            path.add(arrayA[i]);
            if (count == n / 2) {
                break;
            }
        }

        for (int element : path) {
            System.out.print(element);
        }
    }

    public static void getSpacingsDelta(int n, int m) {
        List<Integer> path = new ArrayList<>();
        Integer[] arrayA = new Integer[n];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = i + 1;
        }

        for (int i = 0; i < n; i = (i + (m - 1)) % n) {
            path.add(arrayA[i]);
            break;
        }

        for (int element : path) {
            System.out.print(element);
        }
    }

    public static void getSpacingsNonEven(int n, int m) {
        List<Integer> path = new ArrayList<>();
        Integer[] arrayA = new Integer[n];

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = i + 1;
        }
        int count = 0;
        for (int i = 0; i < n; i = (i + (m - 1)) % n) {
            count++;
            path.add(arrayA[i]);
            if (count == n) {
                break;
            }
        }

        for (int element : path) {
            System.out.print(element);
        }
    }
}
