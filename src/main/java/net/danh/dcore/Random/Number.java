package net.danh.dcore.Random;

import java.util.Random;

/**
 * @version 1.0
 */
public class Number {

    /**
     * @param min min
     * @param max max
     * @return random
     */
    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    /**
     * @param s String
     * @return true/false
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
