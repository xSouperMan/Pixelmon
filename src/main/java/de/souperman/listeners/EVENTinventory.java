package de.souperman.listeners;

import de.souperman.main.Main;
import de.souperman.types.PokeType;
import de.souperman.types.Pokemon;
import de.souperman.types.Trainer;
import de.souperman.vars.Vars;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class EVENTinventory implements Listener {

    static boolean isBlockedItem(ItemStack item) {
        return item != null
                && item.getType() == Material.OMINOUS_TRIAL_KEY
                && item.hasItemMeta()
                && Objects.requireNonNull(item.getItemMeta()).hasCustomModelData()
                ;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) {
            return;
        }
        if (isBlockedItem(e.getCurrentItem()) || isBlockedItem(e.getCursor())) {

            if(e.getInventory() == Vars.starterPick) {
                Player p = (Player) e.getWhoClicked();
                String name = e.getCurrentItem().getItemMeta().getDisplayName();
                if(name.equalsIgnoreCase(PokeType.BULBASAUR.name)
                    ||name.equalsIgnoreCase(PokeType.CHARMANDER.name)
                    ||name.equalsIgnoreCase(PokeType.SQUIRTLE.name)
                    ||name.equalsIgnoreCase(PokeType.CHIKORITA.name)
                    ||name.equalsIgnoreCase(PokeType.CYNDAQUILL.name)
                    ||name.equalsIgnoreCase(PokeType.TOTODILE.name)
                    ||name.equalsIgnoreCase(PokeType.TREECKO.name)
                    ||name.equalsIgnoreCase(PokeType.TORCHIC.name)
                    ||name.equalsIgnoreCase(PokeType.MUDKIP.name)
                    ||name.equalsIgnoreCase(PokeType.TURTWIG.name)
                    ||name.equalsIgnoreCase(PokeType.CHIMCHAR.name)
                    ||name.equalsIgnoreCase(PokeType.PIPLUP.name)
                    ||name.equalsIgnoreCase(PokeType.SNIVY.name)
                    ||name.equalsIgnoreCase(PokeType.TEPIG.name)
                    ||name.equalsIgnoreCase(PokeType.OSHAWOTT.name)
                    ||name.equalsIgnoreCase(PokeType.CHESPIN.name)
                    ||name.equalsIgnoreCase(PokeType.FENNEKIN.name)
                    ||name.equalsIgnoreCase(PokeType.FROAKIE.name)
                    ||name.equalsIgnoreCase(PokeType.ROWLET.name)
                    ||name.equalsIgnoreCase(PokeType.LITTEN.name)
                    ||name.equalsIgnoreCase(PokeType.POPPLIO.name)
                    ||name.equalsIgnoreCase(PokeType.GROOKEY.name)
                    ||name.equalsIgnoreCase(PokeType.SCORBUNNY.name)
                    ||name.equalsIgnoreCase(PokeType.SOBBLE.name)
                    ||name.equalsIgnoreCase(PokeType.SPRIGATITO.name)
                    ||name.equalsIgnoreCase(PokeType.FUECOCO.name)
                    ||name.equalsIgnoreCase(PokeType.QUAXLY.name)) {
                    Vars.openConfirmStarter(e.getCurrentItem(), p);
                }
            }
            e.setCancelled(true);
        }

        if(e.getView().getTitle().equalsIgnoreCase("§cConfirm Your Starter")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.RED_STAINED_GLASS_PANE) {
                e.getWhoClicked().openInventory(Vars.starterPick);
            } else if(e.getCurrentItem().getType() == Material.GREEN_STAINED_GLASS_PANE) {
                Trainer trainer = Vars.getTrainer((Player) e.getWhoClicked());
                if(trainer != null) {
                    String name = e.getInventory().getItem(13).getItemMeta().getDisplayName();
                    PokeType type = Vars.getPokeType(name);

                    if(type == null) {
                        e.setCancelled(true);
                        return;
                    }

                    Pokemon pokemon = new Pokemon(type, trainer);

                    trainer.addPokemon(pokemon);
                }
                e.getWhoClicked().closeInventory();
            }
        }

        if(e.getInventory() == Vars.starterPick) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (e.getInventory() == Vars.starterPick) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(!(e.getPlayer().getOpenInventory() != null && e.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("§cConfirm Your Starter"))) {
                        e.getPlayer().openInventory(Vars.starterPick);
                    }
                }
            }.runTaskLater(Main.getPlugin(), 1L);
        }

        if (e.getView().getTitle().equalsIgnoreCase("§cConfirm Your Starter") && Vars.getTrainer((Player) e.getPlayer()) != null && Vars.getTrainer((Player) e.getPlayer()).getSlot1() == null ) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    e.getPlayer().sendMessage(e.getPlayer().getOpenInventory().getTitle()+ " = "+e.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("§cPick Your Starter Pokémon!"));
                    if(!(e.getPlayer().getOpenInventory() != null && e.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("§cPick Your Starter Pokémon!"))) {
                        e.getPlayer().openInventory(e.getInventory());
                        e.getPlayer().sendMessage(!(e.getPlayer().getOpenInventory() != null && e.getPlayer().getOpenInventory().getTitle().equalsIgnoreCase("§cPick Your Starter Pokémon!") && Vars.getTrainer((Player) e.getPlayer()) != null && Vars.getTrainer((Player) e.getPlayer()).getSlot1() != null )+"");
                    }
                }
            }.runTaskLater(Main.getPlugin(), 1L);
        }
    }


    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        if (isBlockedItem(e.getOldCursor())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (isBlockedItem(e.getItemDrop().getItemStack())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSwap(PlayerSwapHandItemsEvent e) {
        if (isBlockedItem(e.getMainHandItem()) || isBlockedItem(e.getOffHandItem())) {
            e.setCancelled(true);
        }
    }
}
