package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the size of the set A
        int size = scanner.nextInt();

        // Read in the elements of the set A
        String[] elements = new String[size];
        for (int i = 0; i < size; i++) {
            elements[i] = scanner.next();
        }

        // Read in the number of ordered pairs in the relation R
        int numPairs = scanner.nextInt();

        // Create a matrix to represent the relation R
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < numPairs; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            matrix[x][y] = true;
        }

        // Check if the relation is reflexive
        boolean reflexive = true;
        for (int i = 0; i < size; i++) {
            if (!matrix[i][i]) {
                reflexive = false;
                break;
            }
        }

        // Check if the relation is symmetric
        boolean symmetric = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    symmetric = false;
                    break;
                }
            }
        }

        // Check if the relation is transitive
        boolean transitive = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]) {
                    for (int k = 0; k < size; k++) {
                        if (matrix[j][k] && !matrix[i][k]) {
                            transitive = false;
                            break;
                        }
                    }
                }
            }
        }

        // Print out the matrix M that represents the relation R
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Print whether the relation is reflexive, symmetric, and transitive
        System.out.println("Reflexive: " + reflexive);
        System.out.println("Symmetric: " + symmetric);
        System.out.println("Transitive: " + transitive);

        // Print whether the relation is an equivalence relation
        if (reflexive && symmetric && transitive) {
            System.out.println("This is an equivalence relation.");
        } else {
            System.out.println("This is not an equivalence relation.");
        }
    }
}

