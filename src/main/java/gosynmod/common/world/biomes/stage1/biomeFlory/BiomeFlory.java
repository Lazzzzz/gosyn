package gosynmod.common.world.biomes.stage1.biomeFlory;

import java.util.Random;

import gosynmod.common.world.biomes.base.BiomeStage1Base;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BiomeFlory extends BiomeStage1Base {

	private GenFloryGroundDecorator GROUND = new GenFloryGroundDecorator();
	private GenFloryPlantsDecorator PLANT  = new GenFloryPlantsDecorator();
	
	private GenFloryBush 	BUSH = new GenFloryBush();
	private GenFloryBoulder BOULDER = new GenFloryBoulder();
	
	public BiomeFlory() {
		super("Flory", 0.025f, 1f, 1594950);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		
		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				GROUND.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
				PLANT.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
			}
		}
		
		for (int i = 0; i < 2; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			BUSH.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}

		
		if (rand.nextInt(8) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			BOULDER.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}
	}
}
