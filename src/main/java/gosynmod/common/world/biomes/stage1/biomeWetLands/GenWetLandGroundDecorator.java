package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenWetLandGroundDecorator extends WorldGenerator {

	private int radius = 3; // radius

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		BlockPos pos = position.down();
		if (worldIn.getBlockState(pos) == Blocks.WATER.getDefaultState()) {
			for (int i = -rand.nextInt(3) - 1; i <= rand.nextInt(3) + 1; i++) {
				for (int j = -rand.nextInt(3) - 1; j <= rand.nextInt(3) + 1; j++) {
					for (int k = -rand.nextInt(3) - 1; k <= rand.nextInt(3) + 1; k++) {
						if (worldIn.getBlockState(pos.add(i, k, j)) == BlockInit.GRASS.getDefaultState()
								|| worldIn.getBlockState(pos.add(i, k, j)) == BlockInit.DIRT.getDefaultState()) {
							if (worldIn.getBlockState(pos.up()) != Blocks.WATER.getDefaultState())
								worldIn.setBlockState(pos.add(i, k, j), BlockInit.MUD.getDefaultState());
						}
					}

				}
			}

		}
		return true;
	}

}
