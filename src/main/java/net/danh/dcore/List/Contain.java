package net.danh.dcore.List;

import java.util.List;

/**
 * @version 1.2
 */
public class Contain {

    /**
     * @param list List
     * @param string String
     * @return true/false
     */
    public static boolean inList(List<String> list, String string) {
        return list.contains(string);
    }
}
