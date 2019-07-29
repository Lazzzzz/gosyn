package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenWetLandCattailsDecorator extends WorldGenerator {

	private int radius = 4;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		this.radius = 6;

		for (int i = -rand.nextInt(radius) - 1; i <= rand.nextInt(radius) + 1; i++) {
			for (int j = -rand.nextInt(radius) - 1; j <= rand.nextInt(radius) + 1; j++) {

				BlockPos p = worldIn.getHeight(pos.add(i, 0, j));
				if (worldIn.getBlockState(p.down()) == BlockInit.MUD.getDefaultState()) {
					if (worldIn.getBlockState(p.west().down()) == Blocks.WATER.getDefaultState()
							|| worldIn.getBlockState(p.east().down()) == Blocks.WATER.getDefaultState()
							|| worldIn.getBlockState(p.south().down()) == Blocks.WATER.getDefaultState()
							|| worldIn.getBlockState(p.north().down()) == Blocks.WATER.getDefaultState()) {
						if (rand.nextBoolean())
							worldIn.setBlockState(p, BlockInit.SMALL_CATTAILS.getDefaultState());
						else {
							worldIn.setBlockState(p, BlockInit.TALL_CATTAILS.getDefaultState());
							worldIn.setBlockState(p.up(), BlockInit.TALL_CATTAILS.getStateFromMeta(1));
						}

					} else {
						if (rand.nextInt(20) == 0)
							worldIn.setBlockState(p, BlockInit.MUD_SHORTGRASS.getDefaultState());
					}

				}
			}
		}

		return true;
	}
}
