package core.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import core.npc.NpcManager;

public class EntityDamage implements Listener{

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event){
		if(NpcManager.npcs.containsKey(event.getEntity().getName())){
			event.setCancelled(true);
		}
	}

}
