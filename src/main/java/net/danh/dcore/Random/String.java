package net.danh.dcore.Random;

import java.util.List;
import java.util.Random;

public class String {

    /**
     * @param list String
     * @return random
     */
    public static String getRandomString(List<String> list) {
        Random r = new Random();
        int randomitem = r.nextInt(list.size());
        return list.get(randomitem);
    }
}
