package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class CreateFaction implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("createfaction")){
			if(args.length==1){
				Faction.createFaction(args[0], (Player) sender);
			}
		}
		return false;
	}

}
