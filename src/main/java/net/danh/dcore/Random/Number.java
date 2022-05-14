package net.danh.dcore.Random;

import java.util.Random;

public class Number {

    /**
     * @param min min
     * @param max max > min
     * @return random
     */
    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
