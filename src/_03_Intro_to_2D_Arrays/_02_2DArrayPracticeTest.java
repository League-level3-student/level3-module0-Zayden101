package _03_Intro_to_2D_Arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class _02_2DArrayPracticeTest {
    @Test
    void test_1_Init1() {
        Integer[][] p = new _02_2DArrayPractice().test1();
        assertTrue(p.length == 3);
        assertTrue(p[0].length == 3);
        assertTrue(p[1].length == 3);
        assertTrue(p[2].length == 3);
    }

    @Test
    void test_2_Init2() {
        String[][] p = new _02_2DArrayPractice().test2();
        assertTrue(p.length == 2);
        assertTrue(p[0].length == 4);
        assertTrue(p[1].length == 4);
    }
    
    @Test
    void test_3_Init3() {
        Boolean[][] p = new _02_2DArrayPractice().test3();
        assertTrue(p.length == 5);
        assertTrue(p[0].length == 2);
        assertTrue(p[1].length == 2);
        assertTrue(p[2].length == 2);
        assertTrue(p[3].length == 2);
        assertTrue(p[4].length == 2);
    }
    
    @Test
    void test_4_index1() {
        Object obj = new _02_2DArrayPractice().test4();
        assertTrue(obj != null);
    }
    
    @Test
    void test_5_index2() {
        Object obj = new _02_2DArrayPractice().test5();
        assertTrue(obj != null);
    }
    
    @Test
    void test_6_oneRowSum() {
        Integer sum = new _02_2DArrayPractice().test6();
        assertTrue(sum == 26);
    }
    
    @Test
    void test_7_oneColumnSum() {
        Integer sum = new _02_2DArrayPractice().test7();
        assertTrue(sum == 14);
    }
    
    int[][] testMatrix = { { 10, 20, 30 },
                           { 80, -10, 100 },
                           { 75, -25, -50 } };

    @Test
    void test_8_RowSum() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getSumByRow(testMatrix, 0) == 60);
        assertTrue(methods.getSumByRow(testMatrix, 1) == 170 );
        assertTrue(methods.getSumByRow(testMatrix, 2) == 0);
    }
    
    @Test
    void test_9_ColumnSum() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getSumByColumn(testMatrix, 0) == 165);
        assertTrue(methods.getSumByColumn(testMatrix, 1) == -15 );
        assertTrue(methods.getSumByColumn(testMatrix, 2) == 80);
    }
    
    @Test
    void test_10_EastNeighbor() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getEastNeighbor(testMatrix, 2, 0) == -25 );
        assertTrue(methods.getEastNeighbor(testMatrix, 0, 2) == null );
    }
    
    @Test
    void test_11_WestNeighbor() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getWestNeighbor(testMatrix, 2, 0) == null );
        assertTrue(methods.getWestNeighbor(testMatrix, 0, 2) == 20 );
    }
    
    @Test
    void test_12_NorthNeighbor() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getNorthNeighbor(testMatrix, 2, 0) == 80 );
        assertTrue(methods.getNorthNeighbor(testMatrix, 0, 2) == null );
    }
    
    @Test
    void test_13_SouthNeighbor() {
        _02_2DArrayPractice methods = new _02_2DArrayPractice();
        assertTrue(methods.getSouthNeighbor(testMatrix, 2, 0) == null );
        assertTrue(methods.getSouthNeighbor(testMatrix, 0, 2) == 100 );
    }
}
