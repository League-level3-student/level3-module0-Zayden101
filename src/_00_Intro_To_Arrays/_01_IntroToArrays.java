package _00_Intro_To_Arrays;

import java.util.Random;

public class _01_IntroToArrays {
    public static void main(String[] args) {
        // 1. declare and Initialize an array 5 Strings
        String[] array = new String[5];
        
		 int smallestNumber = 50;
		 int biggestNumber = 0;
        
        array[0] = "a";
        array[1] = "b";
        array[2] = "c";
        array[3] = "d";
        array[4] = "e";

        // 2. print the third element in the array
        System.out.println(array[2]);
        // 3. set the third element to a different value
        array[2] = "cc";
        // 4. print the third element again
        System.out.println(array[2]);
        // 5. use a for loop to set all the elements in the array to a string
        //    of your choice
        for (int i = 0; i < array.length; i++) {
        array[i] = "w";
        }
        // 6. use a for loop to print all the values in the array
        //    BE SURE TO USE THE ARRAY'S length VARIABLE
        for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
        }
        // 7. make an array of 50 integers
        int[] array2 = new int[50];

        // 8. use a for loop to make every value of the integer array a random
        //    number
        Random gen = new Random();
        
        for (int i = 0; i < array2.length; i++) {
        array2[i] = gen.nextInt(50);
        }
        // 9. without printing the entire array, print only the smallest number
        //    on the array
        for (int i = 0; i<array.length; i++) {
			if(i==0) {
				smallestNumber = array2[i];
				continue;
			}
			if (array2[i] < smallestNumber) {
				smallestNumber = array2[i];
			}else {
				continue;
			}
        }
			System.out.println("small " + smallestNumber);
		
        // 10 print the entire array to see if step 8 was correct
        
        // 11. print the largest number in the array.
	        for (int i = 0; i<array.length; i++) {
				if(i==0) {
					biggestNumber = array2[i];
					continue;
				}
				if (array2[i] > biggestNumber) {
					biggestNumber = array2[i];
				}else {
					continue;
				}
	        }
			System.out.println("big " + biggestNumber);

        
			// 12. print only the last element in the array
        System.out.println("last " + array2[49]);

    }
    
    
}

