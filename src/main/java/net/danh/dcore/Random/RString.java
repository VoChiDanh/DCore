package net.danh.dcore.Random;

import java.util.List;
import java.util.Random;

public class RString {

    /**
     * @param list RString
     * @return random
     */
    public static java.lang.String getRandomString(List<java.lang.String> list) {
        return list.get(new Random().nextInt(list.size()));
    }
}
