package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenforestMelynchRockPick extends WorldGenerator {

	private IBlockState ROCK = BlockInit.ROCK.getDefaultState();

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (!worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
					return false;
				}
			}
		}

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				for (int k = 1; k < 8; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)) != Blocks.AIR.getDefaultState()) {
						return false;
					}
				}
			}
		}
		
		
		generatePick(worldIn, rand, position, 3, 4);
		generatePick(worldIn, rand, position.west(), 1, 3);
		generatePick(worldIn, rand, position.east(), 1, 3);
		generatePick(worldIn, rand, position.south(), 1, 3);
		generatePick(worldIn, rand, position.north(), 1, 3);

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (rand.nextInt(5) == 0 && worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()
						&& !worldIn.getBlockState(position.add(i, 0, j)).isFullBlock()) {
					worldIn.setBlockState(position.add(i, 0, j), ROCK);
				}
			}
		}

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (rand.nextInt(5) == 0 && worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()) {
					worldIn.setBlockState(position.add(i, -1, j), ROCK);
				}
			}
		}

		return true;
	}

	private void generatePick(World worldIn, Random rand, BlockPos position, int minSize, int randnb) {
		boolean reachStone = false;
		int y = rand.nextInt(randnb) + minSize;

		while (!reachStone) {
			worldIn.setBlockState(position.add(0, y, 0), ROCK);

			if (worldIn.getBlockState(position.add(0, y - 1, 0)) == ROCK) {
				reachStone = true;
			}

			y--;

		}
	}

}
