package net.danh.dcore.Utils;

import com.google.common.base.Strings;

/**
 * @version 1.2
 */
public class Progress {

    /**
     * @param current           number
     * @param max               number
     * @param totalBars         number
     * @param symbol            symbol
     * @param completedColor    color
     * @param notCompletedColor color
     * @return RString
     */
    public static String getProgressBar(int current, int max, int totalBars, char symbol, String completedColor, String notCompletedColor) {
        float percent = (float) current / max;
        int progressBars = (int) (totalBars * percent);
        return Strings.repeat("" + Chat.colorize(completedColor + symbol), progressBars) + Strings.repeat("" + Chat.colorize(notCompletedColor + symbol), totalBars - progressBars);
    }

    /**
     * @param current number
     * @param max     number
     * @return double
     */
    public static double getPercentages(int current, int max) {
        int percent = current * 100 / max;
        return Math.round(percent * 10.0) / 10.0;
    }
}
