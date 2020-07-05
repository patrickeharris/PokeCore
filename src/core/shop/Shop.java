package core.shop;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Dye;
import org.bukkit.material.MaterialData;

import core.currency.Currency;

public class Shop implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(commandLabel.equalsIgnoreCase("shop")){
			if(!(sender instanceof Player)){
				sender.sendMessage("You must be a player to use this command!");
				return false;
			}
			Player player = (Player) sender;
			Inventory inv = Bukkit.createInventory(null, 9, "Shop");
			inv.addItem(nameItem(Material.DIAMOND, "Ores and Ingots"));
			inv.addItem(nameItem(Material.WOOD, "Building Blocks"));
			inv.addItem(nameItem(Material.DIAMOND_SWORD, "Weapons and Armor"));
			inv.addItem(nameItem(Material.IRON_SPADE, "Tools"));
			inv.addItem(nameItem(Material.POTION, "Potions"));
			inv.addItem(nameItem(Material.BONE, "Mob Drops"));
			inv.addItem(nameItem(Material.BREAD, "Food"));
			inv.addItem(nameItem(Material.RED_ROSE, "Decorations"));
			player.openInventory(inv);
		}
		return true;
	}
	private ItemStack nameItem2(ItemStack item, String name){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}
	private ItemStack nameItem(Material item, String name){
		return nameItem2(new ItemStack(item), name);
	}
	private ItemStack setitem2(ItemStack item, String name, String lore){
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		List<String> lores = new ArrayList<String>();
		lores.add(lore);
		meta.setLore(lores);
		item.setItemMeta(meta);
		return item;
	}
	private ItemStack setItem(Material item, String name, String lore){
		return setitem2(new ItemStack(item), name, lore);
	}
	public void clickedItem(ItemStack item, Player p){
		if(item.getType() == Material.DIAMOND)
			clickedDiamond(p);
		if(item.getType() == Material.DIAMOND_SWORD)
			clickedSword(p);
		if(item.getType() == Material.IRON_SPADE)
			clickedTool(p);
		if(item.getType() == Material.RED_ROSE)
			clickedDec(p);
		if(item.getType() == Material.BREAD)
			clickedFood(p);
		if(item.getType() == Material.POTION)
			clickedPotion(p);
		if(item.getType() == Material.WOOD)
			clickedWood(p);
		if(item.getType() == Material.BONE)
			clickedDrop(p);
		
	}
	public void buying(Material item, int amount, Player p, boolean b, String price){
		Integer i2 = null;
		try{
			i2 = Integer.parseInt(price);
			} catch(NumberFormatException ex) {}
		if(!(Currency.getPokeCoin(p)>i2)){
			p.sendMessage("You Don't Have Enough Coins!");
			return;
		}
		Currency.takePokeCoin(p, i2);
		if(b==true){
			Dye blue = new Dye();
			blue.setColor(DyeColor.BLUE);
			ItemStack lapis = blue.toItemStack(amount);
			p.getInventory().addItem(lapis);
			p.updateInventory();
			return;
		}
		ItemStack i = new ItemStack(item, amount);
		p.getInventory().addItem(i);
		p.updateInventory();
	}
	private void clickedDiamond(Player p){
		Inventory ingot = Bukkit.createInventory(null, 9, "Ores and Ingots");
		ingot.addItem(setItem(Material.DIAMOND, "Diamond", "100"));
		ingot.addItem(setItem(Material.IRON_INGOT, "Iron Ingot", "50"));
		ingot.addItem(setItem(Material.GOLD_INGOT, "Gold Ingot", "75"));
		ingot.addItem(setItem(Material.COAL, "Coal", "25"));
		ingot.addItem(setItem(Material.REDSTONE, "Redstone", "75"));
		Dye blue = new Dye();
		blue.setColor(DyeColor.BLUE);
		ItemStack lapis = blue.toItemStack(1);
		ItemMeta meta = lapis.getItemMeta();
		meta.setDisplayName("Lapis");
		List<String> lores = new ArrayList<String>();
		lores.add("75");
		meta.setLore(lores);
		lapis.setItemMeta(meta);
		ingot.addItem(lapis);
		p.openInventory(ingot);

	}
	private void clickedWood(Player p){
		Inventory block = Bukkit.createInventory(null, 9, "Building Blocks");
	}
	private void clickedSword(Player p){
		Inventory weapon = Bukkit.createInventory(null, 27, "Weapons and Armor");
		weapon.addItem(setItem(Material.DIAMOND_SWORD, "Diamond Sword", "200"));
		weapon.addItem(setItem(Material.IRON_SWORD, "Iron Sword", "100"));
		weapon.addItem(setItem(Material.WOOD_SWORD, "Wood Sword", "25"));
		weapon.addItem(setItem(Material.GOLD_SWORD, "Gold Sword", "25"));
		weapon.addItem(setItem(Material.STONE_SWORD, "Stone Sword", "50"));
		weapon.addItem(setItem(Material.DIAMOND_CHESTPLATE, "Diamond Chestplate", "800"));
		weapon.addItem(setItem(Material.DIAMOND_LEGGINGS, "Diamond Leggings", "700"));
		weapon.addItem(setItem(Material.DIAMOND_BOOTS, "Diamond Boots", "400"));
		weapon.addItem(setItem(Material.DIAMOND_HELMET, "Diamond Helmet", "500"));
		weapon.addItem(setItem(Material.IRON_CHESTPLATE, "Iron Chestplate", "400"));
		weapon.addItem(setItem(Material.IRON_LEGGINGS, "Iron Leggings", "350"));
		weapon.addItem(setItem(Material.IRON_BOOTS, "Iron Boots", "200"));
		weapon.addItem(setItem(Material.IRON_HELMET, "Iron Helmet", "250"));
		weapon.addItem(setItem(Material.GOLD_CHESTPLATE, "Gold Chestplate", "120"));
		weapon.addItem(setItem(Material.GOLD_LEGGINGS, "Gold Leggings", "105"));
		weapon.addItem(setItem(Material.GOLD_BOOTS, "Gold Boots", "60"));
		weapon.addItem(setItem(Material.GOLD_HELMET, "Gold Helmet", "75"));
		weapon.addItem(setItem(Material.CHAINMAIL_CHESTPLATE, "Chain Chestplate", "160"));
		weapon.addItem(setItem(Material.CHAINMAIL_LEGGINGS, "Chain Leggings", "140"));
		weapon.addItem(setItem(Material.CHAINMAIL_BOOTS, "Chain Boots", "80"));
		weapon.addItem(setItem(Material.CHAINMAIL_HELMET, "Chain Helmet", "100"));
		weapon.addItem(setItem(Material.LEATHER_CHESTPLATE, "Leather Chestplate", "80"));
		weapon.addItem(setItem(Material.LEATHER_LEGGINGS, "Leather Leggings", "70"));
		weapon.addItem(setItem(Material.LEATHER_BOOTS, "Leather Boots", "40"));
		weapon.addItem(setItem(Material.LEATHER_HELMET, "Leather Helmet", "50"));
		p.openInventory(weapon);
	}
	private void clickedPotion(Player p){
		Inventory potion = Bukkit.createInventory(null, 9, "Potions");
	}
	private void clickedDec(Player p){
		Inventory decorations = Bukkit.createInventory(null, 9, "Decorations");
	}
	private void clickedTool(Player p){
		Inventory tools = Bukkit.createInventory(null, 9, "Tools");
	}
	private void clickedFood(Player p){
		Inventory food = Bukkit.createInventory(null, 9, "Food");
	}
	private static void clickedDrop(Player p){
		Inventory drops = Bukkit.createInventory(null, 9, "Mob Drops");
	}
}
