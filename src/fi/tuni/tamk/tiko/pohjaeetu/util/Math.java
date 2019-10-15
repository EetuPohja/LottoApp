package fi.tuni.tamk.tiko.pohjaeetu.util;

/**
 * The class Math contains methods for some simple math calculations.
 * 
 * @author Eetu Pohja
 */

public class Math {
    
    /**
     * Returns a randomized integer inside user determined range.
     * 
     * @param min the lowest value the randomized value can be.
     * @param max the greatest value the randomized value can be.
     * @return a randomized integer inside the user determined range.
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}