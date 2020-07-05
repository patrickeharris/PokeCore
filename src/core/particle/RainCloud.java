package core.particle;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import core.Core;
import de.slikey.effectlib.util.ParticleEffect;
import net.minecraft.server.v1_8_R1.EnumParticle;
import net.minecraft.server.v1_8_R1.PacketPlayOutWorldParticles;

public class RainCloud implements CommandExecutor {

	Core plugin2 = Core.plugin;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("cloud")){
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
									EnumParticle.WATER_SPLASH,
									true,
									(float)p.getLocation().getX(),
									(float)p.getLocation().getY()+2.5f,
									(float)p.getLocation().getZ(),
									0.4f,
									0,
									0.4f,
									1,
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
