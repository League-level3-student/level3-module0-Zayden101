package _04_Crazy_Digital_Painting;



import java.awt.Color;

import java.util.Iterator;



public class CrazyDigitalPainting {

    // 1. Create two final static integers for the width and height of the display.

	final static Integer WIDTH = 500;

	final static Integer HEIGHT = 500;

	

    // 2. Create a 2D array of Color objects. You will need to import

    //    java.awt.Color. Initialize the size of the array using the 

    //    integers created in step 1.



	 Color[][] array = new Color[WIDTH][HEIGHT];



    public CrazyDigitalPainting() {

        // 3. Open the crazy_digital_painting.png file and look at the image.



        // 4. Iterate through the 2D array and initialize each Color object

        //    to a new color. The sample image was created using the following 

        //    pattern:

    	for (int i = 0; i < WIDTH; i++) {

		

    	for (int j = 0; j < HEIGHT; j++) {

            array[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i + j) % 256, j % 256);
    		//array[i][j] = new Color(i % 135, (i * 5) % 135, j % 135);
    		//array[i][j] = new Color(i % 256, (i + 10) % 50, j % 256);
    		//array[i][j] = new Color(i % 70, (i + 10) % 256, j % 80);
    		//array[i][j] = new Color(i % 256, (j * 40) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (j + 40) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (j * j) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * i * j) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * i + j * j) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * i * i + j) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * (j + i + j + i + j + i)) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, ((i + j) * (j + i)) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * j * 20) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * j * 60) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * (99 * i)) % 256, j % 256);
    		//array[i][j] = new Color(i % 256, (i * (99 * j)) % 256, j % 256);

    		
    		
    		
    		
    		
    	}

    	

    	}



        // 5. Come up with your own pattern to make a cool crazy image.



        // 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 

        //    to show off your picture.

    	ColorArrayDisplayer.displayColorsAsImage(array);

    }



    public static void main(String[] args) {

        new CrazyDigitalPainting();

    }

}