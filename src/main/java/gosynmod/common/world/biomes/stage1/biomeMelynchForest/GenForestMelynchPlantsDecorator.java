package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenForestMelynchPlantsDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (worldIn.getBlockState(pos.down()) == BlockInit.GRASS.getDefaultState()
				|| worldIn.getBlockState(pos.down()) == BlockInit.DIRTY_GRASS.getDefaultState()) {
			if (rand.nextInt(7) == 0) {

				int i = rand.nextInt(8);
				if (i > 5)
					worldIn.setBlockState(pos, BlockInit.TALL_GRASS.getDefaultState());
				if (i == 0)
					worldIn.setBlockState(pos, BlockInit.GENTIAN.getDefaultState());
				if (i == 2)
					worldIn.setBlockState(pos, BlockInit.SLENDER_MONKEY.getDefaultState());
				if (i == 3)
					worldIn.setBlockState(pos, BlockInit.FALLEN_LEAVES.getDefaultState());
				if (i == 4)
					worldIn.setBlockState(pos, BlockInit.GALANGAL.getDefaultState());
				if (i == 5)
					worldIn.setBlockState(pos, BlockInit.GAZANIA.getDefaultState());
			}
		}
		return true;
	}
}
