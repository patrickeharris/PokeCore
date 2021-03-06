package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class Demote implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("factiondemote")){
			if(args.length==2){
				Player p = (Player) sender;
				Player owner = Faction.getOwner(args[0]);
				if(p.equals(owner)){
					for(Player player : Faction.getAdmins(args[0])){
						if(player.getName().equalsIgnoreCase(args[1])){
							Faction.demotePlayer(args[0], player);
						}
					}
				}
			}
		}
		return false;
	}

}
