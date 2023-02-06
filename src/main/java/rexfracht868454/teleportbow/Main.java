package rexfracht868454.teleportbow;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private RecipeManager recipeManager = new RecipeManager();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerListener();
        recipeManager.loadRecipes();
        getLogger().info("TeleportBow enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("TeleportBow disabled");
    }

    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new TeleportBowListener(this), this);
    }

    @Override
    public FileConfiguration getConfig() {
        return super.getConfig();
    }
}
