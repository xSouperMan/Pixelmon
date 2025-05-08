package de.souperman.vars;

import de.souperman.types.PokeType;
import de.souperman.types.Pokemon;
import de.souperman.types.Trainer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Vars {

    public static ArrayList<Pokemon> summonedPokemon;
    public static ArrayList<Trainer> trainers;

    public static Inventory starterPick;








    public static void updatePhysics() {
        for (Pokemon pokemon : summonedPokemon) {
            if(pokemon.getOwner() != null) {
                if(pokemon.getOwner().getPlayer().getLocation().distance(pokemon.getLocation()) > 20) {
                    pokemon.deSummon();
                }
            }
            pokemon.getArmorStand().setRotation(pokemon.getArmorStand().getLocation().getYaw() + 1, pokemon.getArmorStand().getLocation().getPitch());
            pokemon.update();
        }
    }

    public static Trainer getTrainer(Player p) {
        for(Trainer trainer : trainers) {
            if(trainer.getPlayer() == p) {
                return trainer;
            }
        }
        return null;
    }

    public static void openConfirmStarter(ItemStack pokemon, Player p) {
        Inventory confirmStarter = Bukkit.createInventory(p, 54, "§cConfirm Your Starter");

        ItemStack background = new ItemStack(Material.GLASS_PANE);
        ItemMeta backgroundMeta = background.getItemMeta();
        backgroundMeta.setDisplayName("");
        backgroundMeta.setHideTooltip(true);
        background.setItemMeta(backgroundMeta);

        ItemStack confirm = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta confirmMeta = confirm.getItemMeta();
        confirmMeta.setDisplayName("§aConfirm");
        confirmMeta.setLore(Arrays.asList("§fYou will start with", "§7"+ Objects.requireNonNull(pokemon.getItemMeta()).getDisplayName()+" §fas your first Pokémon."));
        confirm.setItemMeta(confirmMeta);

        ItemStack decline = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta declineMeta = decline.getItemMeta();
        declineMeta.setDisplayName("§cDecline");
        declineMeta.setLore(Arrays.asList("§fYou will return to", "§fthe starter selection."));
        decline.setItemMeta(declineMeta);


        for(int i = 0; i < confirmStarter.getSize(); i++) {
            switch (i) {
                case 13:
                    confirmStarter.setItem(13, pokemon);
                    break;
                case 28:
                case 29:
                case 30:
                case 37:
                case 38:
                case 39:
                case 46:
                case 47:
                case 48:
                    confirmStarter.setItem(i, confirm);
                    break;
                case 32:
                case 33:
                case 34:
                case 41:
                case 42:
                case 43:
                case 50:
                case 51:
                case 52:
                    confirmStarter.setItem(i, decline);
                    break;
                default:
                    confirmStarter.setItem(i, background);
                    break;
            }
        }



        p.openInventory(confirmStarter);
    }


    public ItemStack getPokeballs(int amount, int type) {
        int returnAmount = 0;
        if(amount > 0) {
            if(amount > 64) {
                returnAmount = 64;
            } else {
                returnAmount = amount;
            }
        }
        ItemStack pokeball = new ItemStack(Material.MAGMA_CREAM);
        ItemMeta pokeballMeta = pokeball.getItemMeta();
        int modelData = 1;
        if(type > 0 && type < 39) {
            modelData = type;
        }
        pokeballMeta.setCustomModelData(type);
        pokeball.setItemMeta(pokeballMeta);
        return pokeball;
    }

    public static PokeType getPokeType(String str) {
        for(PokeType type : PokeType.values()) {
            if(str.equalsIgnoreCase(type.toString())) {
                return type;
            }
        }
        return null;
    }

    public static ItemStack getNoPokemon() {
        ItemStack item = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setCustomModelData(404);
        itemMeta.setDisplayName("§7Empty Slot");
        itemMeta.setHideTooltip(true);
        itemMeta.setMaxStackSize(1);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static void initVars() {
        summonedPokemon = new ArrayList<Pokemon>();
        trainers = new ArrayList<Trainer>();


        starterPick = Bukkit.createInventory(null, 54, "§cPick Your Starter Pokémon!");

        ItemStack bulbasaur = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack charmander = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack squirtle = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack chikorita = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack cyndaquill = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack totodile = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack treecko = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack torchic = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack mudkip = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack turtwig = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack chimchar = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack piplup = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack snivy = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack tepig = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack oshawott = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack chespin = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack fennekin = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack froakie = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack rowlet = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack litten = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack popplio = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack grookey = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack scorbunny = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack sobble = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack sprigatito = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack fuecoco = new ItemStack(Material.OMINOUS_TRIAL_KEY);
        ItemStack quaxly = new ItemStack(Material.OMINOUS_TRIAL_KEY);

        ItemMeta bulbasaurMeta = bulbasaur.getItemMeta();
        ItemMeta charmanderMeta = charmander.getItemMeta();
        ItemMeta squirtleMeta = squirtle.getItemMeta();
        ItemMeta chikoritaMeta = chikorita.getItemMeta();
        ItemMeta cyndaquillMeta = cyndaquill.getItemMeta();
        ItemMeta totodileMeta = totodile.getItemMeta();
        ItemMeta treeckoMeta = treecko.getItemMeta();
        ItemMeta torchicMeta = torchic.getItemMeta();
        ItemMeta mudkipMeta = mudkip.getItemMeta();
        ItemMeta turtwigMeta = turtwig.getItemMeta();
        ItemMeta chimcharMeta = chimchar.getItemMeta();
        ItemMeta piplupMeta = piplup.getItemMeta();
        ItemMeta snivyMeta = snivy.getItemMeta();
        ItemMeta tepigMeta = tepig.getItemMeta();
        ItemMeta oshawottMeta = oshawott.getItemMeta();
        ItemMeta chespinMeta = chespin.getItemMeta();
        ItemMeta fennekinMeta = fennekin.getItemMeta();
        ItemMeta froakieMeta = froakie.getItemMeta();
        ItemMeta rowletMeta = rowlet.getItemMeta();
        ItemMeta littenMeta = litten.getItemMeta();
        ItemMeta popplioMeta = popplio.getItemMeta();
        ItemMeta grookeyMeta = grookey.getItemMeta();
        ItemMeta scorbunnyMeta = scorbunny.getItemMeta();
        ItemMeta sobbleMeta = sobble.getItemMeta();
        ItemMeta sprigatitoMeta = sprigatito.getItemMeta();
        ItemMeta fuecocoMeta = fuecoco.getItemMeta();
        ItemMeta quaxlyMeta = quaxly.getItemMeta();

        bulbasaurMeta.setCustomModelData(PokeType.BULBASAUR.modelData);
        charmanderMeta.setCustomModelData(PokeType.CHARMANDER.modelData);
        squirtleMeta.setCustomModelData(PokeType.SQUIRTLE.modelData);
        chikoritaMeta.setCustomModelData(PokeType.CHIKORITA.modelData);
        cyndaquillMeta.setCustomModelData(PokeType.CYNDAQUILL.modelData);
        totodileMeta.setCustomModelData(PokeType.TOTODILE.modelData);
        treeckoMeta.setCustomModelData(PokeType.TREECKO.modelData);
        torchicMeta.setCustomModelData(PokeType.TORCHIC.modelData);
        mudkipMeta.setCustomModelData(PokeType.MUDKIP.modelData);
        turtwigMeta.setCustomModelData(PokeType.TURTWIG.modelData);
        chimcharMeta.setCustomModelData(PokeType.CHIMCHAR.modelData);
        piplupMeta.setCustomModelData(PokeType.PIPLUP.modelData);
        snivyMeta.setCustomModelData(PokeType.SNIVY.modelData);
        tepigMeta.setCustomModelData(PokeType.TEPIG.modelData);
        oshawottMeta.setCustomModelData(PokeType.OSHAWOTT.modelData);
        chespinMeta.setCustomModelData(PokeType.CHESPIN.modelData);
        fennekinMeta.setCustomModelData(PokeType.FENNEKIN.modelData);
        froakieMeta.setCustomModelData(PokeType.FROAKIE.modelData);
        rowletMeta.setCustomModelData(PokeType.ROWLET.modelData);
        littenMeta.setCustomModelData(PokeType.LITTEN.modelData);
        popplioMeta.setCustomModelData(PokeType.POPPLIO.modelData);
        grookeyMeta.setCustomModelData(PokeType.GROOKEY.modelData);
        scorbunnyMeta.setCustomModelData(PokeType.SCORBUNNY.modelData);
        sobbleMeta.setCustomModelData(PokeType.SOBBLE.modelData);
        sprigatitoMeta.setCustomModelData(PokeType.SPRIGATITO.modelData);
        fuecocoMeta.setCustomModelData(PokeType.FUECOCO.modelData);
        quaxlyMeta.setCustomModelData(PokeType.QUAXLY.modelData);

        bulbasaurMeta.setDisplayName(PokeType.BULBASAUR.name);
        charmanderMeta.setDisplayName(PokeType.CHARMANDER.name);
        squirtleMeta.setDisplayName(PokeType.SQUIRTLE.name);
        chikoritaMeta.setDisplayName(PokeType.CHIKORITA.name);
        cyndaquillMeta.setDisplayName(PokeType.CYNDAQUILL.name);
        totodileMeta.setDisplayName(PokeType.TOTODILE.name);
        treeckoMeta.setDisplayName(PokeType.TREECKO.name);
        torchicMeta.setDisplayName(PokeType.TORCHIC.name);
        mudkipMeta.setDisplayName(PokeType.MUDKIP.name);
        turtwigMeta.setDisplayName(PokeType.TURTWIG.name);
        chimcharMeta.setDisplayName(PokeType.CHIMCHAR.name);
        piplupMeta.setDisplayName(PokeType.PIPLUP.name);
        snivyMeta.setDisplayName(PokeType.SNIVY.name);
        tepigMeta.setDisplayName(PokeType.TEPIG.name);
        oshawottMeta.setDisplayName(PokeType.OSHAWOTT.name);
        chespinMeta.setDisplayName(PokeType.CHESPIN.name);
        fennekinMeta.setDisplayName(PokeType.FENNEKIN.name);
        froakieMeta.setDisplayName(PokeType.FROAKIE.name);
        rowletMeta.setDisplayName(PokeType.ROWLET.name);
        littenMeta.setDisplayName(PokeType.LITTEN.name);
        popplioMeta.setDisplayName(PokeType.POPPLIO.name);
        grookeyMeta.setDisplayName(PokeType.GROOKEY.name);
        scorbunnyMeta.setDisplayName(PokeType.SCORBUNNY.name);
        sobbleMeta.setDisplayName(PokeType.SOBBLE.name);
        sprigatitoMeta.setDisplayName(PokeType.SPRIGATITO.name);
        fuecocoMeta.setDisplayName(PokeType.FUECOCO.name);
        quaxlyMeta.setDisplayName(PokeType.QUAXLY.name);


        bulbasaurMeta.setLore(Arrays.asList("§fA calm companion with a heart", "§frooted in nature.", "§fType: §2Grass§f/§5Poison"));
        charmanderMeta.setLore(Arrays.asList("§fA fiery spirit with a flame", "§fthat never fades.", "§fType: §6Fire"));
        squirtleMeta.setLore(Arrays.asList("§fA cool, collected fighter, always", "§fready to splash into action.", "§fType: §9Water"));
        chikoritaMeta.setLore(Arrays.asList("§fGraceful as the breeze, with", "§fleaves that heal and protect.", "§fType: §2Grass"));
        cyndaquillMeta.setLore(Arrays.asList("§fSmall, shy, but with a fiery", "§fsoul ready to erupt.", "§fType: §6Fire"));
        totodileMeta.setLore(Arrays.asList("§fA wild-hearted water Pokémon,", "§fready to snap at any challenge.", "§fType: §9Water"));
        treeckoMeta.setLore(Arrays.asList("§fA nimble climber, sharp-eyed and", "§ffocused on the climb ahead.", "§fType: §2Grass"));
        torchicMeta.setLore(Arrays.asList("§fA fiery little bird with a big", "§fheart and even bigger flames.", "§fType: §6Fire"));
        mudkipMeta.setLore(Arrays.asList("§fA true adventurer, whether in water", "§for mud – fearless and loyal.", "§fType: §9Water"));
        turtwigMeta.setLore(Arrays.asList("§fA sturdy companion who grows", "§fstronger with every step.", "§fType: §2Grass"));
        chimcharMeta.setLore(Arrays.asList("§fA playful fireball, quick to", "§fact and faster to learn.", "§fType: §6Fire"));
        piplupMeta.setLore(Arrays.asList("§fProud, regal, and always swimming", "§ftoward greatness.", "§fType: §9Water"));
        snivyMeta.setLore(Arrays.asList("§fElegant, cool, and always a step", "§fahead of the rest.", "§fType: §2Grass"));
        tepigMeta.setLore(Arrays.asList("§fA fiery, determined fighter with the", "§fspirit of a champion.", "§fType: §6Fire"));
        oshawottMeta.setLore(Arrays.asList("§fSharp as a blade, with the will", "§fto win and the heart to match.", "§fType: §9Water"));
        chespinMeta.setLore(Arrays.asList("§fTough on the outside, but with a", "§fbig heart and a playful spirit.", "§fType: §2Grass"));
        fennekinMeta.setLore(Arrays.asList("§fA fiery fox with a clever mind", "§fand magical potential.", "§fType: §6Fire"));
        froakieMeta.setLore(Arrays.asList("§fA quiet ninja, blending into the", "§fshadows with precision.", "§fType: §9Water"));
        rowletMeta.setLore(Arrays.asList("§fSilent, wise, and always striking", "§fwith perfect aim.", "§fType: §2Grass§f/§7Flying"));
        littenMeta.setLore(Arrays.asList("§fA proud and independent soul, ready", "§fto light up the world.", "§fType: §6Fire"));
        popplioMeta.setLore(Arrays.asList("§fPlayful, bold, and always center", "§fstage – a true star in the making.", "§fType: §9Water"));
        grookeyMeta.setLore(Arrays.asList("§fA mischievous drummer, always", "§fbringing the rhythm to the battle.", "§fType: §2Grass"));
        scorbunnyMeta.setLore(Arrays.asList("§fQuick as lightning, with an", "§funstoppable fire burning within.", "§fType: §6Fire"));
        sobbleMeta.setLore(Arrays.asList("§fShy and sensitive, but when ready,", "§fnothing stands in its way.", "§fType: §9Water"));
        sprigatitoMeta.setLore(Arrays.asList("§fA graceful fighter with a touch", "§fof wild elegance.", "§fType: §2Grass"));
        fuecocoMeta.setLore(Arrays.asList("§fLazy and laid-back, but when it", "§ngets going – nothing can stop it.", "§fType: §6Fire"));
        quaxlyMeta.setLore(Arrays.asList("§fRefined, disciplined, and always", "§fin control of the battle.", "§fType: §9Water"));


        bulbasaur.setItemMeta(bulbasaurMeta);
        charmander.setItemMeta(charmanderMeta);
        squirtle.setItemMeta(squirtleMeta);
        chikorita.setItemMeta(chikoritaMeta);
        cyndaquill.setItemMeta(cyndaquillMeta);
        totodile.setItemMeta(totodileMeta);
        treecko.setItemMeta(treeckoMeta);
        torchic.setItemMeta(torchicMeta);
        mudkip.setItemMeta(mudkipMeta);
        turtwig.setItemMeta(turtwigMeta);
        chimchar.setItemMeta(chimcharMeta);
        piplup.setItemMeta(piplupMeta);
        snivy.setItemMeta(snivyMeta);
        tepig.setItemMeta(tepigMeta);
        oshawott.setItemMeta(oshawottMeta);
        chespin.setItemMeta(chespinMeta);
        fennekin.setItemMeta(fennekinMeta);
        froakie.setItemMeta(froakieMeta);
        rowlet.setItemMeta(rowletMeta);
        litten.setItemMeta(littenMeta);
        popplio.setItemMeta(popplioMeta);
        grookey.setItemMeta(grookeyMeta);
        scorbunny.setItemMeta(scorbunnyMeta);
        sobble.setItemMeta(sobbleMeta);
        sprigatito.setItemMeta(sprigatitoMeta);
        fuecoco.setItemMeta(fuecocoMeta);
        quaxly.setItemMeta(quaxlyMeta);


        starterPick.setItem(9, bulbasaur);
        starterPick.setItem(10, charmander);
        starterPick.setItem(11, squirtle);
        starterPick.setItem(12, chikorita);
        starterPick.setItem(13, cyndaquill);
        starterPick.setItem(14, totodile);
        starterPick.setItem(15, treecko);
        starterPick.setItem(16, torchic);
        starterPick.setItem(17, mudkip);
        starterPick.setItem(27, turtwig);
        starterPick.setItem(28, chimchar);
        starterPick.setItem(29, piplup);
        starterPick.setItem(30, snivy);
        starterPick.setItem(31, tepig);
        starterPick.setItem(32, oshawott);
        starterPick.setItem(33, chespin);
        starterPick.setItem(34, fennekin);
        starterPick.setItem(35, froakie);
        starterPick.setItem(45, rowlet);
        starterPick.setItem(46, litten);
        starterPick.setItem(47, popplio);
        starterPick.setItem(48, grookey);
        starterPick.setItem(49, scorbunny);
        starterPick.setItem(50, sobble);
        starterPick.setItem(51, sprigatito);
        starterPick.setItem(52, fuecoco);
        starterPick.setItem(53, quaxly);

    }
}