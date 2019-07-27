package gosynmod.common.world.biomes.stage1;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import gosynmod.common.world.biomes.base.BiomeStage1Base;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class BiomeWetlands extends BiomeStage1Base {

	private WorldGenLakes LAKES = new WorldGenLakes(Blocks.WATER);

	public BiomeWetlands() {
		super("Wet Lands", 0.05F, 1F);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		for (int i = 0; i < 4; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			if (worldIn.getBiome(worldIn.getHeight(pos.add(j, 0, k))) == this) {
				LAKES.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}
		}
	}

}
