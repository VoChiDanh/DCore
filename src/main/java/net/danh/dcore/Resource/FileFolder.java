package net.danh.dcore.Resource;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.FileUtil;

import java.io.File;

public class FileFolder {

    private final String name;
    private final String foldername;
    private final JavaPlugin core;
    private File file;
    private FileConfiguration config;

    public FileFolder(JavaPlugin core, String name, String foldername) {
        this.name = name;
        this.foldername = foldername;
        this.core = core;
        this.file = new File(core.getDataFolder(), foldername + File.separator + name + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void load() {
        File file = new File(core.getDataFolder(), foldername + File.separator + name + ".yml");
        if (!this.file.exists()) {
            try {
                FileUtil.copy(this.file, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return this.file;
    }

    public FileConfiguration getConfig() {
        return this.config;
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
