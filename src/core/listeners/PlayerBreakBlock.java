package core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import core.faction.Faction;

public class PlayerBreakBlock implements Listener{

	@EventHandler
	public void onPlayerBreakBlock(BlockBreakEvent event){
		if(Faction.canBuild(event.getBlock().getLocation(), event.getPlayer())==false){
			event.setCancelled(true);
		}
	}
}
