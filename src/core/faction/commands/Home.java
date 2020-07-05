package core.faction.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class Home implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("factionhome")){
			if(args.length==0){
				Player p = (Player) sender;
				String s = Faction.getFaction(p);
				if(s!=null){
				Faction.tpToSpawn(s, p);
				}
			}
		}
		return false;
	}

}
