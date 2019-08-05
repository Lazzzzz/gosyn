package gosynmod.common.world.biomes.stage2.MagicForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMagicForestPlantsDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (worldIn.getBlockState(pos.down()) == BlockInit.CRESEOL_GRASS.getDefaultState()) {
			if (rand.nextInt(3) == 0) {

				int i = rand.nextInt(6);
				if (i > 4)
					worldIn.setBlockState(pos, BlockInit.CRESEOL_SGRASS.getDefaultState());
				if (i == 0)
					worldIn.setBlockState(pos, BlockInit.CRESEOL_FERN.getDefaultState());
			}
		}
		return true;
	}
}
