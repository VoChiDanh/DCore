package net.danh.dcore.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 */
public class Items {

    /**
     * @param input List Lore
     * @return input with color code
     */
    public static List<String> Lore(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(Chat.colorize(string));
        }
        return output;
    }
}