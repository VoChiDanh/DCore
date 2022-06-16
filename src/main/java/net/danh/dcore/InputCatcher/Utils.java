package net.danh.dcore.InputCatcher;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
    public static void callInputEvent(Player p, String m) {
        Bukkit.getServer().getPluginManager().callEvent(new InputCatchEvent(p, m));
    }

    public static boolean isText(String s) {
        if (s == null) {
            return false;
        } else {
            return s.matches("\\D");
        }
    }

    public static boolean isNumber(String s) {
        if (s == null) {
            return false;
        } else {
            return s.matches("([+\\-])?(\\d+)((\\.)(\\d+))?");
        }
    }

    public static boolean isByte(String s) {
        if(s == null) {
            return false;
        }
        try {
            Byte.parseByte(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isShort(String s) {
        if(s == null) {
            return false;
        }
        try {
            Short.parseShort(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isInteger(String s) {
        if(s == null) {
            return false;
        }
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isLong(String s) {
        if(s == null) {
            return false;
        }
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isFloat(String s) {
        if(s == null) {
            return false;
        }
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isDouble(String s) {
        if(s == null) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
