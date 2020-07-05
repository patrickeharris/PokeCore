package core.rank;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class RankManager {

	private static HashMap<Player, Rank> list = new HashMap<Player, Rank>();
	
	
	public static void setRank(Player player, Rank rank){
		list.put(player, rank);
	}
	
	public static Rank getRank(Player player){
		Rank rank = Rank.ALL;
		if(!list.containsKey(player)){
			rank = list.get(player);
		}
		return rank;
		
	}
	
	
}
