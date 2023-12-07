package org.example.lab0;

public class Variant7 {
    public int sumProiz(int a) {
        return (a/10)+(a%10);
    }
    public boolean bCenter(int a, int b, int c) {
        return (a < b && b < c) || (a > b && b > c);
    }

    public int findMinIndex(int a, int b) {
        if (a < b) {
            return 1;
        } if (a > b) {
            return 2;
        }
            return 0;

    }

    public String gramovka(int n, double m) {
        double res = 0.0;
        switch (n) {
            case 1:
                res = m;
                break;
            case 2:
                res = m / 1000000;
                break;
            case 3:
                res = m / 1000;
                break;
            case 4:
                res = m * 1000;
                break;
            case 5:
                res = m * 100;
                break;
            default:
                res = -1;
                break;
        };
        return String.valueOf(res);
    }


    public int sumfromAtoB(int a, int b) {
        int sum = 0;

        for (int i = a; i <= b; i++) {
            sum += i;
        }

        return sum;
    }

    public int findSmallThenN(int n) {
        int k = 1;

        while ((k * k) <= n) {
            k++;
        }

        return k;
    }

    public int[] findIndex(int[] n) {

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < n.length; i++) {
            if (n[i] > n[maxIndex]) {
                maxIndex = i;
            }
            if (n[i] <= n[minIndex]) {
                minIndex = i;
            }
        }

        return new int[]{maxIndex + 1, minIndex + 1};
    }


    public int[] revArr(int[] arr) {
        int[] new_arr = new int[arr.length];
        int k = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            new_arr[k] = arr[i];
            k++;
        }
        return new_arr;
    }


    public int[] getMatrixRow(int[][] matrix, int k) {
        if (k > 0 && k <= matrix.length) {
            int n = matrix[k - 1].length;
            int[] result = new int[n];

            for (int j = 0; j < n; j++) {
                result[j] = matrix[k - 1][j];
            }

            return result;
        } else {
            return new int[]{-1};
        }
    }
}
