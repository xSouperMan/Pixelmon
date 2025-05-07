package de.souperman.commands;

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

public class CMDPokespawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 1) {
            int parse = 0;
            try {
                parse = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid Pokedex number");
                return false;
            }
            if(parse < 0 || parse > 1000) {
                sender.sendMessage("Invalid Pokedex number");
                return false;
            }

            ArmorStand armorStand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);

            // Grundkonfiguration
            armorStand.setInvisible(true);
            armorStand.setMarker(false);
            armorStand.setSmall(false);
            armorStand.setGravity(false);
            armorStand.setArms(true);
            armorStand.setBasePlate(false);

            ItemStack ominousKey = new ItemStack(Material.OMINOUS_TRIAL_KEY);
            ItemMeta ominousKeyMeta = ominousKey.getItemMeta();
            switch (parse) {
                case 1:
                    ominousKeyMeta.setCustomModelData(10001);
                    break;
                case 2:
                    ominousKeyMeta.setCustomModelData(10002);
                    break;
                case 3:
                    ominousKeyMeta.setCustomModelData(10003);
                    break;
                case 4:
                    ominousKeyMeta.setCustomModelData(10004);
                    break;
                case 5:
                    ominousKeyMeta.setCustomModelData(10005);
                    break;
                case 6:
                    ominousKeyMeta.setCustomModelData(10006);
                    break;
                case 7:
                    ominousKeyMeta.setCustomModelData(10007);
                    break;
                case 8:
                    ominousKeyMeta.setCustomModelData(10008);
                    break;
                case 9:
                    ominousKeyMeta.setCustomModelData(10009);
                    break;
                case 10:
                    ominousKeyMeta.setCustomModelData(10010);
                    break;
                case 11:
                    ominousKeyMeta.setCustomModelData(10011);
                    break;
                case 12:
                    ominousKeyMeta.setCustomModelData(10012);
                    break;
                case 13:
                    ominousKeyMeta.setCustomModelData(10013);
                    break;
                case 14:
                    ominousKeyMeta.setCustomModelData(10014);
                    break;
                case 15:
                    ominousKeyMeta.setCustomModelData(10015);
                    break;
                case 16:
                    ominousKeyMeta.setCustomModelData(10016);
                    break;
                case 17:
                    ominousKeyMeta.setCustomModelData(10017);
                    break;
                case 18:
                    ominousKeyMeta.setCustomModelData(10018);
                    break;
                case 19:
                    ominousKeyMeta.setCustomModelData(10019);
                    break;
                case 20:
                    ominousKeyMeta.setCustomModelData(10020);
                    break;
                case 21:
                    ominousKeyMeta.setCustomModelData(10021);
                    break;
                case 22:
                    ominousKeyMeta.setCustomModelData(10022);
                    break;
                case 23:
                    ominousKeyMeta.setCustomModelData(10023);
                    break;
                case 24:
                    ominousKeyMeta.setCustomModelData(10024);
                    break;
                case 25:
                    ominousKeyMeta.setCustomModelData(10025);
                    break;
                case 26:
                    ominousKeyMeta.setCustomModelData(10026);
                    break;
                case 27:
                    ominousKeyMeta.setCustomModelData(10027);
                    break;
                case 28:
                    ominousKeyMeta.setCustomModelData(10028);
                    break;
                case 29:
                    ominousKeyMeta.setCustomModelData(10029);
                    break;
                case 30:
                    ominousKeyMeta.setCustomModelData(10030);
                    break;
                case 31:
                    ominousKeyMeta.setCustomModelData(10031);
                    break;
                case 32:
                    ominousKeyMeta.setCustomModelData(10032);
                    break;
                case 33:
                    ominousKeyMeta.setCustomModelData(10033);
                    break;
                case 34:
                    ominousKeyMeta.setCustomModelData(10034);
                    break;
                case 35:
                    ominousKeyMeta.setCustomModelData(10035);
                    break;
                case 36:
                    ominousKeyMeta.setCustomModelData(10036);
                    break;
                case 37:
                    ominousKeyMeta.setCustomModelData(10037);
                    break;
                case 38:
                    ominousKeyMeta.setCustomModelData(10038);
                    break;
                case 39:
                    ominousKeyMeta.setCustomModelData(10039);
                    break;
                case 40:
                    ominousKeyMeta.setCustomModelData(10040);
                    break;
                case 41:
                    ominousKeyMeta.setCustomModelData(10041);
                    break;
                case 42:
                    ominousKeyMeta.setCustomModelData(10042);
                    break;
                case 43:
                    ominousKeyMeta.setCustomModelData(10043);
                    break;
                case 44:
                    ominousKeyMeta.setCustomModelData(10044);
                    break;
                case 45:
                    ominousKeyMeta.setCustomModelData(10045);
                    break;
                case 46:
                    ominousKeyMeta.setCustomModelData(10046);
                    break;
                case 47:
                    ominousKeyMeta.setCustomModelData(10047);
                    break;
                case 48:
                    ominousKeyMeta.setCustomModelData(10048);
                    break;
                case 49:
                    ominousKeyMeta.setCustomModelData(10049);
                    break;
                case 50:
                    ominousKeyMeta.setCustomModelData(10050);
                    break;
                case 51:
                    ominousKeyMeta.setCustomModelData(10051);
                    break;
                case 52:
                    ominousKeyMeta.setCustomModelData(10052);
                    break;
                case 53:
                    ominousKeyMeta.setCustomModelData(10053);
                    break;
                case 54:
                    ominousKeyMeta.setCustomModelData(10054);
                    break;
                case 55:
                    ominousKeyMeta.setCustomModelData(10055);
                    break;
                case 56:
                    ominousKeyMeta.setCustomModelData(10056);
                    break;
                case 57:
                    ominousKeyMeta.setCustomModelData(10057);
                    break;
                case 58:
                    ominousKeyMeta.setCustomModelData(10058);
                    break;
                case 59:
                    ominousKeyMeta.setCustomModelData(10059);
                    break;
                case 60:
                    ominousKeyMeta.setCustomModelData(10060);
                    break;
                case 61:
                    ominousKeyMeta.setCustomModelData(10061);
                    break;
                case 62:
                    ominousKeyMeta.setCustomModelData(10062);
                    break;
                case 63:
                    ominousKeyMeta.setCustomModelData(10063);
                    break;
                case 64:
                    ominousKeyMeta.setCustomModelData(10064);
                    break;
                case 65:
                    ominousKeyMeta.setCustomModelData(10065);
                    break;
                case 66:
                    ominousKeyMeta.setCustomModelData(10066);
                    break;
                case 67:
                    ominousKeyMeta.setCustomModelData(10067);
                    break;
                case 68:
                    ominousKeyMeta.setCustomModelData(10068);
                    break;
                case 69:
                    ominousKeyMeta.setCustomModelData(10069);
                    break;
                case 70:
                    ominousKeyMeta.setCustomModelData(10070);
                    break;
                case 71:
                    ominousKeyMeta.setCustomModelData(10071);
                    break;
                case 72:
                    ominousKeyMeta.setCustomModelData(10072);
                    break;
                case 73:
                    ominousKeyMeta.setCustomModelData(10073);
                    break;
                case 74:
                    ominousKeyMeta.setCustomModelData(10074);
                    break;
                case 75:
                    ominousKeyMeta.setCustomModelData(10075);
                    break;
                case 76:
                    ominousKeyMeta.setCustomModelData(10076);
                    break;
                case 77:
                    ominousKeyMeta.setCustomModelData(10077);
                    break;
                case 78:
                    ominousKeyMeta.setCustomModelData(10078);
                    break;
                case 79:
                    ominousKeyMeta.setCustomModelData(10079);
                    break;
                case 80:
                    ominousKeyMeta.setCustomModelData(10080);
                    break;
                case 81:
                    ominousKeyMeta.setCustomModelData(10081);
                    break;
                case 82:
                    ominousKeyMeta.setCustomModelData(10082);
                    break;
                case 83:
                    ominousKeyMeta.setCustomModelData(10083);
                    break;
                case 84:
                    ominousKeyMeta.setCustomModelData(10084);
                    break;
                case 85:
                    ominousKeyMeta.setCustomModelData(10085);
                    break;
                case 86:
                    ominousKeyMeta.setCustomModelData(10086);
                    break;
                case 87:
                    ominousKeyMeta.setCustomModelData(10087);
                    break;
                case 88:
                    ominousKeyMeta.setCustomModelData(10088);
                    break;
                case 89:
                    ominousKeyMeta.setCustomModelData(10089);
                    break;
                case 90:
                    ominousKeyMeta.setCustomModelData(10090);
                    break;
                case 91:
                    ominousKeyMeta.setCustomModelData(10091);
                    break;
                case 92:
                    ominousKeyMeta.setCustomModelData(10092);
                    break;
                case 93:
                    ominousKeyMeta.setCustomModelData(10093);
                    break;
                case 94:
                    ominousKeyMeta.setCustomModelData(10094);
                    break;
                case 95:
                    ominousKeyMeta.setCustomModelData(10095);
                    break;
                case 96:
                    ominousKeyMeta.setCustomModelData(10096);
                    break;
                case 97:
                    ominousKeyMeta.setCustomModelData(10097);
                    break;
                case 98:
                    ominousKeyMeta.setCustomModelData(10098);
                    break;
                case 99:
                    ominousKeyMeta.setCustomModelData(10099);
                    break;
                case 100:
                    ominousKeyMeta.setCustomModelData(10100);
                    break;
                case 101:
                    ominousKeyMeta.setCustomModelData(10101);
                    break;
                case 102:
                    ominousKeyMeta.setCustomModelData(10102);
                    break;
                case 103:
                    ominousKeyMeta.setCustomModelData(10103);
                    break;
                case 104:
                    ominousKeyMeta.setCustomModelData(10104);
                    break;
                case 105:
                    ominousKeyMeta.setCustomModelData(10105);
                    break;
                case 106:
                    ominousKeyMeta.setCustomModelData(10106);
                    break;
                case 107:
                    ominousKeyMeta.setCustomModelData(10107);
                    break;
                case 108:
                    ominousKeyMeta.setCustomModelData(10108);
                    break;
                case 109:
                    ominousKeyMeta.setCustomModelData(10109);
                    break;
                case 110:
                    ominousKeyMeta.setCustomModelData(10110);
                    break;
                case 111:
                    ominousKeyMeta.setCustomModelData(10111);
                    break;
                case 112:
                    ominousKeyMeta.setCustomModelData(10112);
                    break;
                case 113:
                    ominousKeyMeta.setCustomModelData(10113);
                    break;
                case 114:
                    ominousKeyMeta.setCustomModelData(10114);
                    break;
                case 115:
                    ominousKeyMeta.setCustomModelData(10115);
                    break;
                case 116:
                    ominousKeyMeta.setCustomModelData(10116);
                    break;
                case 117:
                    ominousKeyMeta.setCustomModelData(10117);
                    break;
                case 118:
                    ominousKeyMeta.setCustomModelData(10118);
                    break;
                case 119:
                    ominousKeyMeta.setCustomModelData(10119);
                    break;
                case 120:
                    ominousKeyMeta.setCustomModelData(10120);
                    break;
                case 121:
                    ominousKeyMeta.setCustomModelData(10121);
                    break;
                case 122:
                    ominousKeyMeta.setCustomModelData(10122);
                    break;
                case 123:
                    ominousKeyMeta.setCustomModelData(10123);
                    break;
                case 124:
                    ominousKeyMeta.setCustomModelData(10124);
                    break;
                case 125:
                    ominousKeyMeta.setCustomModelData(10125);
                    break;
                case 126:
                    ominousKeyMeta.setCustomModelData(10126);
                    break;
                case 127:
                    ominousKeyMeta.setCustomModelData(10127);
                    break;
                case 128:
                    ominousKeyMeta.setCustomModelData(10128);
                    break;
                case 129:
                    ominousKeyMeta.setCustomModelData(10129);
                    break;
                case 130:
                    ominousKeyMeta.setCustomModelData(10130);
                    break;
                case 131:
                    ominousKeyMeta.setCustomModelData(10131);
                    break;
                case 132:
                    ominousKeyMeta.setCustomModelData(10132);
                    break;
                case 133:
                    ominousKeyMeta.setCustomModelData(10133);
                    break;
                case 134:
                    ominousKeyMeta.setCustomModelData(10134);
                    break;
                case 135:
                    ominousKeyMeta.setCustomModelData(10135);
                    break;
                case 136:
                    ominousKeyMeta.setCustomModelData(10136);
                    break;
                case 137:
                    ominousKeyMeta.setCustomModelData(10137);
                    break;
                case 138:
                    ominousKeyMeta.setCustomModelData(10138);
                    break;
                case 139:
                    ominousKeyMeta.setCustomModelData(10139);
                    break;
                case 140:
                    ominousKeyMeta.setCustomModelData(10140);
                    break;
                case 141:
                    ominousKeyMeta.setCustomModelData(10141);
                    break;
                case 142:
                    ominousKeyMeta.setCustomModelData(10142);
                    break;
                case 143:
                    ominousKeyMeta.setCustomModelData(10143);
                    break;
                case 144:
                    ominousKeyMeta.setCustomModelData(10144);
                    break;
                case 145:
                    ominousKeyMeta.setCustomModelData(10145);
                    break;
                case 146:
                    ominousKeyMeta.setCustomModelData(10146);
                    break;
                case 147:
                    ominousKeyMeta.setCustomModelData(10147);
                    break;
                case 148:
                    ominousKeyMeta.setCustomModelData(10148);
                    break;
                case 149:
                    ominousKeyMeta.setCustomModelData(10149);
                    break;
                case 150:
                    ominousKeyMeta.setCustomModelData(10150);
                    break;
                case 151:
                    ominousKeyMeta.setCustomModelData(10151);
                    break;
            }
            ominousKey.setItemMeta(ominousKeyMeta);
            armorStand.setItemInHand(ominousKey);
            EulerAngle rightArmPose = new EulerAngle(Math.toRadians(-90), Math.toRadians(0), Math.toRadians(0));
            armorStand.setRightArmPose(rightArmPose);
        }
        return false;
    }
}
