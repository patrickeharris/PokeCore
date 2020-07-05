package core.util;

import java.util.HashMap;
import java.util.LinkedList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class UtilEnt
{
  private static HashMap<org.bukkit.entity.Entity, String> _nameMap = new HashMap<Entity, String>();
  private static HashMap<String, EntityType> creatureMap = new HashMap<String, EntityType>();
  public static HashMap<org.bukkit.entity.Entity, String> GetEntityNames()
  {
    return _nameMap;
  }
  

  
  public static void populate()
  {
    if (creatureMap.isEmpty())
    {
      creatureMap.put("Bat", EntityType.BAT);
      creatureMap.put("Blaze", EntityType.BLAZE);
      creatureMap.put("Arrow", EntityType.ARROW);
      creatureMap.put("Cave Spider", EntityType.CAVE_SPIDER);
      creatureMap.put("Chicken", EntityType.CHICKEN);
      creatureMap.put("Cow", EntityType.COW);
      creatureMap.put("Creeper", EntityType.CREEPER);
      creatureMap.put("Ender Dragon", EntityType.ENDER_DRAGON);
      creatureMap.put("Enderman", EntityType.ENDERMAN);
      creatureMap.put("Ghast", EntityType.GHAST);
      creatureMap.put("Giant", EntityType.GIANT);
      creatureMap.put("Horse", EntityType.HORSE);
      creatureMap.put("Iron Golem", EntityType.IRON_GOLEM);
      creatureMap.put("Item", EntityType.DROPPED_ITEM);
      creatureMap.put("Magma Cube", EntityType.MAGMA_CUBE);
      creatureMap.put("Mooshroom", EntityType.MUSHROOM_COW);
      creatureMap.put("Ocelot", EntityType.OCELOT);
      creatureMap.put("Pig", EntityType.PIG);
      creatureMap.put("Pig Zombie", EntityType.PIG_ZOMBIE);
      creatureMap.put("Sheep", EntityType.SHEEP);
      creatureMap.put("Silverfish", EntityType.SILVERFISH);
      creatureMap.put("Skeleton", EntityType.SKELETON);
      creatureMap.put("Slime", EntityType.SLIME);
      creatureMap.put("Snowman", EntityType.SNOWMAN);
      creatureMap.put("Spider", EntityType.SPIDER);
      creatureMap.put("Squid", EntityType.SQUID);
      creatureMap.put("Villager", EntityType.VILLAGER);
      creatureMap.put("Witch", EntityType.WITCH);
      creatureMap.put("Wither", EntityType.WITHER);
      creatureMap.put("WitherSkull", EntityType.WITHER_SKULL);
      creatureMap.put("Wolf", EntityType.WOLF);
      creatureMap.put("Zombie", EntityType.ZOMBIE);
      
      creatureMap.put("Item", EntityType.DROPPED_ITEM);
    }
  }
  
  public static String getName(org.bukkit.entity.Entity ent)
  {
    if (ent == null) {
      return "Null";
    }
    if (ent.getType() == EntityType.PLAYER) {
      return ((Player)ent).getName();
    }
    if (GetEntityNames().containsKey(ent)) {
      return (String)GetEntityNames().get(ent);
    }
    if ((ent instanceof LivingEntity))
    {
      LivingEntity le = (LivingEntity)ent;
      if (le.getCustomName() != null) {
        return le.getCustomName();
      }
    }
    return getName(ent.getType());
  }
  
  @SuppressWarnings("deprecation")
public static String getName(EntityType type)
  {
    for (String cur : creatureMap.keySet()) {
      if (creatureMap.get(cur) == type) {
        return cur;
      }
    }
    return type.getName();
  }
  
  public static String searchName(Player caller, String arg, boolean inform)
  {
    populate();
    
    arg = arg.toLowerCase().replaceAll("_", " ");
    LinkedList<String> matchList = new LinkedList<String>();
    for (String cur : creatureMap.keySet())
    {
      if (cur.equalsIgnoreCase(arg)) {
        return cur;
      }
      if (cur.toLowerCase().contains(arg)) {
        matchList.add(cur);
      }
    }
    if (matchList.size() != 1)
    {
      if (!inform) {
        return null;
      }
      ChatUtilities.sendMessage(caller, F.main("Creature Search", 
        C.mCount + matchList.size() + 
        C.mBody + " matches for [" + 
        C.mElem + arg + 
        C.mBody + "]."));
      if (matchList.size() > 0)
      {
        String matchString = "";
        for (String cur : matchList) {
          matchString = matchString + F.elem(cur) + ", ";
        }
        if (matchString.length() > 1) {
          matchString = matchString.substring(0, matchString.length() - 2);
        }
        ChatUtilities.sendMessage(caller, F.main("Creature Search", 
          C.mBody + "Matches [" + 
          C.mElem + matchString + 
          C.mBody + "]."));
      }
      return null;
    }
    return (String)matchList.get(0);
  }
  
  @SuppressWarnings("deprecation")
public static EntityType searchEntity(Player caller, String arg, boolean inform)
  {
    populate();
    
    arg = arg.toLowerCase();
    LinkedList<EntityType> matchList = new LinkedList<EntityType>();
    for (String cur : creatureMap.keySet())
    {
      if (cur.equalsIgnoreCase(arg)) {
        return (EntityType)creatureMap.get(cur);
      }
      if (cur.toLowerCase().contains(arg)) {
        matchList.add((EntityType)creatureMap.get(cur));
      }
    }
    if (matchList.size() != 1)
    {
      if (!inform) {
        return null;
      }
      ChatUtilities.sendMessage(caller, F.main("Creature Search", 
        C.mCount + matchList.size() + 
        C.mBody + " matches for [" + 
        C.mElem + arg + 
        C.mBody + "]."));
      if (matchList.size() > 0)
      {
        String matchString = "";
        for (EntityType cur : matchList) {
          matchString = matchString + F.elem(cur.getName()) + ", ";
        }
        if (matchString.length() > 1) {
          matchString = matchString.substring(0, matchString.length() - 2);
        }
        ChatUtilities.sendMessage(caller, F.main("Creature Search", 
          C.mBody + "Matches [" + 
          C.mElem + matchString + 
          C.mBody + "]."));
      }
      return null;
    }
    return (EntityType)matchList.get(0);
  }
  
 
}
