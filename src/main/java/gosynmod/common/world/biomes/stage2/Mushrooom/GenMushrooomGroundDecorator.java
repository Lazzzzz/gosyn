package gosynmod.common.world.biomes.stage2.Mushrooom;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenMushrooomGroundDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == BlockInit.CRESEOL_GRASS.getDefaultState()) {
			if (rand.nextInt(10) == 0) worldIn.setBlockState(pos, BlockInit.ROCK.getDefaultState());
		}
		return true;
	}

}
