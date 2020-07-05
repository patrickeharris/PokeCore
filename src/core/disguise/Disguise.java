package core.disguise;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.EntityBat;
import net.minecraft.server.v1_8_R1.EntityBlaze;
import net.minecraft.server.v1_8_R1.EntityCaveSpider;
import net.minecraft.server.v1_8_R1.EntityChicken;
import net.minecraft.server.v1_8_R1.EntityCow;
import net.minecraft.server.v1_8_R1.EntityCreeper;
import net.minecraft.server.v1_8_R1.EntityEnderDragon;
import net.minecraft.server.v1_8_R1.EntityEnderman;
import net.minecraft.server.v1_8_R1.EntityGhast;
import net.minecraft.server.v1_8_R1.EntityGiantZombie;
import net.minecraft.server.v1_8_R1.EntityHorse;
import net.minecraft.server.v1_8_R1.EntityIronGolem;
import net.minecraft.server.v1_8_R1.EntityLiving;
import net.minecraft.server.v1_8_R1.EntityMagmaCube;
import net.minecraft.server.v1_8_R1.EntityMushroomCow;
import net.minecraft.server.v1_8_R1.EntityOcelot;
import net.minecraft.server.v1_8_R1.EntityPig;
import net.minecraft.server.v1_8_R1.EntityPigZombie;
import net.minecraft.server.v1_8_R1.EntitySheep;
import net.minecraft.server.v1_8_R1.EntitySilverfish;
import net.minecraft.server.v1_8_R1.EntitySkeleton;
import net.minecraft.server.v1_8_R1.EntitySlime;
import net.minecraft.server.v1_8_R1.EntitySnowman;
import net.minecraft.server.v1_8_R1.EntitySpider;
import net.minecraft.server.v1_8_R1.EntitySquid;
import net.minecraft.server.v1_8_R1.EntityVillager;
import net.minecraft.server.v1_8_R1.EntityWitch;
import net.minecraft.server.v1_8_R1.EntityWither;
import net.minecraft.server.v1_8_R1.EntityWolf;
import net.minecraft.server.v1_8_R1.EntityZombie;
import net.minecraft.server.v1_8_R1.PacketPlayOutEntity;
import net.minecraft.server.v1_8_R1.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntity;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;

public class Disguise {

	public static void playerAsMob(Player toHide, EntityType mob, Player... canSee) {
		        EntityLiving toSpawn = null;
		        if (mob.equals(EntityType.BAT)){
		            toSpawn = new EntityBat(((CraftPlayer) toHide).getHandle().world);
		        }
		        if (mob.equals(EntityType.BLAZE)){
		            toSpawn = new EntityBlaze(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.CAVE_SPIDER)){

		            toSpawn = new EntityCaveSpider(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.CHICKEN)){

		            toSpawn = new EntityChicken(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.COW)){

		            toSpawn = new EntityCow(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.CREEPER)){

		            toSpawn = new EntityCreeper(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.ENDER_DRAGON)){

		            toSpawn = new EntityEnderDragon(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.ENDERMAN)){

		            toSpawn = new EntityEnderman(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.GHAST)){

		            toSpawn = new EntityGhast(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.GIANT)){

		            toSpawn = new EntityGiantZombie(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.HORSE)){

		            toSpawn = new EntityHorse(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.IRON_GOLEM)){

		            toSpawn = new EntityIronGolem(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.MAGMA_CUBE)){

		            toSpawn = new EntityMagmaCube(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.MUSHROOM_COW)){

		            toSpawn = new EntityMushroomCow(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.OCELOT)){

		            toSpawn = new EntityOcelot(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.PIG)){

		            toSpawn = new EntityPig(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.PIG_ZOMBIE)){

		            toSpawn = new EntityPigZombie(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SHEEP)){

		            toSpawn = new EntitySheep(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SILVERFISH)){

		            toSpawn = new EntitySilverfish(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SKELETON)){

		            toSpawn = new EntitySkeleton(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SLIME)){

		            toSpawn = new EntitySlime(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SNOWMAN)){

		            toSpawn = new EntitySnowman(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SPIDER)){

		            toSpawn = new EntitySpider(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.SQUID)){

		            toSpawn = new EntitySquid(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.VILLAGER)){

		            toSpawn = new EntityVillager(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.WITCH)){

		            toSpawn = new EntityWitch(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.WITHER)){

		            toSpawn = new EntityWither(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (mob.equals(EntityType.WOLF)){

		            toSpawn = new EntityWolf(((CraftPlayer) toHide).getHandle().world);

		        }
 		        if (mob.equals(EntityType.ZOMBIE)){

		            toSpawn = new EntityZombie(((CraftPlayer) toHide).getHandle().world);

		        }

		        if (toSpawn == null) {

		            throw new IllegalArgumentException("Mob must be living entity other than a player. Provided: " + mob.toString());

		        }

		        toSpawn.locX = toHide.getLocation().getX();

		        toSpawn.locY = toHide.getLocation().getY();

		        toSpawn.locZ = toHide.getLocation().getZ();
		        for (Player a : Bukkit.getOnlinePlayers()) {

		            if (a.equals(toHide)) {

		                continue;

		            }

		            for (Player b : canSee) {

		                if (a.equals(b)) {

		                continue;

		                }

		            }

		            ((CraftPlayer)a).getHandle().playerConnection.sendPacket(new PacketPlayOutSpawnEntityLiving(toSpawn));

		        }

		    }

		 

		    public static void playerBackToPlayer(Player toShow, Player... cantSee) {

		        for (Player a : Bukkit.getOnlinePlayers()) {

		            if (a.equals(toShow)) {
                continue;
            }
            for (Player b : cantSee) {
                if (a.equals(b)) {
                    continue;
                }
            }
            ((CraftPlayer)a).getHandle().playerConnection.sendPacket(new PacketPlayOutNamedEntitySpawn(((CraftPlayer)toShow).getHandle()));
        }
    }


}
