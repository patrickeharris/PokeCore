package core.listeners;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import core.npc.NpcManager;
import core.npc.commands.NpcEdit;
import core.npc.commands.NpcSlow;
import core.util.ChatUtilities;
import net.minecraft.server.v1_8_R1.Entity;

public class PlayerInteractEntity implements Listener{

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event){
		if(NpcEdit.editing.contains(event.getPlayer())){
				ItemStack inHand = event.getPlayer().getItemInHand();
				ItemStack[] armor = event.getPlayer().getInventory().getArmorContents();
				LivingEntity npc = (LivingEntity)event.getRightClicked();
				npc.getEquipment().setArmorContents(armor);
				npc.getEquipment().setItemInHand(inHand);
				ChatUtilities.sendMessage(event.getPlayer(), "Added To NPC!");
		}
		if(NpcSlow.slowing.contains(event.getPlayer())){
				if(((LivingEntity) event.getRightClicked()).hasPotionEffect(PotionEffectType.SLOW)){
					((LivingEntity) event.getRightClicked()).removePotionEffect(PotionEffectType.SLOW);
					ChatUtilities.sendMessage(event.getPlayer(), "Entity Can Move!");
				}else
					if(NpcSlow.slowing.contains(event.getPlayer())){
							((LivingEntity) event.getRightClicked()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 72000, 5));
							Entity entity = ((CraftEntity)event.getRightClicked()).getHandle();
							entity.k = false;
							entity.g(0, 0, 0);
							entity.getBoundingBox().shrink(0, 0, 0);


							ChatUtilities.sendMessage(event.getPlayer(), "Entity Can No Longer Move!");
					}
		}
	}

}
