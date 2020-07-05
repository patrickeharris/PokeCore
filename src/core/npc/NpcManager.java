package core.npc;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class NpcManager {

	  public static HashMap<String, Location> npcs = new HashMap<String, Location>();
	
	public static Entity AddNpc(EntityType entityType, String name, Location location)
	  {
	    LivingEntity entity = (LivingEntity)Bukkit.getWorld(location.getWorld().getName()).spawnEntity(location, entityType);
	    
	    entity.setCustomName(name);
	    entity.setCustomNameVisible(true);
	    entity.setCanPickupItems(false);
	    entity.setRemoveWhenFarAway(false);
	    
	    npcs.put(name, location);
	    
		return entity;
	    
	    
	  }

}
