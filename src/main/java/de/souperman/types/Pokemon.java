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
import java.util.Random;

public class Pokemon {

    private PokeType type;
    private String name;
    private Element primaryElement;
    private Element secondaryElement;
    private final int maxhp;
    private int hp;
    private double height;
    private int level;

    private boolean summoned;

    private ArmorStand armorStand;
    private ArmorStand hologram;
    private ArmorStand healthHologram;
    private Trainer owner;
    private Location loc;
    private ItemStack itemstack;
    private String prefix;


    public Pokemon(PokeType type, Trainer owner) {
        this.type = type;
        this.name = type.name;
        this.owner = owner;
        this.loc = owner.getPlayer().getLocation();
        this.summoned = false;
        this.height = type.height;
        this.maxhp = type.maxHP;
        Random rndm = new Random();
        this.level = rndm.nextInt(30) + 1;

        this.prefix = "§f";

        itemstack = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemMeta itemstackMeta = itemstack.getItemMeta();
        itemstackMeta.setCustomModelData(type.modelData);
        itemstackMeta.setDisplayName(prefix+name);
        itemstack.setItemMeta(itemstackMeta);
    }

    public Pokemon(PokeType type, Trainer owner, int level) {
        this.type = type;
        this.name = type.name;
        this.owner = owner;
        this.loc = owner.getPlayer().getLocation();
        this.summoned = false;
        this.height = type.height;
        this.maxhp = type.maxHP;
        this.level = level;

        this.prefix = "§f";

        itemstack = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemMeta itemstackMeta = itemstack.getItemMeta();
        itemstackMeta.setCustomModelData(type.modelData);
        itemstackMeta.setDisplayName(prefix+name);
        itemstack.setItemMeta(itemstackMeta);
    }


    public ItemStack getItemStack() {
        return itemstack;
    }

    public void summonAt(Location loc) {

        this.loc = loc;
        Location armorStandLoc = loc;
        Location hologramLoc = new Location(loc.getWorld(), loc.getX(), loc.getY()+height, loc.getZ());
        Location healthHologramLoc = new Location(hologramLoc.getWorld(), hologramLoc.getX(), hologramLoc.getY()-0.25, hologramLoc.getZ());

        armorStand = (ArmorStand) Objects.requireNonNull(loc.getWorld()).spawnEntity(armorStandLoc, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setSilent(true);
        armorStand.setBasePlate(false);
        armorStand.setCanPickupItems(false);
        armorStand.setArms(true);
        armorStand.setCollidable(false);
        armorStand.setCustomNameVisible(false);
        armorStand.setRightArmPose(new EulerAngle(0, 0, 0));
        armorStand.getEquipment().setItemInMainHand(itemstack);

        hologram = (ArmorStand) Objects.requireNonNull(loc.getWorld()).spawnEntity(hologramLoc, EntityType.ARMOR_STAND);
        hologram.setInvisible(true);
        hologram.setCustomName("§f"+name);
        hologram.setCustomNameVisible(true);
        hologram.setGravity(false);
        hologram.setMarker(true);

        healthHologram = (ArmorStand) Objects.requireNonNull(loc.getWorld()).spawnEntity(healthHologramLoc, EntityType.ARMOR_STAND);
        healthHologram.setInvisible(true);
        healthHologram.setCustomName("§a||||||||||||||||||||");
        healthHologram.setCustomNameVisible(true);
        healthHologram.setGravity(false);
        healthHologram.setMarker(true);

        Vars.summonedPokemon.add(this);
        this.summoned = true;
        Bukkit.broadcastMessage(Vars.summonedPokemon.size()+"");
    }

    public void deSummon() {
        if(armorStand != null) {
            armorStand.remove();
        }
        if(hologram != null) {
            hologram.remove();
        }
        if(healthHologram != null) {
            healthHologram.remove();
        }
        Vars.summonedPokemon.remove(this);
        this.summoned = false;
    }

    public ArmorStand getArmorStand() {
        if(armorStand != null) {
            return armorStand;
        }
        return null;
    }

    public Trainer getOwner() {
        if(owner != null) {
            return owner;
        }
        return null;
    }


    public PokeType getType() {
        return type;
    }

    public Location getLocation() {
        return loc;
    }

    public boolean isSummoned() {
        return summoned;
    }

    public void setOwner(Trainer trainer) {
        this.owner = trainer;
    }

    public void update() {

    }
}
