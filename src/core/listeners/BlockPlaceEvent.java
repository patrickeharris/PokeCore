package core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import core.faction.Faction;

public class BlockPlaceEvent implements Listener{

	@EventHandler
	public void onPlayerPlaceBlock(org.bukkit.event.block.BlockPlaceEvent event){
		if(Faction.canBuild(event.getBlock().getLocation(), event.getPlayer())==false){
			event.setCancelled(true);
		}
	}

}
