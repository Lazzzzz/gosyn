package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenForestMelynchBigTree extends WorldGenerator {
	private Block LOG = BlockInit.MELYNCH_BARK;
	private Block LEAVES = BlockInit.MELYNCH_LEAVES;
	private int size;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.size = rand.nextInt(4) + 8;

		if (worldIn.getBlockState(position.down()).getMaterial() != Material.GROUND
				&& worldIn.getBlockState(position.down()).getMaterial() != Material.GRASS) return false;

			for (int i = -2; i < 2; i++) {
				for (int j = -2; j < 2; j++) {
					if (!worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
						return false;
					}
				}
			}

		for (int i = -2; i < 2; i++) {
			for (int j = -2; j < 2; j++) {
				for (int k = 1; k < size; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}

		for (int i = -1; i < 1; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = -1; k < 1; k++) {
					worldIn.setBlockState(position.add(i, j, k), LOG.getDefaultState());
				}
			}
		}

		for (int i = -2; i < 2; i++) {
			for (int j = -2; j < 2; j++) {
				if ((!(i == 1 && j == 1)) && (!(i == -2 && j == 1)) && (!(i == -2 && j == -2))
						&& (!(i == 1 && j == -2)))
					for (int k = 0; k < rand.nextInt(3) + 1; k++) {
						worldIn.setBlockState(position.add(i, k, j), LOG.getDefaultState());
					}
			}
		}

		for (int i = -3; i < 3; i++) {
			for (int j = -3; j < 3; j++) {

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()
						&& !worldIn.getBlockState(position.add(i, 0, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, 0, j), LEAVES.getDefaultState());
				}

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, -1, j), LOG.getDefaultState());
				}

			}
		}

		generateLeavesNode(worldIn, rand, position.add(-1, 3, -1));

		return false;
	}

	private void generateLeavesNode(World worldIn, Random rand, BlockPos pos) {

		int leavesHeight = 8;

		if (size - leavesHeight >= leavesHeight - 3) {
			leavesHeight += 2;
		}

		for (int y = pos.getY() - leavesHeight + size; y <= pos.getY() + size; ++y) {
			int leaveNum = y - (pos.getY() + size);
			int leaveRange = 1 - leaveNum / (leavesHeight / 2 - 1);

			for (int x = pos.getX() - leaveRange + 1; x <= pos.getX() + leaveRange; ++x) {
				for (int z = pos.getZ() - leaveRange + 1; z <= pos.getZ() + leaveRange; ++z) {
					if (Math.abs(x - pos.getX()) != leaveRange || Math.abs(z - pos.getZ()) != leaveRange
							|| rand.nextInt(2) != 0 && leaveNum != 0) {
						BlockPos blockpos = new BlockPos(x, y, z);
						IBlockState state = worldIn.getBlockState(blockpos);
						Block block = state.getBlock();

						if ((block.isAir(state, worldIn, blockpos) || block.isLeaves(state, worldIn, blockpos)
								|| state.getMaterial() == Material.VINE) && rand.nextInt(12) != 0) {
							setBlockAndNotifyAdequately(worldIn, blockpos, LEAVES.getDefaultState());
						}
					}
				}
			}
		}

	}

}
