package gosynmod.common.world.biomes.stage1.biomeMelynchForest;

import java.util.Random;

import gosynmod.common.world.biomes.base.BiomeStage1Base;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BiomeMelynchForest extends BiomeStage1Base {

	private GenForestMelynchSmallTree SMALL_TREE = new GenForestMelynchSmallTree();
	private GenForestMelynchBigTree BIG_TREE = new GenForestMelynchBigTree();
	private GenforestMelynchRockPick ROCK = new GenforestMelynchRockPick();
	private GenForestMelynchGroundDecorator GROUND = new GenForestMelynchGroundDecorator();
	private GenForestMelynchPlantsDecorator PLANTS = new GenForestMelynchPlantsDecorator();

	public BiomeMelynchForest() {
		super("Melynch Forest", 0.1f, 1f, 4021417);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {

		Chunk chunk = worldIn.getChunkFromBlockCoords(pos);
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				int x = chunk.x * 16 + i + 8;
				int z = chunk.z * 16 + j + 8;
				GROUND.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
				PLANTS.generate(worldIn, rand, worldIn.getHeight(new BlockPos(x, 0, z)));
			}
		}

		for (int i = 0; i < 6; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			BIG_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}

		for (int i = 0; i < 10; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			SMALL_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}
		if (rand.nextBoolean()) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			ROCK.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}

	}

}
