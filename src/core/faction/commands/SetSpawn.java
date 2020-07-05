package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class SetSpawn implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("setfactionspawn")){
			if(args.length==1){
				Player p = (Player) sender;
				Player owner = Faction.getOwner(args[0]);
				if(p.equals(owner)){
					Faction.setSpawn(args[0], p.getLocation());
				}
			}
		}
		return false;
	}

}
