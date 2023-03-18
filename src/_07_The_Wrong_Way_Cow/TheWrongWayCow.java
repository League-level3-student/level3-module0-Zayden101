/*
 * https://www.codewars.com/kata/the-wrong-way-cow
 * 
 * Task
 * Given a field of cows find which one is the Wrong-Way Cow and return her
 * position.
 * 
 * Notes:
 * 
 * There are always at least 3 cows in a herd
 * There is only 1 Wrong-Way Cow!
 * Fields are rectangular
 * The cow position is zero-based [col,row] of her head (i.e. the letter c)
 * Examples
 * Ex1
 * 
 * cow.cow.cow.cow.cow
 * cow.cow.cow.cow.cow
 * cow.woc.cow.cow.cow
 * cow.cow.cow.cow.cow
 * Answer: [6,2]
 * 
 * Ex2
 * 
 * c..........
 * o...c......
 * w...o.c....
 * ....w.o....
 * ......w.cow
 * Answer: [8,4]
 * 
 * Notes
 * The test cases will NOT test any situations where there are "imaginary" cows,
 * so your solution does not need to worry about such things!
 * 
 * To explain - Yes, I recognize that there are certain configurations where an
 * "imaginary" cow may appear that in fact is just made of three other "real" cows.
 * 
 * In the following field you can see there are 4 real cows (3 are facing south and
 * 1 is facing north). There are also 2 imaginary cows (facing east and west).
 * 
 * ...w...
 * ..cow..
 * .woco..
 * .ow.c..
 * .c.....
*/

package _07_The_Wrong_Way_Cow;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the [col, row] coordinate position of the
        // head (letter 'c') of the wrong way cow!
        
    	int up = 0;
    	int down = 0;
    	int left = 0;
    	int right = 0;

    	
    	for (int c = 0; c < field.length; c++) {
    		for (int r = 0; r < field[0].length; r++) {
    			
    		if(field[c][r] == 'c') {
    			up+=checkUp(field,c,r);
    		}
    			
    		if(field[c][r] == 'c') {
    			down+=checkDown(field,c,r);
    		}

    		if(field[c][r] == 'c') {
    			up+=checkLeft(field,c,r);
    		}
    			
    		if(field[c][r] == 'c') {
    			down+=checkRight(field,c,r);
    		}
    		
    		}
    	}	
    					
    	
    	
        return null;
    }

	private static int checkDown(char[][] field, int c, int r) {

		if(r>field[0].length-3) {
			return 0;
		}
		
		if(field[c][r+1] == 'o' && field[c][r+2] == 'w') {

		return 1;
		}
			return 0;
	}

	

	private static int checkUp(char[][] field, int c, int r) {

		if(r<2) {
			return 0;
		}
		
		if(field[c][r-1] == 'o' && field[c][r-2] == 'w') {

		return 1;
		}
			return 0;
	}
	
	private static int checkLeft(char[][] field, int c, int r) {

		if(c>field[0].length-3) {
			return 0;
		}
		
		if(field[c+1][r] == 'o' && field[c+2][r] == 'w') {

		return 1;
		}
			return 0;
	}

	

	private static int checkRight(char[][] field, int c, int r) {

		if(c<2) {
			return 0;
		}
		
		if(field[c-1][r] == 'o' && field[c-2][r] == 'w') {

		return 1;
		}
			return 0;
	}

}
