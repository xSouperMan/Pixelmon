package de.souperman.commands;

import de.souperman.types.PokeType;
import de.souperman.types.Pokemon;
import de.souperman.vars.Vars;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

import java.util.Objects;

public class CMDPokespawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 1) {
            String arg = args[0];
            for(PokeType type : PokeType.values()) {
                if(arg.equalsIgnoreCase(type.toString())) {
                    p.sendMessage("creating pokemon with type: "+type);
                    Pokemon summon = new Pokemon(type, Objects.requireNonNull(Vars.getTrainer(p)));
                    summon.summonAt(p.getLocation());

                    return false;
                }
            }
            p.sendMessage("There aint no '"+arg+"'");
            return false;
        }
        return false;
    }
}
