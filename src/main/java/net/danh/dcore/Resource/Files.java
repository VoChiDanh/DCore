package net.danh.dcore.Resource;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Files {

    private final String name;
    private final JavaPlugin core;
    private File file;
    private FileConfiguration config;

    public Files(JavaPlugin core, String name) {
        this.name = name;
        this.core = core;
        this.file = new File(core.getDataFolder(), name + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void load() {
        this.file = new File(core.getDataFolder(), this.name + ".yml");
        if (!this.file.exists()) {
            try {
                core.saveResource(this.name + ".yml", false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(this.file);
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
