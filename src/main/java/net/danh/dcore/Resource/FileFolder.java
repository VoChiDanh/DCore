package net.danh.dcore.Resource;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class FileFolder {

    private final String name;
    private final String foldername;
    private final JavaPlugin core;
    private final File file;
    private final String filename;
    private FileConfiguration config;

    public FileFolder(JavaPlugin core, String name, String foldername) {
        this.name = name;
        this.foldername = foldername;
        this.core = core;
        this.filename = name;
        this.file = new File(core.getDataFolder() + File.separator + foldername, name + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void load() {
        File folder = new File(core.getDataFolder(), this.foldername);
        if (!folder.exists()) {
            try {
                folder.mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File file = new File(folder, this.filename + ".yml");
        if (!file.exists()) {
            try {
                core.saveResource(file.getPath(), false);
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
