package lab0;

import org.example.lab0.Variant7;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

import static org.testng.Assert.assertEquals;


public class Variant7Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test(dataProvider = "sumProizData")
    public void sumProizTest(int A, int expected) {
        int actual = new Variant7().sumProiz(A);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] sumProizData() {
        return new Object[][]{
                {66, 12},
                {25, 7},
                {33, 6},
                {71, 8},
                {7, 7}
        };
    }

    @Test(dataProvider = "bCenterMidData")
    public void bCenterTest(int a, int b, int c, boolean expected) {
        boolean actual = new Variant7().bCenter(a,b,c);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] bCenterData() {
        return new Object[][]{
                {1, 2, 3, true},
                {0, 0, 0, false},
                {-7, -5, -3, true},
                {300, 200, 100, true},
                {-300, -224, -100, true},

        };
    }

    @Test(dataProvider = "findMinIndexData")
    public void findMinIndexTest(int a, int b, int expected) {
        int actual = new Variant7().findMinIndex(a,b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] findMinIndexData() {
        return new Object[][]{
                {4, 5, 1},
                {6, 6, 0},
                {-60, -60, 0},
                {155, 151, 2},
                {-400, -322, 1}
        };
    }

    @Test(dataProvider = "gramovkaData")
    public void gramovkaTest(int n, double m, String expected) {
        String actual = new Variant7().gramovka(n, m);
        assertEquals(expected, actual);
    }

    @DataProvider
    public Object[][] gramovkaData() {
        return new Object[][]{
                {1, 1.0, "1.0"},
                {3, 5.0, "0.005"},
                {6, -1.0, "-1.0"},
        };
    }
    @Test(dataProvider = "sumfromAtoBData")
    public void sumfromAtoBTest(int a, int b, int expected) {
        int actual = new Variant7().sumfromAtoB(a,b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] sumfromAtoBData() {
        return new Object[][]{
                {1, 3, 6},
                {3, 8, 33},
                {5, 6, 11},
                {6, 10, 40},
        };
    }

    @Test(dataProvider = "findSmallThenNData")
    public void findSmallThenNTest(int n, int expected) {
        int actual = new Variant7().findSmallThenN(n);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] findSmallThenNData() {
        return new Object[][]{
                {25, 6},
                {50, 8},
                {100, 11},
                {35, 6},
                {4, 3},
        };
    }

    @Test(dataProvider = "findIndexData")
    public void findIndexTest(int[] n, int[] expected) {
        int[] actual = new Variant7().findIndex(n);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] findIndexData() {
        return new Object[][]{
                {new int[]{10, 5, 8, 2, 7, 5, 3} , new int[]{1,4}},
                {new int[]{10, 1, 8, 2, 7, 5, 3} , new int[]{1,2}},
                {new int[]{10, 33, 8, 2, 7, 5, 3} , new int[]{2,4}},
                {new int[]{10, 33, 1, 2, 66, 6, 3} , new int[]{5,3}},
                {new int[]{10, 33, 8, 2, 123, 1, 3} , new int[]{5,6}},
        };
    }

    @Test(dataProvider = "revArrData")
    public void revArrTest(int[] arr, int[] expected) {
        int[] actual = new Variant7().revArr(arr);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] revArrData() {
        return new Object[][]{
                {new int[]{1, 2, 3, 4, 5} , new int[]{5, 4, 3 ,2 ,1}},
                {new int[]{5, 4, 3 ,2 ,1} , new int[]{1, 2, 3, 4, 5}},
                {new int[]{12, 3, 55 ,76 ,1} , new int[]{1, 76, 55, 3, 12}},
                {new int[]{5, 4, 11} , new int[]{11, 4, 5}},
                {new int[]{199, 200, 304, 55} , new int[]{55, 304, 200, 199}},
        };
    }

    @Test(dataProvider = "getMatrixRowData")
    public void getMatrixRowTest(int[][] matrix, int k, int[] expected) {
        int[] actual = new Variant7().getMatrixRow(matrix, k);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] getMatrixRowData() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2, new int[]{4,5,6}},

        };
    }

}