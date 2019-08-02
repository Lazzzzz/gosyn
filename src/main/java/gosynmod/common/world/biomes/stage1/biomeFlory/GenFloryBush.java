package gosynmod.common.world.biomes.stage1.biomeFlory;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenFloryBush extends WorldGenerator {

	private IBlockState LOG = BlockInit.MELYNCH_BARK.getDefaultState();
	private IBlockState LEAVES = BlockInit.MELYNCH_LEAVES.getDefaultState();

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int size = rand.nextInt(3) + 1;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 1; k < size; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(position.add(0, i + size, 0), LEAVES);
		}
		worldIn.setBlockState(position.add(1,  size-1, 0),  LEAVES);
		worldIn.setBlockState(position.add(-1, size-1, 0),  LEAVES);
		worldIn.setBlockState(position.add(0,  size-1, 1),  LEAVES);
		worldIn.setBlockState(position.add(0,  size-1, -1), LEAVES);
		
		for (int i = 0; i < size; i++) {
			worldIn.setBlockState(position.add(0, i, 0), LOG);
		}

		return false;
	}

}
