package de.souperman.main;

import de.souperman.commands.CMDPokespawn;
import de.souperman.listeners.EVENTinteract;
import de.souperman.listeners.EVENTinventory;
import de.souperman.listeners.EVENTjoin;
import de.souperman.listeners.EVENTleave;
import de.souperman.vars.Vars;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class Main extends JavaPlugin {

    private static Plugin plugin;
    private static BukkitRunnable pokemonPhysicsRunnable;
    private static BukkitTask pokemonPhysicsTask;

    @Override
    public void onEnable() {
        getLogger().info("Plugin [Pixelmon] started");

        plugin = this;

        Vars.initVars();

        this.getCommand("Pokespawn").setExecutor(new CMDPokespawn());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EVENTjoin(), this);
        pm.registerEvents(new EVENTleave(), this);
        pm.registerEvents(new EVENTinventory(), this);
        pm.registerEvents(new EVENTinteract(), this);

        startPhysics();
    }

    public static void startPhysics() {
        if (pokemonPhysicsTask != null && !pokemonPhysicsTask.isCancelled()) {
            return;
        }

        pokemonPhysicsRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                Vars.updatePhysics();
            }
        };

        pokemonPhysicsTask = pokemonPhysicsRunnable.runTaskTimer(plugin, 0, 1);
    }

    public static void stopPhysics() {
        if (pokemonPhysicsTask != null && !pokemonPhysicsTask.isCancelled()) {
            pokemonPhysicsTask.cancel();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin [Pixelmon] stopped");
    }

    public static Plugin getPlugin() {
    return plugin;
    }
}

