package de.souperman.listeners;

import de.souperman.types.Trainer;
import de.souperman.vars.Vars;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EVENTinteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (!EVENTinventory.isBlockedItem(e.getItem()) || (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)) { return; }
        Player p = e.getPlayer();
        Trainer t = Vars.getTrainer(p);
        if(t != null) {
            switch (p.getInventory().getHeldItemSlot()) {
                case 3:
                    if(t.getSlot1() == null) {break;}
                    if(t.getSlot1().isSummoned()) {
                        t.getSlot1().deSummon();
                    } else {
                        t.getSlot1().summonAt(p.getLocation());
                    }
                    break;
                case 4:
                    if(t.getSlot2() == null) {break;}
                    if(t.getSlot2().isSummoned()) {
                        t.getSlot2().deSummon();
                    } else {
                        t.getSlot2().summonAt(p.getLocation());
                    }
                    break;
                case 5:
                    if(t.getSlot3() == null) {break;}
                    if(t.getSlot3().isSummoned()) {
                        t.getSlot3().deSummon();
                    } else {
                        t.getSlot3().summonAt(p.getLocation());
                    }
                    break;
                case 6:
                    if(t.getSlot4() == null) {break;}
                    if(t.getSlot4().isSummoned()) {
                        t.getSlot4().deSummon();
                    } else {
                        t.getSlot4().summonAt(p.getLocation());
                    }
                    break;
                case 7:
                    if(t.getSlot5() == null) {break;}
                    if(t.getSlot5().isSummoned()) {
                        t.getSlot5().deSummon();
                    } else {
                        t.getSlot5().summonAt(p.getLocation());
                    }
                    break;
                case 8:
                    if(t.getSlot6() == null) {break;}
                    if(t.getSlot6().isSummoned()) {
                        t.getSlot6().deSummon();
                    } else {
                        t.getSlot6().summonAt(p.getLocation());
                    }
                    break;
                default:
                    break;
            }
        }
    }
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked() instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand) e.getRightClicked();
            if (!armorStand.isVisible()) {
                e.setCancelled(true);
            }
        }
    }
}
