package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenForestMelynchSmallTree extends WorldGenerator {

	private Block LOG = BlockInit.MELYNCH_BARK;
	private Block LEAVES = BlockInit.MELYNCH_LEAVES;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		int size = rand.nextInt(4) + 5;

		
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
		
		
		generateLeavesNode(worldIn, rand, position.add(0, size, 0));

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) {
					for (int k = 0; k < size; k++) {
						worldIn.setBlockState(position.add(i, k, j), LOG.getDefaultState());
					}
				}

				else if (i == 0 || j == 0) {
					int size2 = rand.nextInt(2) + 1;
					for (int k = 0; k < size2; k++) {
						worldIn.setBlockState(position.add(i, k, j), LOG.getDefaultState());
					}
				}
				
			}
		}
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()
						&& !worldIn.getBlockState(position.add(i, 0, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, 0, j), LEAVES.getDefaultState());
				}
				
				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, -1, j), LOG.getDefaultState());
				}
				
				
			}
		}

		return false;
	}

	private void generateLeavesNode(World worldIn, Random rand, BlockPos pos) {
		for (int y = 0; y > -(rand.nextInt(3) + 2); --y) {
			for (int x = -1; x < 2; ++x) {
				for (int z = -1; z < 2; ++z) {
					if (x == 0 || z == 0) {
						setBlockAndNotifyAdequately(worldIn, pos.add(x, y, z), LEAVES.getDefaultState());
					}
				}
			}
		}

		for (int i = 0; i < rand.nextInt(3) + 1; i++) {
			setBlockAndNotifyAdequately(worldIn, pos.add(0, i + 1, 0), LEAVES.getDefaultState());
		}
	}

}
