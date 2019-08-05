package gosynmod.common.event;

import java.util.Random;

import gosynmod.common.handlers.ConfigHandler;
import gosynmod.common.items.armor.ArmorGosyn;
import gosynmod.common.items.tools.base.ToolsGosynAxe;
import gosynmod.common.items.tools.base.ToolsGosynPickaxe;
import gosynmod.common.items.tools.base.ToolsGosynShovel;
import gosynmod.common.items.tools.base.ToolsGosynSword;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@EventBusSubscriber
public class EventItemDurability {

	private static Random rand = new Random();

	@SubscribeEvent
	public static void eventDurability(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		if (!player.world.isRemote) {
			if (player.dimension == ConfigHandler.DIMENSION_GOSYN_ID && player.ticksExisted % 20 == 0) {
				
				toolsDurabilityOffHand(player);
				
				for (int i = 0; i < 36; i++) {
					ItemStack item = player.inventory.getStackInSlot(i);
					// SWORD
					if (item.getItem() instanceof ItemSword && !(item.getItem() instanceof ToolsGosynSword)) {
						if (rand.nextBoolean())
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
					}

					// PICKAXE
					else if (item.getItem() instanceof ItemPickaxe && !(item.getItem() instanceof ToolsGosynPickaxe)) {
						if (rand.nextBoolean())
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
					}

					// SHOVEL
					else if (item.getItem() instanceof ItemSpade && !(item.getItem() instanceof ToolsGosynShovel)) {
						if (rand.nextBoolean())
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
					}

					// AXE
					else if (item.getItem() instanceof ItemTool && !(item.getItem() instanceof ToolsGosynAxe)) {
						if (rand.nextBoolean())
							item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
					}

				}
				// ARMOR
				ItemStack item = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean())
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean())
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean())
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				}

				item = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

				if (item.getItem() instanceof ItemArmor && !(item.getItem() instanceof ArmorGosyn)) {
					if (rand.nextBoolean())
						item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
				}

			}

		}

	}
	
	private static void toolsDurabilityOffHand(EntityPlayer player) {
		ItemStack item = player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
		// SWORD
		if (item.getItem() instanceof ItemSword && !(item.getItem() instanceof ToolsGosynSword)) {
			if (rand.nextBoolean())
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
		}

		// PICKAXE
		else if (item.getItem() instanceof ItemPickaxe && !(item.getItem() instanceof ToolsGosynPickaxe)) {
			if (rand.nextBoolean())
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
		}

		// SHOVEL
		else if (item.getItem() instanceof ItemSpade && !(item.getItem() instanceof ToolsGosynShovel)) {
			if (rand.nextBoolean())
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
		}

		// AXE
		else if (item.getItem() instanceof ItemTool && !(item.getItem() instanceof ToolsGosynAxe)) {
			if (rand.nextBoolean())
				item.damageItem(rand.nextInt(ConfigHandler.MAX_DAMAGE_TOOLS), player);
		}
	}

}
