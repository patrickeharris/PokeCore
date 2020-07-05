package core.faction.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class Invite implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("factioninvite")){
			if(args.length==2){
				Player p2 = Faction.getOwner(args[0]);
				if(p2.equals((Player)sender)||sender.isOp()){
					for(Player p : Bukkit.getOnlinePlayers()){
						if(p.getName()==args[1]){
							Faction.invite(args[0], p);
							return false;
						}
					}
				}
			}
		}
		return false;
	}

}
