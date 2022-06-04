package net.danh.dcore.Random;

import java.util.List;
import java.util.Random;

public class RString {

    /**
     * @param list RString
     * @return random
     */
    public static java.lang.String getRandomString(List<java.lang.String> list) {
        Random r = new Random();
        int randomitem = r.nextInt(list.size());
        return list.get(randomitem);
    }
}
