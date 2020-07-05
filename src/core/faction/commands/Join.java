package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class Join implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("join")){
			if(args.length==1){
				if(Faction.isPrivate(args[0])==true){
					Player p = (Player) sender;
					if(Faction.getInvites(args[0]).contains(p)){
						Faction.addPlayer(args[0], p);
					}
				}
				if(Faction.isPrivate(args[0])==false){
					Player p = (Player) sender;
					Faction.addPlayer(args[0], p);
				}
			}
		}
		return false;
	}
}
