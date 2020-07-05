package core.faction.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import core.faction.Faction;

public class Kick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("factionkick")){
			if(args.length==2){
				Player p = (Player) sender;
				List<Player> admins = Faction.getAdmins(args[0]);
				for(Player player : admins){
					if(player.equals(p)){
						for(Player player2 : Faction.getPlayers(args[0])){
							if(player2.getName().equalsIgnoreCase(args[1])){
								Faction.removePlayer(args[0], player2);;
							}
						}
					}
				}
			}
		}
		return false;
	}

}
