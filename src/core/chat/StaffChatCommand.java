package core.chat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import core.Core;
import core.listeners.PlayerChat;

public class StaffChatCommand implements CommandExecutor{
	
	Core plugin;
	public static Map<UUID, PermissionAttachment> staffperms = new HashMap<UUID, PermissionAttachment>();
	public static Map<UUID, PermissionAttachment> adminperms = new HashMap<UUID, PermissionAttachment>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin=Core.getPlugin(Core.class);
		if(commandLabel.equalsIgnoreCase("staffchat")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("chat.staff")){
					if(PlayerChat.getStaffChat(p)==true){
						PlayerChat.removeStaffChat(p);
						p.sendMessage("Staff Chat Toggled Off!");
					}else
						if(PlayerChat.getStaffChat(p)==false){
							PlayerChat.addStaffChat(p);
							PlayerChat.removeAdminChat(p);
							p.sendMessage("Staff Chat Toggled On!");
						}
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("adminchat")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("chat.admin")){
					if(PlayerChat.getAdminChat(p)==true){
						PlayerChat.removeAdminChat(p);
						p.sendMessage("Admin Chat Toggled Off!");
					}else
						if(PlayerChat.getStaffChat(p)==false){
							PlayerChat.addAdminChat(p);
							PlayerChat.removeStaffChat(p);
							p.sendMessage("Admin Chat Toggled On!");
						}
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("givestaffperm")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp()==true){
					if(args.length==1){
						for(Player p2 : Bukkit.getServer().getOnlinePlayers()){
							Bukkit.broadcastMessage(p2.getName());
							String name = p2.getName();
							if(args[0].equalsIgnoreCase(name)){
								if(!p2.hasPermission("chat.staff")){
									PermissionAttachment a = p2.addAttachment(plugin);
									staffperms.put(p2.getUniqueId(), a);
									staffperms.get(p2.getUniqueId()).setPermission("chat.staff", true);
									p.sendMessage("Permission Added!");
								}else
									p.sendMessage("1");
							}else
								p.sendMessage("2");
						}
					}else
						p.sendMessage("3");
				}else
					p.sendMessage("4");
			}else if(sender instanceof ConsoleCommandSender){
				if(args.length==1){
					for(Player p2 : Bukkit.getServer().getOnlinePlayers()){
						Bukkit.broadcastMessage(p2.getName());
						String name = p2.getName();
						if(args[0].equalsIgnoreCase(name)){
							if(!p2.hasPermission("chat.staff")){
								PermissionAttachment a = p2.addAttachment(plugin);
								staffperms.put(p2.getUniqueId(), a);
								staffperms.get(p2.getUniqueId()).setPermission("chat.staff", true);
								p2.sendMessage("Permission Added!");
							}
						}
					}
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("giveadminperm")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp()==true){
					if(args.length==1){
						for(Player p2: Bukkit.getOnlinePlayers()){
							if(args[0].equalsIgnoreCase(p2.getName())){
								if(!p2.hasPermission("chat.admin")){
									PermissionAttachment a= p2.addAttachment(plugin);
									adminperms.put(p2.getUniqueId(), a);
									adminperms.get(p2.getUniqueId()).setPermission("chat.admin", true);
									p.sendMessage("Permission Added!");
								}
							}
						}
					}
				}
			}else if(sender instanceof ConsoleCommandSender){
				if(args.length==1){
					for(Player p2: Bukkit.getOnlinePlayers()){
						if(args[0].equalsIgnoreCase(p2.getName())){
							if(!p2.hasPermission("chat.admin")){
								PermissionAttachment a= p2.addAttachment(plugin);
								adminperms.put(p2.getUniqueId(), a);
								adminperms.get(p2.getUniqueId()).setPermission("chat.admin", true);
								p2.sendMessage("Permission Added!");
							}
						}
					}
				}
			}
			} 
				
		if(commandLabel.equalsIgnoreCase("removestaffperm")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp()==true){
					if(args.length==1){
						for(Player p2: Bukkit.getOnlinePlayers()){
							if(args[0].equalsIgnoreCase(p2.getName())){
								if(p2.hasPermission("chat.staff")){
									staffperms.get(p2.getUniqueId()).unsetPermission("chat.staff");
									staffperms.get(p2.getUniqueId()).remove();
								}
							}
						}
					}
				}
			}else
				if(sender instanceof ConsoleCommandSender){
					if(args.length==1){
						for(Player p2: Bukkit.getOnlinePlayers()){
							if(args[0].equalsIgnoreCase(p2.getName())){
								if(p2.hasPermission("chat.staff")){
									staffperms.get(p2.getUniqueId()).unsetPermission("chat.staff");
									staffperms.get(p2.getUniqueId()).remove();
								}
							}
						}
					}
				}	
		}
		if(commandLabel.equalsIgnoreCase("removeadminperm")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.isOp()==true){
					if(args.length==1){
						for(Player p2: Bukkit.getOnlinePlayers()){
							if(args[0].equalsIgnoreCase(p2.getName())){
								if(p2.hasPermission("chat.admin")){
									adminperms.get(p2.getUniqueId()).unsetPermission("chat.admin");
									adminperms.get(p2).remove();
								}
							}
						}
					}
				}
			}else
				if(sender instanceof ConsoleCommandSender){
					if(args.length==1){
						for(Player p2: Bukkit.getOnlinePlayers()){
							if(args[0].equalsIgnoreCase(p2.getName())){
								if(p2.hasPermission("chat.admin")){
									adminperms.get(p2.getUniqueId()).unsetPermission("chat.admin");
									adminperms.get(p2.getUniqueId()).remove();
								}
							}
						}
					}
				}
				
	}
		return true;

	}
}
