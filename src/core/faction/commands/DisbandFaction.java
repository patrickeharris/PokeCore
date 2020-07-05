package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class DisbandFaction implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("disbandfaction")){
			if(args.length==1){
				Player p = Faction.getOwner(args[0]);
				if(p.equals((Player)sender)||sender.isOp()){
					Faction.removeFaction(args[0]);
				}
			}
		}
		return false;
	}

}
