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

public class Frost implements CommandExecutor{
	Core plugin2 = Core.plugin;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("frost")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin2, 
						new Runnable(){public void run(){
							PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
									EnumParticle.SNOW_SHOVEL,
									true,
									(float)p.getLocation().getX(),
									(float)p.getLocation().getY(),
									(float)p.getLocation().getZ(),
									0,
									0,
									0,
									0.05f,
									5,
									null);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
				}}, 1, 1);
			}
		}
		return true;
		
	}

}
