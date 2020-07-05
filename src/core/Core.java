package core;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import core.chat.StaffChatCommand;
import core.currency.Currency;
import core.disguise.DisguiseCommand;
import core.faction.commands.FactionCommands;
import core.listeners.BlockPlaceEvent;
import core.listeners.EntityDamage;
import core.listeners.InventoryClick;
import core.listeners.PlayerBreakBlock;
import core.listeners.PlayerChat;
import core.listeners.PlayerInteract;
import core.listeners.PlayerInteractEntity;
import core.npc.commands.AddNpc;
import core.npc.commands.NpcEdit;
import core.npc.commands.NpcSlow;
import core.particle.Flame;
import core.particle.Footstep;
import core.particle.Frost;
import core.particle.RainCloud;
import core.particle.SnowCloud;
import core.shop.Shop;

public class Core extends JavaPlugin{

	public final Logger logger = Logger.getLogger("Minecraft");
	public static Core plugin;
	
	@Override
	public void onEnable(){
		plugin = this;
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EntityDamage(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerInteract(), this);
		pm.registerEvents(new PlayerInteractEntity(), this);
		pm.registerEvents(new PlayerBreakBlock(), this);
		pm.registerEvents(new BlockPlaceEvent(), this);
		pm.registerEvents(new InventoryClick(), this);
		getCommand("zombie").setExecutor(new DisguiseCommand());
		getCommand("cloud").setExecutor(new RainCloud());
		getCommand("footstep").setExecutor(new Footstep());
		getCommand("flame").setExecutor(new Flame());
		getCommand("frost").setExecutor(new Frost());
		getCommand("snowcloud").setExecutor(new SnowCloud());
		getCommand("shop").setExecutor(new Shop());
		getCommand("balance").setExecutor(new Currency());
		getCommand("givecoin").setExecutor(new Currency());
		getCommand("takecoin").setExecutor(new Currency());
		getCommand("staffchat").setExecutor(new StaffChatCommand());
		getCommand("adminchat").setExecutor(new StaffChatCommand());
		getCommand("givestaffperm").setExecutor(new StaffChatCommand());
		getCommand("giveadminperm").setExecutor(new StaffChatCommand());
		getCommand("removestaffperm").setExecutor(new StaffChatCommand());
		getCommand("removeadminperm").setExecutor(new StaffChatCommand());
		getCommand("addnpc").setExecutor(new AddNpc());
		getCommand("npcedit").setExecutor(new NpcEdit());
		getCommand("npcslow").setExecutor(new NpcSlow());
		getCommand("faction").setExecutor(new FactionCommands());
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Disabled");
	}

}
