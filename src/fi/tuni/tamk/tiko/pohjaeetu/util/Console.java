package fi.tuni.tamk.tiko.pohjaeetu.util;

import java.util.Scanner;

/**
 * The class Console contains methods used to interact with the console.
 * 
 * The main purpose for this class is to give and take information 
 * from the user via console.
 * 
 * @author Eetu Pohja
 */
public class Console {

    /**
     * Takes user input through console, assigns it to a String and returns it.
     * 
     * @return the user input as a String.
     */
    public static String readUserInput() {
        Scanner input =  new Scanner(System.in);
        String uInput = input.nextLine();
        return uInput;
    }

    /**
     * Takes user input through console, converts it to an int and returns it.
     * 
     * If the user's input contains any characters that can not be converted 
     * to an int, the method will print out the given error message and 
     * asks again for user input.
     * 
     * @param errorMessage determinates the error message which is used if 
     * the user gives an invalid input.
     * @return the user input as an integer.
     */
    public static int readInt(String errorMessage) {
        int userInput = 0;
        boolean invalidInput = true;
        while (invalidInput) {
            invalidInput = false;
            try {
                userInput = Integer.parseInt( readUserInput() );
            } catch(NumberFormatException e) {
                System.out.println(errorMessage);
                invalidInput = true;
            }
        }

        return userInput;
        
    }

    /**
     * Takes user input through console, converts it to an int and returns it.
     * 
     * If the user's input contains any characters that can not be converted 
     * to an int or the input is not in the range of min - max, the method 
     * will print out the given error message and asks again for user input.
     * 
     * @param min determinates the lowest accepted value from user.
     * @param max determinates the greatest accepted value from user.
     * @param errorMessageNonNumeric error message displayed if user's input 
     * is not numeric.
     * @param errorMessageNonMinAndMax error message displayed if user's input 
     * is not in the range of min - max.
     * @return the user input as an integer.
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, 
                              String errorMessageNonMinAndMax) {
        int userInput = readInt(errorMessageNonNumeric);
        while (userInput < min || userInput > max) {
            System.out.println(errorMessageNonMinAndMax);
            userInput = readInt(errorMessageNonNumeric);
        }

        return userInput;
    }

    /**
     * Asks for user input until given determined
     * accepted input and returns it.
     * 
     * If user input can not be found in acceptedInputs array then 
     * given error message will be displayed and user will be asked 
     * again for input. 
     * 
     * @param acceptedInputs takes an array holding all accepted user inputs.
     * @param errorMessage error message displayed if user's input is not 
     * found in acceptedInputs array.
     * @return the user input as a String.
     */
    public static String readString(String [] acceptedInputs, 
                                    String errorMessage) {
        String userInput = "";
        boolean invalidInput = true;
        while (invalidInput) {
            userInput = readUserInput();
            for (int i=0; i<acceptedInputs.length; i++) {
                if (userInput.equals(acceptedInputs[i])) {
                    invalidInput = false;
                } else {
                    System.out.println(errorMessage);
                }
            }
        }

        return userInput;
    }
}