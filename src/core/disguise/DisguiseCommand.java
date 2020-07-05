package core.disguise;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class DisguiseCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("zombie")){
			Disguise.playerAsMob((Player)sender, EntityType.ZOMBIE, null);
		}
		return false;
	}

}
