package de.souperman.types;

import de.souperman.main.Main;
import de.souperman.vars.Vars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

import java.util.Objects;

public class Pokemon {

    private static PokeType type;
    private Element primaryElement;
    private Element secondaryElement;
    private int hp;

    private ArmorStand armorStand;
    private Player owner;
    private Location loc;
    ItemStack texture;


    public Pokemon(PokeType type, Player owner) {
        this.type = type;
        this.owner = owner;
        this.loc = owner.getLocation();

        texture = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemMeta textureMeta = texture.getItemMeta();

        textureMeta.setCustomModelData(Vars.getModelData(type));
        texture.setItemMeta(textureMeta);
    }

    public void summonAt(Location loc) {

        this.loc = loc;

        armorStand = (ArmorStand) Objects.requireNonNull(loc.getWorld()).spawnEntity(loc, EntityType.ARMOR_STAND);
        owner.sendMessage("summoned");
        armorStand.setInvisible(true);
        armorStand.setMarker(false);
        armorStand.setSmall(false);
        armorStand.setGravity(false);
        armorStand.setArms(true);
        armorStand.setBasePlate(false);
        EulerAngle rightArmPose = new EulerAngle(Math.toRadians(-90), Math.toRadians(0), Math.toRadians(0));
        armorStand.setRightArmPose(rightArmPose);

        armorStand.setItemInHand(texture);

        Vars.summonedPokemon.add(this);
        Bukkit.broadcastMessage(Vars.summonedPokemon.size()+"");
    }

    public void deSummon() {
        if(armorStand == null) {
            return;
        }
        armorStand.remove();
    }

    public ArmorStand getArmorStand() {
        if(armorStand != null) {
            return armorStand;
        }
        return null;
    }

    public Player getOwner() {
        if(owner != null) {
            return owner;
        }
        return null;
    }


    public static PokeType getType() {
        return type;
    }
}
