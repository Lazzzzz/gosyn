package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenWetLandPlantsDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (worldIn.getBlockState(pos.down()) == BlockInit.GRASS.getDefaultState()
				|| worldIn.getBlockState(pos.down()) == BlockInit.DIRTY_GRASS.getDefaultState()) {
			if (rand.nextInt(5) == 0) {

				int i = rand.nextInt(4);
				if (i == 0)
					worldIn.setBlockState(pos, BlockInit.GENTIAN.getDefaultState());
				if (i == 1)
					worldIn.setBlockState(pos, BlockInit.TALL_GRASS.getDefaultState());
				if (i == 2)
					worldIn.setBlockState(pos, BlockInit.SLENDER_MONKEY.getDefaultState());
				if (i == 3)
					worldIn.setBlockState(pos, BlockInit.FALLEN_LEAVES.getDefaultState());
			}
		}
		return true;
	}
}