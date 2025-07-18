package com.jst;

import java.util.ArrayList;
import java.util.List;

public class FindOnesRowsAndColumns {

	public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
        };

        List<Integer> onesRows = findOnesRows(matrix);
        List<Integer> onesColumns = findOnesColumns(matrix);

        System.out.println("Rows with all ones: " + onesRows);
        System.out.println("Columns with all ones: " + onesColumns);
    }

    public static List<Integer> findOnesRows(int[][] matrix) {
        List<Integer> onesRows = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            boolean allOnes = true;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != 1) {
                    allOnes = false;
                    break;
                }
            }
            if (allOnes) {
                onesRows.add(i);
            }
        }
        return onesRows;
    }

    public static List<Integer> findOnesColumns(int[][] matrix) {
        List<Integer> onesColumns = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            boolean allOnes = true;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] != 1) {
                    allOnes = false;
                    break;
                }
            }
            if (allOnes) {
                onesColumns.add(j);
            }
        }
        return onesColumns;
    }
}
