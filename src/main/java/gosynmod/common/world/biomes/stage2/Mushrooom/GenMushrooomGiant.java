package gosynmod.common.world.biomes.stage2.Mushrooom;

import java.util.Random;

import com.sun.jna.platform.win32.WinDef.WPARAM;

import gosynmod.common.init.BlockInit;
import io.netty.util.internal.MathUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMushrooomGiant extends WorldGenerator {

	private IBlockState STEM = BlockInit.MUSHROOOM_STEM.getDefaultState();
	private IBlockState CUP = BlockInit.MUSHROOOM_CAP.getDefaultState();

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		int size = rand.nextInt(6) + 15;
		
		for (int i = -3; i < 4; i++) {
			for (int j = -3; j < 4; j++) {
				if (!worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}
		
		for (int i = -3; i < 4; i++) {
			for (int j = -3; j < 4; j++) {
				for (int k = 1; k < 4; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}

		for (int i = -7; i < 8; i++) {
			for (int j = -7; j < 8; j++) {
				for (int k = -6; k < 4; k++) {
					if (worldIn.getBlockState(position.add(i, k+size, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}
		
		generateStem(worldIn, rand, position, size);

		return false;
	}

	private void generateStem(World worldIn, Random rand, BlockPos position, int size) {
		for (int i = 0; i < size; i++) {
			worldIn.setBlockState(position.add(-1, i, 0), STEM);
			worldIn.setBlockState(position.add(1, i, 0), STEM);
			worldIn.setBlockState(position.add(0, i, -1), STEM);
			worldIn.setBlockState(position.add(0, i, 1), STEM);

		}

		int sizeStem = rand.nextInt(5) + 5;

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 0; k < sizeStem; k++) {
					worldIn.setBlockState(position.add(i, k, j), STEM);
				}
			}
		}

		for (int i = 0; i < Math.min(rand.nextInt(4) + 5, sizeStem); i++) {
			worldIn.setBlockState(position.add(-2, i, 0), STEM);
		}

		for (int i = 0; i < Math.min(rand.nextInt(4) + 5, sizeStem); i++) {
			worldIn.setBlockState(position.add(0, i, -2), STEM);
		}

		for (int i = 0; i < Math.min(rand.nextInt(4) + 5, sizeStem); i++) {
			worldIn.setBlockState(position.add(0, i, 2), STEM);
		}

		for (int i = 0; i < Math.min(rand.nextInt(4) + 5, sizeStem); i++) {
			worldIn.setBlockState(position.add(2, i, 0), STEM);
		}

		// CONTOUR

		for (int i = 0; i < Math.min(rand.nextInt(1) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(2, i, 1), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(1) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(2, i, -1), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(1) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(-2, i, 1), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(1) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(-2, i, -1), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(1) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(1, i, 2), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(2) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(-1, i, 2), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(2) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(1, i, -2), STEM);
		}
		for (int i = 0; i < Math.min(rand.nextInt(2) + 3, sizeStem); i++) {
			worldIn.setBlockState(position.add(-1, i, -2), STEM);
		}

		// CAP

		generateCap(worldIn, rand, position.up(size));

	}

	private void generateVine(World worldIn, Random rand, BlockPos position) {
		for (int i = 1; i < rand.nextInt(10) + 3; i++) {
			worldIn.setBlockState(position.down(i), CUP);

		}
	}

	private void generateCap(World worldIn, Random rand, BlockPos position) {
		generateCapLayer(worldIn, rand, position.up(1), CUP, 3);
		generateCapLayer(worldIn, rand, position, CUP, 5);
		int size1 = rand.nextInt(2) + 2;
		int size2 = rand.nextInt(2) + 5;

		for (int i = 1; i < size1; i++) {
			generateCapHollowLayer(worldIn, rand, position.down(i), CUP, 6);
		}
		for (int i = size1; i < size2; i++) {
			generateCapHollowLayer(worldIn, rand, position.down(i), CUP, 7);
		}

		for (int i = -7; i < 8; i++) {
			for (int j = -7; j < 8; j++) {
				IBlockState state1 = worldIn.getBlockState(position.add(i, -size2, j));
				IBlockState state2 = worldIn.getBlockState(position.add(i, -size2 + 1, j));
				if (state2 == CUP && state1 == Blocks.AIR.getDefaultState()) {
					if (worldIn.getBlockState(position.add(i, -size2, j).north()) == Blocks.AIR.getDefaultState()
					 && worldIn.getBlockState(position.add(i, -size2, j).south()) == Blocks.AIR.getDefaultState()
					 && worldIn.getBlockState(position.add(i, -size2, j).east()) == Blocks.AIR.getDefaultState()
					 && worldIn.getBlockState(position.add(i, -size2, j).west()) == Blocks.AIR.getDefaultState())

						if (rand.nextInt(5) == 0)
							generateVine(worldIn, rand, position.add(i, -size2 + 1, j));
				}

			}

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
		int width = radius - 2;
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
