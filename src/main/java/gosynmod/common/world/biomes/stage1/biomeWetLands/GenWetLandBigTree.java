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

public class GenWetLandBigTree extends WorldGenAbstractTree {

	private Block LOG = BlockInit.MELYNCH_BARK;
	private Block LEAVES = BlockInit.MELYNCH_LEAVES;

	public GenWetLandBigTree() {
		super(true);
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		for (int i = -3; i < 4; i++) {
			for (int j = -3; j < 4; j++) {
				if (!worldIn.getBlockState(pos.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}

		for (int i = -3; i < 4; i++) {
			for (int j = -3; j < 4; j++) {
				for (int k = 1; k < 10; k++) {
					if (worldIn.getBlockState(pos.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}

		generateTrunk(worldIn, rand, pos);
		generateRoot(worldIn, rand, pos);
		return false;
	}

	private void generateTrunk(World worldIn, Random rand, BlockPos pos) {
		int size = rand.nextInt(2) + 4;
		int size2 = size + rand.nextInt(2) + 3;

		for (int i = -2; i < 3; i++) {
			generateLeavesNode(worldIn, rand, pos.add(i, size2 - 1, 0));
			generateLeavesNode(worldIn, rand, pos.add(0, size2 - 1, i));

		}

		for (float i = -10; i < 10; i++) {
			int x = (int) (MathHelper.cos(i) * 3);
			int z = (int) (MathHelper.sin(i) * 3);
			worldIn.setBlockToAir(pos.add(x, size2 - 2, z));

		}

		for (int i = -5; i < 6; i++) {
			for (int j = -5; j < 6; j++) {
				if (worldIn.getBlockState(pos.add(i, size2 - 2, j)) == LEAVES.getDefaultState()) {
					int y = rand.nextInt(5);
					if (rand.nextInt(5) == 0) {
						for (int k = size2 - 3; k > size2 - 3 - y; k--) {
							if (worldIn.getBlockState(pos.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
								break;
							} else {
								setBlockAndNotifyAdequately(worldIn, pos.add(i, k, j), LEAVES.getDefaultState());
							}
						}
					}
				}

			}
		}

		// MAIN TRUNK

		for (int j = 0; j < size; j++) {

			for (int i = -1; i < 2; i++) {
				worldIn.setBlockState(pos.add(i, j, 2), LOG.getDefaultState());
				worldIn.setBlockState(pos.add(i, j, -2), LOG.getDefaultState());
				worldIn.setBlockState(pos.add(2, j, i),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));
				worldIn.setBlockState(pos.add(-2, j, i),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));
			}

		}

		for (int j = size; j < size2; j++) {

			worldIn.setBlockState(pos.add(0, j, 1), LOG.getDefaultState());
			worldIn.setBlockState(pos.add(0, j, -1), LOG.getDefaultState());
			worldIn.setBlockState(pos.add(-1, j, 0), LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));
			worldIn.setBlockState(pos.add(1, j, 0), LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z));

		}

		worldIn.setBlockState(pos.add(0, size2 - 1, 2), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(0, size2 - 1, -2), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(2, size2 - 1, 0), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(-2, size2 - 1, 0), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(1, size - 1, 1), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(1, size - 1, -1), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(-1, size - 1, -1), LOG.getDefaultState());
		worldIn.setBlockState(pos.add(-1, size - 1, 1), LOG.getDefaultState());

		// CORNER

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(2, i, 2), LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
		}

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(-2, i, 2), LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
		}

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(2, i, -2), LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
		}

		for (int i = 0; i < rand.nextInt(2) + 1; i++) {
			worldIn.setBlockState(pos.add(-2, i, -2),
					LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
		}

		// TRUNK SIDE

		generateTrunkSide(worldIn, rand, pos);

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

	private void generateRoot(World worldIn, Random rand, BlockPos pos) {

		for (float i = -10; i < 10; i += rand.nextInt(3) + 1) {
			int x = (int) (MathHelper.cos(i) * 5);
			int z = (int) (MathHelper.sin(i) * 5);
			worldIn.setBlockState(pos.add(x, 0, z), LOG.getDefaultState());

		}

		for (float i = -10; i < 10; i += rand.nextInt(3) + 1) {
			int x = (int) (MathHelper.cos(i) * 6);
			int z = (int) (MathHelper.sin(i) * 6);
			worldIn.setBlockState(pos.add(x, -1, z), LOG.getDefaultState());

		}

	}

	private void generateTrunkSide(World worldIn, Random rand, BlockPos pos) {

		for (int i = -1; i < 2; i++) {
			int size;
			if (i == 0)
				size = 3;
			else
				size = rand.nextInt(2) + 1;
			for (int j = 0; j < size; j++) {
				worldIn.setBlockState(pos.add(i, j, -3),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
				worldIn.setBlockState(pos.add(i, j, 3),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
				worldIn.setBlockState(pos.add(-3, j, i),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));
				worldIn.setBlockState(pos.add(3, j, i),
						LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));

			}

		}

	}

}
