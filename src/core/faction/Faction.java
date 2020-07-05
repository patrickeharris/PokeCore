package core.faction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import core.util.ChatUtilities;
import core.util.Cuboid;

public class Faction {

	static List<String> factions = new ArrayList<String>();
	static Map<String, Player> owners = new HashMap<String, Player>();
	static Map<String, List<Player>> admins = new HashMap<String, List<Player>>();
	static Map<String, List<Player>> players = new HashMap<String, List<Player>>();
	static Map<String, List<Player>> invites = new HashMap<String, List<Player>>();
	static Map<String, Location> spawns = new HashMap<String, Location>();
	static Map<String, Boolean> privates = new HashMap<String, Boolean>();
	static Map<String, List<Location>> claimed = new HashMap<String, List<Location>>();
	
	public static void createFaction(String name, Player owner){
		if(!factions.contains(name)){
			List<Location> locs = new ArrayList<Location>();
			List<Player> faction = new ArrayList<Player>();
			List<Player> admin = new ArrayList<Player>();
			List<Player> invite = new ArrayList<Player>();
			Location spawn = owner.getLocation();
			factions.add(name);
			owners.put(name, owner);
			admins.put(name, admin);
			
			admins.get(name).add(owner);
			players.put(name, faction);
			players.get(name).add(owner);
			spawns.put(name, spawn);
			privates.put(name, true);
			invites.put(name, invite);
			claimed.put(name, locs);
			ChatUtilities.broadcast("Faction " + name + " has been created!");
		}
	}
	public static List<Player> inFaction(String name){
		if(factions.contains(name))
			return players.get(name);
		return null;
	}
	public static void removeFaction(String name){
		if(factions.contains(name)){
			factions.remove(name);
			owners.remove(name);
			admins.remove(name);
			players.remove(name);
			spawns.remove(name);
			privates.remove(name);
			invites.remove(name);
		}
	}
	public static void setSpawn(String name, Location l){
		if(factions.contains(name)){
			if(!spawns.get(name).equals(l)){
				spawns.replace(name, l);
			}
		}
	}
	public static void tpToSpawn(String name, Player p){
		if(factions.contains(name)){
			if(!spawns.get(name).equals(null)){
				Location l = spawns.get(name);
				p.teleport(l);
			}
		}
	}
	public static void addPlayer(String name, Player p){
		if(factions.contains(name)){
			if(!players.get(name).contains(p)){
				if(!players.containsValue(p)){
					players.get(name).add(p);
				}
			}
		}
	}
	public static void removePlayer(String name, Player p){
		if(factions.contains(name)){
			if(players.get(name).contains(p)){
				players.get(name).remove(p);
				if(admins.get(name).contains(p)){
					admins.get(name).remove(p);
				}
			}
		}
	}
	public static void promotePlayer(String name, Player p){
		if(factions.contains(name)){
			if(players.get(name).contains(p)){
				if(!admins.get(name).contains(p)){
					admins.get(name).add(p);
				}
			}
		}
	}
	public static void demotePlayer(String name, Player p){
		if(factions.contains(name)){
			if(admins.get(name).contains(p)){
					admins.get(name).remove(p);
			}
		}
	}
	public static void giveOwnership(String name, Player p){
		if(factions.contains(name)){
			if(players.get(name).contains(p)){
				if(!owners.get(name).equals(p)){
					owners.replace(name, p);
				}
			}
		}
	}
	public static Player getOwner(String name){
		if(factions.contains(name)){
			return owners.get(name);
		}
		return null;
	}
	public static boolean isPrivate(String name){
		if(factions.contains(name)){
			return privates.get(name);
		}
		return true;
	}
	public static void setVisibility(String name, boolean visibility){
		if(factions.contains(name)){
			privates.remove(name);
			privates.put(name, visibility);
		}
	}
	public static void claim(String name, Location l1, Location l2){
		if(factions.contains(name)){
			Location claim1 = new Location(l1.getWorld(), l1.getX(), l1.getWorld().getMaxHeight(), l1.getZ());
			Location claim2 = new Location(l2.getWorld(), l2.getX(), 0, l2.getZ());
			Cuboid cuboid = new Cuboid(claim1, claim2);
			for(Block b : cuboid.getBlocks()){
				if(claimed.containsValue(b)){
					return;
				}
			}
			for(Block b : cuboid.getBlocks()){
				claimed.get(name).add(b.getLocation());
			}
			for(Player p: players.get(name)){
				p.sendMessage("Land Has Been Claimed For Your Faction!");
			}
		}
	}
	public static String getFaction(Player p){
		for(String string : factions){
			if(players.get(string).contains(p)){
				return string;
			}
		}
		return null;
	}
	public static List<Player> getPlayers(String name){
		if(factions.contains(name)){
			return players.get(name);
		}
		return null;
	}
	public static List<Player> getAdmins(String name){
		if(factions.contains(name)){
			return admins.get(name);
		}
		return null;
	}
	public static List<Player> getInvites(String name){
		if(factions.contains(name)){
			return invites.get(name);
		}
		return null;
	}
	public static void invite(String name, Player p){
		if(factions.contains(name)){
			if(privates.get(name)==true){
				if(!invites.get(name).contains(p)&&!players.get(name).contains(p)){
					invites.get(name).add(p);
				}
			}
		}
	}
	public static boolean hasFaction(Player p){
		for(String faction : factions){
			if(players.get(faction).contains(p))
				return true;
		}
		return false;
	}
	public static boolean canBuild(Location l, Player p){
		for(String faction : factions){
			if(claimed.get(faction).contains(l)){
				if(!players.get(faction).contains(p)){
					return false;
				}
			}
		}
		return true;
		
	}
}
