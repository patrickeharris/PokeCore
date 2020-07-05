package core.npc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.npc.NpcManager;
import core.rank.Rank;
import core.rank.RankManager;
import core.util.ChatUtilities;

public class RemoveNpc {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("removenpc")){
			if(RankManager.getRank((Player) sender).equals(Rank.ADMIN)){
				if(NpcManager.npcs.containsKey(args[0].toString())){
					Bukkit.getWorld(NpcManager.npcs.get(args[0]).getWorld().getName()).getEntities().remove(args[0]);
					NpcManager.npcs.remove(args[0]);
					ChatUtilities.sendMessage((Player) sender, "NPC Removed!");
				}
			}
		}
		return false;
	}

}
