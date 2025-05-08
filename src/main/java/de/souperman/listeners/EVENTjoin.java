package de.souperman.listeners;

import de.souperman.types.Trainer;
import de.souperman.vars.Vars;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EVENTjoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Vars.trainers.add(new Trainer(p));

        p.openInventory(Vars.starterPick);
    }
}
