package gosynmod.common.world.biomes.stage2.MagicForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMagicForestBigTree extends WorldGenerator {
	private Block LOG = BlockInit.CRESEOL_BARK;
	private Block LEAVES = BlockInit.CRESEOL_LEAVES;
	private int size;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.size = rand.nextInt(3) + 9;
		if (worldIn.getBlockState(position.down()).getMaterial() != Material.GROUND
				&& worldIn.getBlockState(position.down()).getMaterial() != Material.GRASS) return false;
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
		generateLeafNode(worldIn, rand, position.up(this.size + 1));
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
					int size2 = rand.nextInt(4) + 1;
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
						&& !worldIn.getBlockState(position.add(i, 0, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, 0, j), LEAVES.getDefaultState());
				}

				if (worldIn.getBlockState(position.add(i, -1, j)).isFullBlock() && rand.nextInt(5) == 0) {
					worldIn.setBlockState(position.add(i, -1, j),
							LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
				}

			}
		}

		// PLACE RUNES

		int size2 = rand.nextInt(4) + 3;
		if (worldIn.getBlockState(position.up(size2)).getBlock() == LOG && rand.nextInt(5) == 0) {
			if (worldIn.getBlockState(position.east().up(size2)) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(position.north().up(size2)) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(position.south().up(size2)) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(position.west().up(size2)) == Blocks.AIR.getDefaultState()) {

				switch (rand.nextInt(4)) {
				case 0:
					worldIn.setBlockState(position.up(size2), BlockInit.CRESEOL_RUNE1.getDefaultState());
					break;
				case 1:
					worldIn.setBlockState(position.up(size2), BlockInit.CRESEOL_RUNE2.getDefaultState());
					break;
				case 2:
					worldIn.setBlockState(position.up(size2), BlockInit.CRESEOL_RUNE3.getDefaultState());
					break;

				case 3:
					worldIn.setBlockState(position.up(size2), BlockInit.CRESEOL_RUNE4.getDefaultState());
					break;
				}

			}

		}

	}

	public void generateBranch(World worldIn, Random rand, BlockPos position) {

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (rand.nextBoolean()) {
					int diry = rand.nextInt(3) - 1;
					int size = rand.nextInt(3) + 2;
					int ofy = rand.nextInt(3) - 1;
					for (int k = 0; k < size; k++) {
						worldIn.setBlockState(position.add(i * k, diry * k + ofy, j * k),
								LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
						if (k == size - 1)
							this.generateLeafNode(worldIn, rand, position.add(i * k, diry * k + ofy, j * k));
					}
				}
			}
		}

	}

	public void generateLeafNode(World worldIn, Random rand, BlockPos position) {
		setBlockAndNotifyAdequately(worldIn, position.up(), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, position.add(-1, 1, 0), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, position.add(1, 1, 0), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, position.add(0, 1, -1), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, position.add(0, 1, 1), LEAVES.getDefaultState());

		for (int y = 0; y > -2; --y) {
			for (int x = -2; x < 3; ++x) {
				for (int z = -1; z < 2; ++z) {
					if (x != 0 || z != 0) {
						if (worldIn.getBlockState(position.add(x, y, z)) == Blocks.AIR.getDefaultState())
							setBlockAndNotifyAdequately(worldIn, position.add(x, y, z), LEAVES.getDefaultState());
					}
				}

				if (Math.abs(x) < 2) {
					if (worldIn.getBlockState(position.add(x, y, -2)) == Blocks.AIR.getDefaultState())
						setBlockAndNotifyAdequately(worldIn, position.add(x, y, -2), LEAVES.getDefaultState());
					if (worldIn.getBlockState(position.add(x, y, 2)) == Blocks.AIR.getDefaultState())
						setBlockAndNotifyAdequately(worldIn, position.add(x, y, 2), LEAVES.getDefaultState());

				}
			}
		}
	}

}
