package net.danh.dcore;

import net.danh.dcore.Utils.Chat;

public class DCore {

    public static String getDCoreVersion() {
        return "v1.0";
    }

    public static void dCoreLog(String... message) {
        for (String messages : message) {
            System.out.println("[DCore] " + Chat.colorize(messages));
        }
    }

}
