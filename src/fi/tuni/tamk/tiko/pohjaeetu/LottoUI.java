package fi.tuni.tamk.tiko.pohjaeetu;

import fi.tuni.tamk.tiko.pohjaeetu.util.Math;
import fi.tuni.tamk.tiko.pohjaeetu.util.Arrays;
import fi.tuni.tamk.tiko.pohjaeetu.util.Console;

/**
 * The class LottoUI is the lotto program's main class that utilizes 
 * other classes and methods to create the final program.
 * 
 * @author Eetu Pohja
 */
public class LottoUI {
    
    /**
      * LottoUI's main method which determinates what the program 
      * does.
      *
      * The program asks user for numbers, then randomly selects 
      * same amount of numbers out of numberspool and checks how 
      * long it takes for user numbers to match the randomly selected 
      * numbers if the randomly selected numbers are reselected every week. 
      * If the matching takes longer than 120 years, the program tries again.
      * The amount of numbers and the numberspool size can be changed
      * in the code. Variable amountOfLottoNums determinates the amount of 
      * numbers and variable lottoNumbersPoolSize determinates 
      * the size of the numberspool.
      * 
      * @param args user can give his/hers numbers already here.
      */
    public static void main(String [] args) {

        /*
        IMPORTANT!
        Minimum and maximum numbers user can choose from.
        Variable lottoNumbersPoolSize should always be tied to these,
        for example if min = 5 and max = 40, then lottoNumbersPoolSize
        should be 35, or if min = 1 and max = 40, then 
        lottoNumbersPoolSize should be 40.
        */
        int min = 1;
        int max = 40;

        // The size of the numberspool where the right numbers are chosen from.
        // IMPORTANT! This should be tied to variable min and max.
        int lottoNumbersPoolSize = 40;

        // How many lotto numbers there are.
        int amountOfLottoNums = 7;

        // Array holding the correct lotto numbers.
        int [] correctNums = new int [amountOfLottoNums];
        
        // Array holding the user's lotto numbers.
        int [] userNumbers = new int [amountOfLottoNums];

        final String instructionsPart1 = "Please give your ";
        final String instructionsPart2 = " unique number in the range of " + 
                                         min + " - " + max + ".";

        final String eMsgDefault = "Please give an" + instructionsPart2;
        final String eMsgNonNumeric = "Please give a number.";
        final String eMsgNotUnique = "Not an unique number!";
        final String userWon = "You won!";

        final String numsRightPart1 = "Got ";
        final String numsRightPart2 = " right! Took ";
        final String numsRightPart3 = " years";

        final String tookTooLong = "Althought it took more than a " + 
                                   "lifetime, let's try that again.";

        final String eMsgAllNumsNotValid = "All numbers were not unique or " +
                                           "not inside the numberspool " + 
                                           "range.";

        final String eMsgContinuing = " Continuing to ask numbers one by one.";

        final String eMsgNotRightAmountOfNums = "User did not give right " + 
                                                "amount of numbers.";

        // Used to help the user to understand how 
        // many numbers he/she has given already.
        final String [] namingHelpers = Arrays.makeHelperStringArray(amountOfLottoNums);

        // User's newest given lotto number.
        int curUserNum = 0;

        // Used to check if user gives the same number multiple times.
        boolean notUniqueNum = true;

        // The amount of numbers user got right.
        int correctNumberAmount = 0;

        // Amount of days it takes to get a certain amount of numbers right.
        // IMPORTANT! Needs to be set to at least 43800 for the program to run.
        int days = 43800;

        // Used to check if user has gotten more numbers right than last time.
        int tempAmount = 0;


        // Used to hold temporal array when checking if user 
        // gave valid input via command line argument.
        int [] tempArr = new int [amountOfLottoNums];

        // Used to check if user gave valid input via command line argument.
        boolean allNotValid = false;

        // Checks if user gave numbers through command line argument.
        if (args.length == amountOfLottoNums) {
            
            // Set user numbers to given command line argument values.
            userNumbers = Arrays.toIntArray(args);
            tempArr = userNumbers;
            for (int i=0; i<tempArr.length && !allNotValid; i++) {
                if (tempArr[i] >= min && tempArr[i] <= max) {

                    // Removes the currently checked number from the array so 
                    // it is not checked when looking for unique numbers.
                    tempArr = Arrays.removeIndex(userNumbers, i);

                    // Checks if currently checked number is unique.
                    allNotValid = Arrays.contains(userNumbers[i], tempArr);
                } else {
                    allNotValid = true;
                }   
            }

            if (allNotValid) {
                System.out.println(eMsgAllNumsNotValid + eMsgContinuing);
            }
        }

        if (args.length > 0 && args.length != amountOfLottoNums) {
            System.out.println(eMsgNotRightAmountOfNums + eMsgContinuing);
        }

        // If user have not given valid numbers yet, 
        // continues to ask them one by one.
        if (allNotValid || args.length != amountOfLottoNums) {
            
            // Resets user numbers back to zeroes.
            userNumbers = Arrays.setToZeroes(userNumbers);

            // Asks user for seven unique numbers until given valid numbers.
            for (int i=0; i<userNumbers.length; i++) {
                notUniqueNum = true;
                while (notUniqueNum) {
                    System.out.println(instructionsPart1 + namingHelpers[i] + 
                                       instructionsPart2);
                    curUserNum = Console.readInt(min, max, eMsgNonNumeric, 
                                                 eMsgDefault);
                    notUniqueNum = Arrays.contains(curUserNum, userNumbers);
                    if (notUniqueNum) {
                        System.out.println(eMsgNotUnique);
                    } else {
                        userNumbers[i] = curUserNum;
                    }
                }
            }
        }

        // Loops until user wins within 120 years.
        while (days / 365 >= 120) {
            System.out.println("\nCalculating...");

            // Reset values to zero for each iteration start.
            correctNumberAmount = 0;
            tempAmount = 0;
            days = 0;

            // Loops until user wins.
            while (correctNumberAmount < amountOfLottoNums) {

                // Gets random numbers for the correct lotto numbers.
                correctNums = calculateLotto(amountOfLottoNums, min, max);

                // Checks how many numbers the user got right.
                correctNumberAmount = Arrays.containsSameValues(userNumbers, 
                                                                correctNums);

                days += 7;

                // Checks if user has gotten more numbers right 
                // and if so, prints the amount of time it took.
                if (correctNumberAmount > tempAmount) {
                    while (correctNumberAmount > tempAmount) {
                        tempAmount++;
                        System.out.println(numsRightPart1 + tempAmount + 
                                           numsRightPart2 + (days / 365) + 
                                           numsRightPart3);
                    }
                }
            }

            System.out.println(userWon);

            // Prints if winning took longer than 120 years.
            if (days / 365 >= 120) {
                System.out.println(tookTooLong);
            }
        }

        
    }

     /**
      * Calculates the given amount of randomized unique numbers and 
      * returns them in an int array.
      * 
      * @param howManyLottoNums the amount of numbers the lotto has.
      * @param min the lowest value of numberspool where lotto 
      * numbers are randomized from.
      * @param max the greatest value of numberspool where lotto 
      * numbers are randomized from.
      * @return the correct lotto numbers inside an array.
      */
    public static int [] calculateLotto(int howManyLottoNums, 
                                        int min, int max) {
        
        // Array that will hold correct lotto numbers.
        int [] correctLottoNums = new int [howManyLottoNums];
        
        // Array holding the numbers pool where the correct 
        // numbers are randomized from.
        int [] possLottoNums = new int [max - min + 1];

        // Index used to pick a number from possLottoNums pool.
        int index = 0;

        // Gives the values for possLottoNums array.
        possLottoNums = Arrays.createAscNumberArray(min, max);
        
        // Randomizes the correctLottoNums.
        for (int i=0; i<correctLottoNums.length; i++) {
            index = Math.getRandom(0, possLottoNums.length - 1);
            correctLottoNums[i] = possLottoNums[index];
            possLottoNums = Arrays.removeIndex(possLottoNums, index);
        }

        return correctLottoNums;
    }
}