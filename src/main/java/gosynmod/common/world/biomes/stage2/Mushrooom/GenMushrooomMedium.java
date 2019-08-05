package gosynmod.common.world.biomes.stage2.Mushrooom;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMushrooomMedium extends WorldGenerator {

	private IBlockState STEM = BlockInit.MUSHROOOM_STEM.getDefaultState();
	private IBlockState CUP = BlockInit.MUSHROOOM_CAP.getDefaultState();

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int size = rand.nextInt(4) + 7;

		if (worldIn.getBlockState(position.down()) != BlockInit.CRESEOL_GRASS.getDefaultState()
				|| worldIn.getBlockState(position.down()) != BlockInit.ROCK.getDefaultState()) {
			return false;
		}

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

		generateStem(worldIn, rand, position, size);
		return false;
	}

	private void generateStem(World worldIn, Random rand, BlockPos position, int size) {
		int dirx = rand.nextInt(3) - 1;
		int dirz = rand.nextInt(3) - 1;
		int size1 = rand.nextInt(3) + 2;

		for (int i = 0; i < size1; i++) {
			worldIn.setBlockState(position.add(0, i, 0), STEM);
		}

		for (int i = size1 - 1; i < size - size1 + rand.nextInt(3) + 2; i++) {
			if (i < size - size1 + 1)
				worldIn.setBlockState(position.add(dirx, i, dirz), STEM);
			else
				worldIn.setBlockState(position.add(dirx, i, dirz), CUP);
		}
		int nsize = rand.nextInt(1) + 2;
		for (int i = 0; i < nsize; i++) {
			generateCapHollowLayer(worldIn, rand, position.add(dirx, size - i - 1, dirz), CUP, 1);
		}

		int nsize2 = rand.nextInt(2) + 2;
		for (int i = 0; i < nsize2; i++) {
			generateCapHollowLayer(worldIn, rand, position.add(dirx, size - i - 1 - nsize, dirz), CUP, 2);
		}

	}

	private void generateCapLayer(World worldIn, Random rand, BlockPos position, IBlockState block, int radius) {
		int width = radius;
		int i = width * width;

		for (int j = -width; j <= width; ++j) {
			for (int k = -width; k <= width; ++k) {
				for (int jj = -width + 1; jj <= width - 1; ++jj) {
					for (int kk = -width + 1; kk <= width - 1; ++kk) {
						if ((j * j + k * k <= i)) {
							BlockPos blockpos = position.add(j, 0, k);
							IBlockState state = worldIn.getBlockState(blockpos);

							if (state.getBlock().isAir(state, worldIn, blockpos)
									|| state.getBlock().isLeaves(state, worldIn, blockpos)) {
								this.setBlockAndNotifyAdequately(worldIn, blockpos, block);
							}
						}
					}
				}
			}
		}
	}

	private void generateCapHollowLayer(World worldIn, Random rand, BlockPos position, IBlockState block, int radius) {
		generateCapLayer(worldIn, rand, position, block, radius);
		int width = radius - 1;
		int i = width * width;

		for (int j = -width; j <= width; ++j) {
			for (int k = -width; k <= width; ++k) {
				for (int jj = -width + 1; jj <= width - 1; ++jj) {
					for (int kk = -width + 1; kk <= width - 1; ++kk) {
						if ((j * j + k * k <= i)) {
							BlockPos blockpos = position.add(j, 0, k);
							IBlockState state = worldIn.getBlockState(blockpos);

							if (state == block) {
								worldIn.setBlockToAir(blockpos);
							}
						}
					}
				}
			}
		}
	}

}
