package de.souperman.main;

import de.souperman.commands.CMDPokespawn;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    private Plugin plugin;

    @Override
    public void onEnable() {
        getLogger().info("Plugin [Pixelmon] started");

        this.getCommand("Pokespawn").setExecutor(new CMDPokespawn());

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin [Pixelmon] stopped");
    }

    public Plugin getPlugin() {
    return plugin;
    }
}

