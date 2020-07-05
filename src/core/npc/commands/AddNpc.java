package core.npc.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.CraftServer;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;

import core.npc.NpcManager;
import core.rank.Rank;
import core.rank.RankManager;
import net.minecraft.server.v1_8_R1.EntityPlayer;
import net.minecraft.server.v1_8_R1.EnumPlayerInfoAction;
import net.minecraft.server.v1_8_R1.MinecraftServer;
import net.minecraft.server.v1_8_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R1.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R1.PlayerConnection;
import net.minecraft.server.v1_8_R1.PlayerInteractManager;
import net.minecraft.server.v1_8_R1.WorldServer;

public class AddNpc implements CommandExecutor{
	Map<EntityPlayer, Location> players = new HashMap<EntityPlayer, Location>();

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(commandLabel.equalsIgnoreCase("addnpc")){
			if(sender.isOp()==true){
				if(args.length==2||args.length==3){
					String mobName = args[0];
					Player player = (Player) sender;
					Location mobLocation = player.getLocation();
					if(args[1].equalsIgnoreCase("player")){
						if(args.length==3){
						Player p2 = null;
						for(Player p: Bukkit.getOnlinePlayers()){
							if(p.getName().equalsIgnoreCase(args[0])){
								p2=p;
							} 
						}
						if(p2!=null){
							MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
							WorldServer nmsWorld = ((CraftWorld) player.getWorld()).getHandle();
							EntityPlayer p= new EntityPlayer(nmsServer, nmsWorld, new GameProfile(p2.getUniqueId(), args[2]), new PlayerInteractManager(nmsWorld));
							players.put(p, player.getLocation());
							p.setLocation(player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), 0, 0);
							PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
							connection.sendPacket(new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, p));
							connection.sendPacket(new PacketPlayOutNamedEntitySpawn(p));
							
						}
						
					}
					}
					if(args.length==2){
					for(EntityType e: EntityType.values()){
						if(e.name().equalsIgnoreCase(args[1].toString())){
							if(e.isSpawnable()){
								NpcManager.AddNpc(e, mobName, mobLocation);
							}
						}
					}
				}
				}		
			}
		}
		
		return false;
		
	}

}
