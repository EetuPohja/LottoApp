package fi.tuni.tamk.tiko.pohjaeetu.util;

/**
 * The class Arrays contains methods for array based operations, such as
 * converting String array into an int array.
 * 
 * @author Eetu Pohja
 */
public class Arrays {

    /**
     * Takes String array and converts and returns it as an int array.
     * 
     * The String array must only contain characters that can be converted 
     * to an int, otherwise the method will print out an error message and 
     * the value for the corresponding int array index will be 0.
     * 
     * @param array takes a String array which 
     * is to be converted to an int array.
     * @return the converted String array as an int array.
     */
    public static int [] toIntArray(String [] array) {
        int [] convertedArr = new int [array.length];
        for (int i=0; i<array.length; i++) {
            try {
                convertedArr[i] = Integer.parseInt(array[i]);
            } catch (NumberFormatException e) {
                System.out.println("Could not convert given " + 
                                   "String into an integer.");
            }
        }

        return convertedArr;
    }

    /**
     * Checks if the given value is found inside the given array and returns 
     * true or false accordingly.
     * 
     * @param value takes the value which is compared 
     * to values in the given array.
     * @param array takes the array which holds the values to be compared to.
     * @return true if value was found in the array and 
     * false if value was not found in the array.
     */
    public static boolean contains(int value, int [] array) {
        boolean foundValue = false;
        for (int i=0; i<array.length && !foundValue; i++) {
            if (array[i] == value) {
                foundValue = true;
            }
        }

        return foundValue;
    }

    
    /**
     * Takes two different int arrays, compares the values in them and
     * returns the amount of matching pairs.
     * 
     * For the values to match, they do not have to have the same array 
     * index, every value in the first array is compared to every value in 
     * the second array.
     * 
     * @param array1 first array used to compare values.
     * @param array2  second array used to compare values.
     * @return the amount of matching pairs found in the given arrays.
     */
    public static int containsSameValues(int [] array1, int [] array2) {
        boolean isSame = false;
        int amountMatching = 0;
        for (int i=0; i<array1.length; i++) {

            isSame = false;
            
            for (int j=0; j<array1.length && !isSame; j++) {
                if (array1[i] == array2[j]) {
                    amountMatching++;
                    isSame = true;
                }
            }
        }

        return amountMatching;
    }

    /**
     * Takes an int array, copies it into a new int array 
     * excluding the given index and returns the new array.
     * 
     * The new array's length will always be original array's 
     * length - 1.
     * 
     * @param original the array which wil be copied except the given index.
     * @param index the index which will be excluded when copying 
     * the original array to the new array.
     * @return the new array without the excluded index.
     */
    public static int [] removeIndex(int [] original, int index) {
        int [] newArr = new int [original.length - 1];

        // used to add one to the index spots which will be copied when 
        // the to be excluded index is encountered.
        int hopOver = 0;
        for (int i=0; i<newArr.length; i++) {
            if (i == index) {
                hopOver = 1;
            }
            newArr[i] = original[i + hopOver];
        }

        return newArr;
    }

    /**
     * Creates and returns an ascending int array with values in the 
     * range of given values. 
     * 
     * A value in index will always be greater by one than the value 
     * in the previous index. For example, array with startNum 5 and 
     * endNum 10 will hold numbers 5, 6, 7, 8, 9, 10.
     * 
     * @param startNum the number from where the values inside the array will 
     * start to ascend.
     * @param endNum the greatest/last number in the array.
     * @return an array with all integer numbers in the given range.
     */
    public static int [] createAscNumberArray(int startNum, int endNum) {
        int [] numArr = new int [endNum - startNum + 1];
        for (int i=0; i<numArr.length; i++) {
            numArr[i] = startNum + i;
        }

        return numArr;
    }

    /**
     * Creates and returns a String array holding the given amount of 
     * helper Strings for naming placement numbers, 
     * for example "1st", "2nd", "3rd".
     * 
     * @param amount the amount of indexes the array will hold.
     * @return a String array holding the given amount of 
     * helping Strings for naming numbers.
     */
    public static String [] makeHelperStringArray(int amount) {
        String [] helpers = new String [amount];
        for (int i=0; i<helpers.length; i++) {
            switch (i) {
                case 0:
                    helpers[i] = i + 1 + "st";
                    break;
                case 1:
                    helpers[i] = i + 1 + "nd";
                    break;
                case 2:
                    helpers[i] = i + 1 + "rd";
                    break;
                default :
                    helpers[i] = i + 1 + "th";
                    break;
            }
        }

        return helpers;
    }

    /**
     * Takes an array, sorts the values into ascending order and returns it.
     * 
     * @param array takes the array that will be sorted.
     * @return the sorted array.
     */
    public static int [] sort(int [] array) {
        int curLowest = 0;
        int valueHolder = 0;
        for (int i=0; i<array.length; i++) {
            curLowest = i;
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[curLowest]) {
                    curLowest = j;
                }
            }

            if (curLowest != i) {
                valueHolder = array[i];
                array[i] = array[curLowest];
                array[curLowest] = valueHolder;
            }
        }

        return array;
    }

    /**
     * Takes an int array, sets all values to zero and returns the array.
     * 
     * @param arr takes the array which values will be set to zeroes.
     * @return the array holding zeroes.
     */
    public static int [] setToZeroes(int [] arr) {
        for (int i=0; i<arr.length; i++) {
            arr[i] = 0;
        }

        return arr;
    }
}