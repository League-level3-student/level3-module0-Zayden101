package _03_Intro_to_2D_Arrays;

public class _00_2DArrayDemo {
    public static void main(String[] args) {
        /* A two-dimensional array is simply an array of arrays.
         * The syntax for a two dimensional array is two square brackets [][]
         * int[][] array2D = { {1, 2, 3},
         *                     {4, 5, 6},
         *                     {7, 8, 9,} };
         *
         * array2D[0] is the array {1, 2, 3}
         * array2D[1] is the array {4, 5, 6}
         * array2D[2] is the array {7, 8, 9}
         *
         * For row 1:
         * array2D[1][0] is the number 4
         * array2D[1][1] is the number 5
         * array2D[1][2] is the number 6
         *
         * For column 0:
         * array2D[0][0] is the number 1
         * array2D[1][0] is the number 4
         * array2D[2][0] is the number 7
         */

        // array2d is an array of an array of ints. Or a 2D array.
        int[][] array2d;

        /*
         * Declaring and initializing the values of a 2D array
         */
        int[][] newArray2d = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};

        /*
         * Declaring and initializing the size of the 2D array
         */
        int[][] anotherArray2d = new int[5][5];
        // anotherArray2d is an array of 5 integer arrays, with each  
        // integer array containing 5 integers. 

        /*
         * Setting a single element from a 2D array
         */
        anotherArray2d[0][1] = 4;

        /*
         * Getting a single element from a 2D array
         */
        System.out.println(anotherArray2d[0][1]);

        /*
         * Looping through all the elements of a 2D array
         */
        
        // Loop through each 1D array
        for(int i = 0; i < newArray2d.length; i++) {

            // Loop through each element in the 1D array
            for(int j = 0; j < newArray2d[i].length; j++) {
                System.out.print(newArray2d[i][j]);
            }

            System.out.println();
        }
    }
}
