package net.danh.dcore.Utils;

import net.danh.dcore.DCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @version 1.2
 */
public class File {

    /**
     * @param core Plugin
     * @param get FileConfiguration
     * @param file File.yml
     */
    public static void updateFile(JavaPlugin core, FileConfiguration get, String file) {
        HashMap<String, Object> newConfig = getFileVals(core, file);
        for (String var : get.getKeys(false)) {
            newConfig.remove(var);
        }
        if (newConfig.size() != 0) {
            for (String key : newConfig.keySet()) {
                get.set(key, newConfig.get(key));
            }
            DCore.dCoreLog("Updating file " + file);
            try {
                get.save(new java.io.File(core.getDataFolder(), file));
                DCore.dCoreLog("Update file " + file + " completed");
            } catch (IOException ignored) {
            }
        }
    }

    private static HashMap<String, Object> getFileVals(JavaPlugin core, String file) {
        HashMap<String, Object> var = new HashMap<>();
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.loadFromString(stringFromInputStream(core.getClass().getResourceAsStream("/" + file)));
        } catch (InvalidConfigurationException ignored) {
        }
        for (String key : config.getKeys(false)) {
            var.put(key, config.get(key));
        }
        return var;
    }

    private static String stringFromInputStream(InputStream in) {
        return new Scanner(in).useDelimiter("\\A").next();
    }
}

