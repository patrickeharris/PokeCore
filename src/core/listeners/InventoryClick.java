package core.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;

import core.shop.Shop;

public class InventoryClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		if(inv.getTitle().equals("Shop")){
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if(event.getRawSlot() < event.getView().getTopInventory().getSize()){
				Shop test = new Shop();
				test.clickedItem(item, player);
			}
			event.setCancelled(true);
		}
		if(inv.getTitle().equals("Ores and Ingots")){
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if(event.getRawSlot() < event.getView().getTopInventory().getSize()){
				int amount = item.getAmount();
				Material m = item.getType();
				if(item.getType() == Material.INK_SACK){
					ItemMeta meta = item.getItemMeta();
					String price = meta.getLore().get(0);
					Shop test = new Shop();
					test.buying(m, amount, player, true, price);
					event.setCancelled(true);
					return;
				}
				ItemMeta meta = item.getItemMeta();
				String price = meta.getLore().get(0);
				Shop test = new Shop();
				test.buying(m, amount, player, false, price);
			}
			event.setCancelled(true);
		}
		if(inv.getTitle().equals("Weapons and Armor")){
			Player player = (Player) event.getWhoClicked();
			ItemStack item = event.getCurrentItem();
			if(event.getRawSlot() < event.getView().getTopInventory().getSize()){
				int amount = item.getAmount();
				Material m = item.getType();
				ItemMeta meta = item.getItemMeta();
				String price = meta.getLore().get(0);
				Shop test = new Shop();
				test.buying(m, amount, player, false, price);
			}
			event.setCancelled(true);
		}
	}

}
