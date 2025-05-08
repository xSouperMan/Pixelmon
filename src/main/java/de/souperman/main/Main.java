package de.souperman.main;

import de.souperman.commands.CMDPokespawn;
import de.souperman.vars.Vars;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    private static Plugin plugin;
    private static BukkitRunnable pokemonPhysics;

    @Override
    public void onEnable() {
        getLogger().info("Plugin [Pixelmon] started");

        plugin = this;

        Vars.initVars();

        this.getCommand("Pokespawn").setExecutor(new CMDPokespawn());

        pokemonPhysics = new BukkitRunnable() {
            @Override
            public void run() {

                Vars.updatePos();

            }
        };
        pokemonPhysics.runTaskTimer(plugin, 0, 1);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin [Pixelmon] stopped");
    }

    public static Plugin getPlugin() {
    return plugin;
    }
}

