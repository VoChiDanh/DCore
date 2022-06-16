package net.danh.dcore.Utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.danh.dcore.DCore.papistatus;

/**
 * @version 1.0
 */
public class Chat {

    private final static char COLOR_CHAR = ChatColor.COLOR_CHAR;

    /**
     * @param input RString
     * @return string with color code
     */
    public static String colorize(String input) {

        input = ChatColor.translateAlternateColorCodes('&', input);
        if (input.startsWith("&#")) {
            input = translateHexColorCodes(input);
        }

        return input;
    }


    /**
     * @param message message
     * @return message with hex color
     */
    private static String translateHexColorCodes(String message) {

        final Pattern hexPattern = Pattern.compile("&#" + "([A-Fa-f0-9]{6})" + "");
        Matcher matcher = hexPattern.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);

        while (matcher.find()) {

            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x" + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1) + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3) + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5));

        }

        return matcher.appendTail(buffer).toString();
    }

    public static List<String> loreColorize(List<String> input) {
        List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(colorize(string));
        }
        return output;
    }

    public static String papi(Player p, String input) {
        if (papistatus) {
            String output = PlaceholderAPI.setPlaceholders(p, input);
            output = colorize(output);
            return output;
        } else {
            return input;
        }
    }

    public static List<String> papiLore(Player p, List<String> input) {
        if (papistatus) {
            List<String> output = new ArrayList<>();
            for (String in : input) {
                String out = PlaceholderAPI.setPlaceholders(p, in);
                out = colorize(out);
                output.add(out);
            }
            return output;
        } else {
            return input;
        }
    }

    public static List<String> lowerStrings (List<String> input) {
        List<String> output = new ArrayList<>();
        for (String s : input) {
            output.add(s.toLowerCase());
        }
        return output;
    }
}
