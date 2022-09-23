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
     * @param min min
     * @param max max
     * @return random
     */
    public static double getRandomDouble(double min, double max) {
        if (max >= min + 2) {
            Random r = new Random();
            return r.nextDouble(max - min) + min;
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
            if (!s.contains("-")) {
                return Integer.parseInt(s);
            } else {
                return getRandomInt(Integer.parseInt(s.split("-")[0]), Integer.parseInt(s.split("-")[1]));
            }
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
            if (!s.contains("-")) {
                return Double.parseDouble(s);
            } else {
                return getRandomDouble(Double.parseDouble(s.split("-")[0]), Double.parseDouble(s.split("-")[1]));
            }
        } catch (NumberFormatException | NullPointerException e) {
            return 0d;
        }
    }
}
