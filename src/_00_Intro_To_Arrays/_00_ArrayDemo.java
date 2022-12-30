package _00_Intro_To_Arrays;

public class _00_ArrayDemo {
    public static void main(String[] args) {

        /*
         * Declaring and Initializing an array of Strings
         */
        String[] names = new String[5];
        
        names[0] = "Jan";
        names[1] = "Sara";
        names[2] = "Fred";
        names[3] = "Marc";
        names[4] = "Randy";

        /*
         * Declaring and Initializing an array of ints using a '{' and '}'
         */
        int[] ints = { 0, 1, 2, 3, 4 };
        
        /*
         * Iterating through array with a standard for-loop
         */
        System.out.println("Here's the array of Strings:\n");
        
        for(int i = 0; i < names.length; i++){
            String s = names[i];
            System.out.println("String at element " + i + " " + s);
        }
        System.out.println("\n");

        /*
         * Iterating through array with a for-each loop
         */
        System.out.println("Here's the array of ints:\n");
        
        for(Integer i : ints){
            System.out.println("int: " + i);
        }
        System.out.println("\n");
        
    }
}
