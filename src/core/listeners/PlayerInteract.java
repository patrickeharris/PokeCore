package core.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import core.faction.Faction;

public class PlayerInteract implements Listener{
	static Map<Player, List<Location>> players = new HashMap<Player, List<Location>>();
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		if(event.getPlayer().getItemInHand().getType().equals(Material.STICK)){
			if(!players.containsKey(event.getPlayer())){
				if(Faction.hasFaction(event.getPlayer())==true){
					List<Location> locks = new ArrayList<Location>();
					players.put(event.getPlayer(), locks);
					players.get(event.getPlayer()).add(event.getClickedBlock().getLocation());
				}
			}else
				if(players.containsKey(event.getPlayer())){
					if(Faction.hasFaction(event.getPlayer())==true){
						players.get(event.getPlayer()).add(event.getClickedBlock().getLocation());
						Faction.claim(Faction.getFaction(event.getPlayer()), players.get(event.getPlayer()).get(0), players.get(event.getPlayer()).get(1));
						players.remove(event.getPlayer());
					}
				}
		}
	}

}
