package rexfracht868454.teleportbow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rexfracht868454.teleportbow.listener.TeleportBow;

public final class Main extends JavaPlugin {

    private RecipeManager recipeManager = new RecipeManager();

    @Override
    public void onEnable() {
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
        pluginManager.registerEvents(new TeleportBow(), this);
    }
}
