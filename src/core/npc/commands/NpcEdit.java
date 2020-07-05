package core.npc.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.rank.Rank;
import core.rank.RankManager;
import core.util.ChatUtilities;

public class NpcEdit implements CommandExecutor{

	public static ArrayList<Player> editing = new ArrayList<Player>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
			if(commandLabel.equalsIgnoreCase("npcedit")){
				if(sender.isOp()==true){
					if(editing.contains(sender)){
						editing.remove(sender);
						ChatUtilities.sendMessage((Player) sender, "You Are No Longer In NPC Edit Mode!");
					}else
						if(!editing.contains(sender)){
							editing.add((Player) sender);
							ChatUtilities.sendMessage((Player) sender, "You Are Now In NPC Edit Mode!");
						}
				}
			}
			return false;
	}
		

}
