package de.souperman.listeners;

import de.souperman.types.Pokemon;
import de.souperman.vars.Vars;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class EVENTleave implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        for(Pokemon pokemon : Vars.getTrainer(p).getPokemon()) {
            if(pokemon == null || !pokemon.isSummoned()) {return;}
            pokemon.deSummon();
        }

        Vars.trainers.remove(Vars.getTrainer(p));

    }
}
