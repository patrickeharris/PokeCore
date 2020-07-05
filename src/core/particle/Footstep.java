package core.particle;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import core.Core;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

public class Footstep implements CommandExecutor{
	Core plugin2 = Core.plugin;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("footstep")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin2, 
						new Runnable(){public void run(){
							PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
									EnumParticle.FOOTSTEP,
									true,
									(float)p.getLocation().getX()-0.1f,
									(float)p.getLocation().getY(),
									(float)p.getLocation().getZ()-0.1f,
									0,
									0,
									0,
									0f,
									1,
									null);
							PacketPlayOutWorldParticles packet2 = new PacketPlayOutWorldParticles(
									EnumParticle.FOOTSTEP,
									true,
									(float)p.getLocation().getX()+0.1f,
									(float)p.getLocation().getY(),
									(float)p.getLocation().getZ()+0.1f,
									0,
									0,
									0,
									0f,
									1,
									null);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet2);
				}}, 1, 1);
			}
		}
		return true;
		
	}
}
