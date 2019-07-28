package gosynmod.common.world.biomes.stage1.biomeWetLands;

import java.util.Random;

import gosynmod.common.init.BiomeInit;
import gosynmod.common.world.biomes.base.BiomeStage1Base;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class BiomeWetlands extends BiomeStage1Base {

	private WorldGenLakes LAKES = new WorldGenLakes(Blocks.WATER);
	private GenWetLandGroundDecorator GROUND = new GenWetLandGroundDecorator();

	public BiomeWetlands() {
		super("Wet Lands", 0.005F, 1F);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {

		for (int i = 0; i < 5; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			if (worldIn.getBiome(worldIn.getHeight(pos.add(j, 0, k))) == BiomeInit.WET_LANDS) {
				LAKES.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
			}
		}

		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				GROUND.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
			}
		}

	}

}