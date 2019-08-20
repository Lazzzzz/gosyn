package gosynmod.common.util.jar;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SetLoot {

	private final ItemStack item;
	private final int chance;

	public SetLoot(Item item, int chance, int amount) {
		this.item = new ItemStack(item, new Random().nextInt(amount) + 1);
		this.chance = chance;
	}

	public SetLoot(Block block, int chance, int amount) {
		this.item = new ItemStack(block, new Random().nextInt(amount) + 1);
		this.chance = chance;

	}

	public void isPick(World worldIn, Random rand, BlockPos pos) {
		if (!worldIn.isRemote) {
			if (rand.nextInt(101) < this.chance) {
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), this.item));

			}

		}
	}

}

