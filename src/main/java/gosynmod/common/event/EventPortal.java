package gosynmod.common.event;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventPortal {

	@SubscribeEvent
	public static void getItem(PlayerInteractEvent event) {
		if (!event.getWorld().isRemote) {
			EntityPlayer player = event.getEntityPlayer();
			BlockPos pos = event.getPos();
			Block block = event.getWorld().getBlockState(pos).getBlock();

			if (block == Blocks.STONEBRICK && player.getHeldItemMainhand().getItem() == Items.DIAMOND) {
				if (checkAndMakeXportal(player.world, pos)) {
					player.inventory.deleteStack(player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND));
				}
				else if (checkAndMakeZportal(player.world, pos)) {
					player.inventory.deleteStack(player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND));
				}
			}
		}
	}

	private static boolean checkAndMakeXportal(World worldIn, BlockPos postion) {
		for (int i = -2; i < 3; i++) {
			if (worldIn.getBlockState(postion.add(i, 0, 0)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(i, 4, 0)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(-2, i + 2, 0)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(2, i + 2, 0)).getBlock() != Blocks.STONEBRICK)
				return false;
		}

		for (int i = -2; i < 3; i++) {
			worldIn.setBlockState(postion.add(i, 0, 0), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(i, 4, 0), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(-2, i + 2, 0), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(2, i + 2, 0), BlockInit.CRESEOLBRICK.getDefaultState());
		}

		worldIn.setBlockState(postion.add(-2, 2, 0), BlockInit.CRESEOLBRICK.getStateFromMeta(2));
		worldIn.setBlockState(postion.add(2, 2, 0), BlockInit.CRESEOLBRICK.getStateFromMeta(2));
		worldIn.setBlockState(postion.add(0, 2, 0), BlockInit.GOSYN_PORTAL.getDefaultState());
		return true;
	}

	private static boolean checkAndMakeZportal(World worldIn, BlockPos postion) {
		for (int i = -2; i < 3; i++) {
			if (worldIn.getBlockState(postion.add(0, 0, i)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(0, 4, i)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(0, i + 2, -2)).getBlock() != Blocks.STONEBRICK)
				return false;
			if (worldIn.getBlockState(postion.add(0, i + 2, 2)).getBlock() != Blocks.STONEBRICK)
				return false;
		}

		for (int i = -2; i < 3; i++) {
			worldIn.setBlockState(postion.add(0, 0, i), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(0, 4, i), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(0, i + 2, -2), BlockInit.CRESEOLBRICK.getDefaultState());
			worldIn.setBlockState(postion.add(0, i + 2, 2), BlockInit.CRESEOLBRICK.getDefaultState());
		}

		worldIn.setBlockState(postion.add(0, 2, -2), BlockInit.CRESEOLBRICK.getStateFromMeta(2));
		worldIn.setBlockState(postion.add(0, 2, 2), BlockInit.CRESEOLBRICK.getStateFromMeta(2));
		worldIn.setBlockState(postion.add(0, 2, 0), BlockInit.GOSYN_PORTAL.getStateFromMeta(1));
		return true;
	}

}
