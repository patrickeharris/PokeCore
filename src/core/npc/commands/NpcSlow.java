package core.npc.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.rank.Rank;
import core.rank.RankManager;
import core.util.ChatUtilities;

public class NpcSlow implements CommandExecutor{

	public static ArrayList<Player> slowing = new ArrayList<Player>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
			if(commandLabel.equalsIgnoreCase("npcslow")){
				if(sender.isOp()==true){
					if(slowing.contains(sender)){
						slowing.remove(sender);
						ChatUtilities.sendMessage((Player) sender, "You Are No Longer In NPC Edit Mode!");
					}else
						if(!slowing.contains(sender)){
							slowing.add((Player) sender);
							ChatUtilities.sendMessage((Player) sender, "You Are Now In NPC Edit Mode!");
						}
				}
			}
			return false;
	}
		

}
