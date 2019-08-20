package gosynmod.common.world.biomes.stage2.Mushrooom;

import java.util.Random;

import gosynmod.common.world.biomes.base.BiomeStage2Base;
import gosynmod.common.world.biomes.stage2.MagicForest.GenMagicForestBigTree;
import gosynmod.common.world.biomes.stage2.MagicForest.GenMagicForestTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BiomeMushrooom extends BiomeStage2Base {

	private GenMushrooomGiant GIANT = new GenMushrooomGiant();
	private GenMushrooomMedium MEDIUM = new GenMushrooomMedium();
	private GenMushrooom NORMAL = new GenMushrooom();
	private GenMagicForestTree TREE = new GenMagicForestTree();
	private GenMagicForestBigTree BIG_TREE = new GenMagicForestBigTree();

	private GenMushrooomGroundDecorator GROUND = new GenMushrooomGroundDecorator();
	private GenMushrooomPlantsDecorator PLANTS = new GenMushrooomPlantsDecorator();

	public BiomeMushrooom() {
		super("Mushrooom", 0.01F, 1F);

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

		if (rand.nextInt(4) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			GIANT.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}

		if (rand.nextBoolean()) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			MEDIUM.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}
		
		for (int i = 0; i < 1; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
		for (int i = 0; i < 2; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			BIG_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}


		for (int i = 0; i < 3; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			NORMAL.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
	

	}

}
