package gosynmod.common.world.biomes.stage2.MagicForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMagicForestTree extends WorldGenerator {
	private Block LOG = BlockInit.CRESEOL_BARK;
	private Block LEAVES = BlockInit.CRESEOL_LEAVES;
	private int size;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.size = rand.nextInt(3) + 3;

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (!worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				for (int k = 1; k < size; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}
		generateLeafNode(worldIn, rand, position.up(size - 2));
		generateTrunk(worldIn, rand, position);
		generateBranch(worldIn, rand, position.up(size));
		return false;
	}

	public void generateTrunk(World worldIn, Random rand, BlockPos position) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) {
					for (int k = 0; k < size; k++) {
						worldIn.setBlockState(position.up(k),
								LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
					}
				} else if (i == 0 || j == 0) {
					int size2 = rand.nextInt(2) + 1;
					for (int k = 0; k < size2; k++) {
						worldIn.setBlockState(position.add(i, k, j),
								LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
					}
				}

			}
		}

		// PLACE ROOT

		for (int i = -3; i < 4; i++) {
			for (int j = -3; j < 4; j++) {

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()
						&& !worldIn.getBlockState(position.add(i, 0, j)).isFullBlock() && rand.nextInt(8) == 0) {
					worldIn.setBlockState(position.add(i, 0, j), LEAVES.getDefaultState());
				}

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock() && rand.nextInt(8) == 0) {
					worldIn.setBlockState(position.add(i, -1, j),
							LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
				}

			}
		}

	}

	public void generateBranch(World worldIn, Random rand, BlockPos position) {

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (rand.nextInt(4) == 0) {
					int diry = rand.nextInt(3) - 1;
					int size = 2;
					for (int k = 0; k < size; k++) {
						worldIn.setBlockState(position.add(i * k, diry * k, j * k),
								LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
						if (k == size - 1)
							this.generateLeafNode(worldIn, rand, position.add(i * k, diry * k, j * k));
					}
				}
			}
		}

	}

	public void generateLeafNode(World worldIn, Random rand, BlockPos position) {
		for (int y = 0; y > -(rand.nextInt(3) + 2); --y) {
			for (int x = -1; x < 2; ++x) {
				for (int z = -1; z < 2; ++z) {
					if (x == 0 || z == 0) {
						if (worldIn.getBlockState(position.add(x, y, z)) == Blocks.AIR.getDefaultState())
							setBlockAndNotifyAdequately(worldIn, position.add(x, y, z), LEAVES.getDefaultState());
					}
				}
			}
		}

		for (int i = 0; i < rand.nextInt(3) + 1; i++) {
			if (worldIn.getBlockState(position.add(0, i + 1, 0)) == Blocks.AIR.getDefaultState())
				setBlockAndNotifyAdequately(worldIn, position.add(0, i + 1, 0), LEAVES.getDefaultState());
		}
	}

}
