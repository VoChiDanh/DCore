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
        if (max >= min + 2) {
            Random r = new Random();
            return r.nextInt(max - min) + min;
        } else {
            return min;
        }
    }

    /**
     * @param s RString
     * @return true/false
     */
    public static int getInt(java.lang.String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return 0;
        }
    }

    /**
     * @param s RString
     * @return true/false
     */
    public static double getDouble(java.lang.String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException | NullPointerException e) {
            return 0d;
        }
    }
}
