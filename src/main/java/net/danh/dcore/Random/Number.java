package net.danh.dcore.Random;

import java.util.Random;

public class Number {

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }
}
