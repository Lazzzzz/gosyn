package gosynmod.common.world.biomes.stage1.biomeFlory;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenFloryBoulder extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (rand.nextInt(3) == 0)
					bouleGenerate(worldIn, rand, position, BlockInit.ROCK, rand.nextInt(2) + 1);
			}
		}
		return true;
	}

	private boolean bouleGenerate(World worldIn, Random rand, BlockPos position, Block blocks, int startRadius) {
		{
			while (true) {
				label50: {
					if (position.getY() > 3) {
						if (worldIn.isAirBlock(position.down())) {
							break label50;
						}

						Block block = worldIn.getBlockState(position.down()).getBlock();

						if (block != BlockInit.GRASS && block != BlockInit.DIRT && block != BlockInit.ROCK
								&& block != BlockInit.DIRTY_GRASS) {
							break label50;
						}
					}

					if (position.getY() <= 3) {
						return false;
					}

					int i1 = startRadius;

					for (int i = 0; i1 >= 0 && i < 3; ++i) {
						int j = i1 + rand.nextInt(2);
						int k = i1 + rand.nextInt(2);
						int l = i1 + rand.nextInt(2);
						float f = (float) (j + k + l) * 0.333F + 0.5F;

						for (BlockPos blockpos : BlockPos.getAllInBox(position.add(-j, -k, -l),
								position.add(j, k, l))) {
							if (blockpos.distanceSq(position) <= (double) (f * f)) {
								worldIn.setBlockState(blockpos, blocks.getDefaultState());
							}
						}

						position = position.add(-(i1 + 1) + rand.nextInt(2 + i1 * 2), 0 - rand.nextInt(2),
								-(i1 + 1) + rand.nextInt(2 + i1 * 2));
					}

					return true;
				}
				position = position.down();
			}
		}
	}

}
