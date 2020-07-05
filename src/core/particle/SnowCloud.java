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

public class SnowCloud implements CommandExecutor{

	Core plugin2 = Core.plugin;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("snowcloud")){
			if(sender instanceof Player){
				Player p = (Player) sender;

				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin2, 
						new Runnable(){public void run(){
							PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
									EnumParticle.CLOUD,
									true,
									(float)p.getLocation().getX(),
									(float)p.getLocation().getY()+3,
									(float)p.getLocation().getZ(),
									0,
									0,
									0,
									0.02f,
									20,
									null);
							PacketPlayOutWorldParticles packet2 = new PacketPlayOutWorldParticles(
									EnumParticle.CLOUD,
									true,
									(float)p.getLocation().getX()+0.5f,
									(float)p.getLocation().getY()+3,
									(float)p.getLocation().getZ()+0.5f,
									0,
									0,
									0,
									0.02f,
									20,
									null);
							PacketPlayOutWorldParticles packet3 = new PacketPlayOutWorldParticles(
									EnumParticle.CLOUD,
									true,
									(float)p.getLocation().getX()-0.5f,
									(float)p.getLocation().getY()+3,
									(float)p.getLocation().getZ()-0.5f,
									0,
									0,
									0,
									0.02f,
									20,
									null);
							PacketPlayOutWorldParticles packet4 = new PacketPlayOutWorldParticles(
									EnumParticle.CLOUD,
									true,
									(float)p.getLocation().getX()+0.5f,
									(float)p.getLocation().getY()+3,
									(float)p.getLocation().getZ()-0.5f,
									0,
									0,
									0,
									0.02f,
									20,
									null);
							PacketPlayOutWorldParticles packet5 = new PacketPlayOutWorldParticles(
									EnumParticle.CLOUD,
									true,
									(float)p.getLocation().getX()-0.5f,
									(float)p.getLocation().getY()+3,
									(float)p.getLocation().getZ()+0.5f,
									0,
									0,
									0,
									0.02f,
									20,
									null);
							PacketPlayOutWorldParticles packet6 = new PacketPlayOutWorldParticles(
									EnumParticle.SNOW_SHOVEL,
									true,
									(float)p.getLocation().getX(),
									(float)p.getLocation().getY()+2.5f,
									(float)p.getLocation().getZ(),
									0.4f,
									0,
									0.4f,
									0.1f,
									5,
									null);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet2);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet3);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet4);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet5);
							((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet6);
				}}, 1, 1);
			}
		}
		return true;
		
	}

}
