package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenWetLandGroundDecorator extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		BlockPos pos = position.down();
		IBlockState ground = worldIn.getBlockState(pos);
		
		
		if (ground == Blocks.WATER.getDefaultState()) {
			for (int i = -rand.nextInt(4) - 1; i <= rand.nextInt(4) + 1; i++) {
				for (int j = -rand.nextInt(4) - 1; j <= rand.nextInt(4) + 1; j++) {
					for (int k = -rand.nextInt(4) - 1; k <= rand.nextInt(4) + 1; k++) {
						if (worldIn.getBlockState(pos.add(i, k, j)) == BlockInit.GRASS.getDefaultState()
								|| worldIn.getBlockState(pos.add(i, k, j)) == BlockInit.DIRT.getDefaultState()) {
							if (worldIn.getBlockState(pos.up()) != Blocks.WATER.getDefaultState())
								worldIn.setBlockState(pos.add(i, k, j), BlockInit.MUD.getDefaultState());
						}
					}

				}
			}

		}
		
		if (ground == BlockInit.GRASS.getDefaultState() || ground == BlockInit.ROCK.getDefaultState()) {
			if (rand.nextBoolean()) worldIn.setBlockState(pos, BlockInit.DIRTY_GRASS.getDefaultState());
		}
		return true;
	}

}
