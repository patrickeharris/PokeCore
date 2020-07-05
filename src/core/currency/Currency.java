package core.currency;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Currency implements CommandExecutor{
	static Map<String, Integer> coin = new HashMap<String, Integer>();
	public static void givePokeCoin(Player p, Integer i){
		Integer i2 = coin.get(p.getName());
		coin.replace(p.getName(), i2+i);
	}
	public static Integer getPokeCoin(Player p){
		return coin.get(p.getName());
	}
	public static void takePokeCoin(Player p, Integer i){
		Integer i2 = coin.get(p.getName());
		coin.replace(p.getName(), i2-i);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("givecoin")){
			if(args.length==2){
				if(sender.isOp()){
					for(Player p: Bukkit.getOnlinePlayers()){
						if(args[0].equalsIgnoreCase(p.getDisplayName())){
							Integer i = null;
							try{
							i = Integer.parseInt(args[1]);
							} catch(NumberFormatException ex) {}
							if(!coin.containsKey(p.getName())){
								coin.put(p.getName(), i);
								sender.sendMessage("You Have Given " + p.getDisplayName() + " " + args[1] + " Coins!");
								return true;
							}
							givePokeCoin(p, i);
							sender.sendMessage("You Have Given " + p.getDisplayName() + " " + args[1] + " Coins!");
						}
					}
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("takecoin")){
			if(args.length==2){
				if(sender.isOp()){
					for(Player p: Bukkit.getOnlinePlayers()){
						if(args[0].equalsIgnoreCase(p.getDisplayName())){
							Integer i = null;
							try{
							i = Integer.parseInt(args[1]);
							} catch(NumberFormatException ex) {}
							if(!coin.containsKey(p.getName())){
								return true;
							}
							takePokeCoin(p, i);
							sender.sendMessage("You Have Taken " + args[1] + " Coins " + "From " + p.getDisplayName());
						}
					}
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("balance")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				Integer i = getPokeCoin(p);
				p.sendMessage("" + i);
			}
		}
		return true;
	}
}
