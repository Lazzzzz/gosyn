package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;

public class GenWetLandTree extends WorldGenAbstractTree {

	private Block LOG = BlockInit.MELYNCH_BARK;
	private Block LEAVES = BlockInit.MELYNCH_LEAVES;

	public GenWetLandTree() {
		super(true);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		int size = rand.nextInt(3) + 3;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (!worldIn.getBlockState(pos.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 1; k < size; k++) {
					if (worldIn.getBlockState(pos.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}
		generateLeavesNode(worldIn, rand, pos.add(0, size - 1, 0));

		for (int i = 0; i < size; i++) {
			worldIn.setBlockState(pos.add(0, i, 0), LOG.getDefaultState());
		}

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(1, i, 0), LOG.getDefaultState());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(-1, i, 0), LOG.getDefaultState());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(0, i, -1), LOG.getDefaultState());
		}
		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(0, i, 1), LOG.getDefaultState());
		}

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (worldIn.getBlockState(pos.add(i, -1, j)).isFullBlock() && rand.nextInt(3) == 0) {
					worldIn.setBlockState(pos.add(i, -1, j), LOG.getDefaultState());
				}
			}
		}

		return false;
	}

	private void generateLeavesNode(World worldIn, Random rand, BlockPos pos) {
		setBlockAndNotifyAdequately(worldIn, pos.up(), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.add(-1, 1, 0), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.add(1, 1, 0), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.add(0, 1, -1), LEAVES.getDefaultState());
		setBlockAndNotifyAdequately(worldIn, pos.add(0, 1, 1), LEAVES.getDefaultState());

		for (int y = 0; y > -2; --y) {
			for (int x = -2; x < 3; ++x) {
				for (int z = -1; z < 2; ++z) {
					if (x != 0 || z != 0) {
						setBlockAndNotifyAdequately(worldIn, pos.add(x, y, z), LEAVES.getDefaultState());
					}
				}

				if (Math.abs(x) < 2) {
					setBlockAndNotifyAdequately(worldIn, pos.add(x, y, -2), LEAVES.getDefaultState());
					setBlockAndNotifyAdequately(worldIn, pos.add(x, y, 2), LEAVES.getDefaultState());
				}
			}
		}
	}

}
