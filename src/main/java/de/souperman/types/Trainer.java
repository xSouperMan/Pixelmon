package de.souperman.types;

import de.souperman.vars.Vars;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Trainer {

    private final Player player;
    private Pokemon slot1;
    private Pokemon slot2;
    private Pokemon slot3;
    private Pokemon slot4;
    private Pokemon slot5;
    private Pokemon slot6;
    private ArrayList<Pokemon> PC;

    public Trainer(Player p) {
        player = p;
        PC = new ArrayList<Pokemon>();
        updatePokemon();
    }

    private void updatePokemon() {
        if(slot1 != null) {
            player.getInventory().setItem(3, slot1.getItemStack());
        } else {
            player.getInventory().setItem(3, Vars.getNoPokemon());
        }
        if(slot2 != null) {
            player.getInventory().setItem(4, slot2.getItemStack());
        } else {
            player.getInventory().setItem(4, Vars.getNoPokemon());
        }
        if(slot3 != null) {
            player.getInventory().setItem(5, slot3.getItemStack());
        } else {
            player.getInventory().setItem(5, Vars.getNoPokemon());
        }
        if(slot4 != null) {
            player.getInventory().setItem(6, slot4.getItemStack());
        } else {
            player.getInventory().setItem(6, Vars.getNoPokemon());
        }
        if(slot5 != null) {
            player.getInventory().setItem(7, slot5.getItemStack());
        } else {
            player.getInventory().setItem(7, Vars.getNoPokemon());
        }
        if(slot6 != null) {
            player.getInventory().setItem(8, slot6.getItemStack());
        } else {
            player.getInventory().setItem(8, Vars.getNoPokemon());
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void addPokemon(Pokemon pokemon) {
        if(pokemon.getOwner() != this) {
            pokemon.setOwner(this);
        }

        if(slot1 == null) {
            slot1 = pokemon;
        } else if(slot2 == null) {
            slot2 = pokemon;
        } else if(slot3 == null) {
            slot3 = pokemon;
        } else if(slot4 == null) {
            slot4 = pokemon;
        } else if(slot5 == null) {
            slot5 = pokemon;
        } else if(slot6 == null) {
            slot6 = pokemon;
        } else {
            PC.add(pokemon);
        }
        updatePokemon();
    }

    public ArrayList<Pokemon> getPokemon() {
        ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
        pokemon.add(slot1);
        pokemon.add(slot2);
        pokemon.add(slot3);
        pokemon.add(slot4);
        pokemon.add(slot5);
        pokemon.add(slot6);
        return pokemon;
    }

    public Pokemon getSlot1() {
        return slot1;
    }
    public Pokemon getSlot2() {
        return slot2;
    }
    public Pokemon getSlot3() {
        return slot3;
    }
    public Pokemon getSlot4() {
        return slot4;
    }
    public Pokemon getSlot5() {
        return slot5;
    }
    public Pokemon getSlot6() {
        return slot6;
    }
}
