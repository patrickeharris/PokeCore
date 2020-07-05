package core.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.permissions.PermissionAttachment;

public class PlayerChat implements Listener{

	static List<Player> staffChat = new ArrayList<Player>();
	static List<Player> adminChat = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event){
		if(staffChat.contains(event.getPlayer())){
			event.setCancelled(true);
			for(Player p : staffChat){
				p.sendMessage(event.getFormat());
				p.sendMessage("staffchat");
			}
		}
		if(adminChat.contains(event.getPlayer())){
			event.setCancelled(true);
			for(Player p : adminChat){
				p.sendMessage(event.getFormat());
				p.sendMessage("adminchat");
			}
		}
	}
	public static void addStaffChat(Player p){
		if(!staffChat.contains(p)){
			staffChat.add(p);
		}
	}
	public static void removeStaffChat(Player p){
		if(staffChat.contains(p)){
			staffChat.remove(p);
		}
	}
	public static void addAdminChat(Player p){
		if(!adminChat.contains(p)){
			adminChat.add(p);
		}
	}
	public static void removeAdminChat(Player p){
		if(adminChat.contains(p)){
			adminChat.remove(p);
		}
	}
	public static boolean getStaffChat(Player p){
		if(staffChat.contains(p))
			return true;
		return false;
	}
	public static boolean getAdminChat(Player p){
		if(adminChat.contains(p))
			return true;
		return false;
	}

}
