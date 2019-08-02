package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenForestMelynchGroundDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == BlockInit.GRASS.getDefaultState() || ground == BlockInit.ROCK.getDefaultState()) {
			if (rand.nextInt(4) == 0) worldIn.setBlockState(pos, BlockInit.DIRTY_GRASS.getDefaultState());
		}
		return true;
	}

}
