package gosynmod.common.world.biomes.stage2.MagicForest;

import java.util.Random;

import gosynmod.common.init.BiomeInit;
import gosynmod.common.util.jar.getFloorHeight;
import gosynmod.common.world.biomes.base.BiomeStage2Base;
import gosynmod.common.world.gen.stage2.structures.GenSpiritDungeon;
import gosynmod.common.world.gen.stage2.structures.GenVortexTemple;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BiomeMagicForest extends BiomeStage2Base {
	private GenMagicForestGroundDecorator GROUND = new GenMagicForestGroundDecorator();
	private GenMagicForestPlantsDecorator PLANTS = new GenMagicForestPlantsDecorator();

	private GenMagicForestBigTree BIG_TREE = new GenMagicForestBigTree();
	private GenMagicForestTree TREE = new GenMagicForestTree();

	private GenVortexTemple VORTEX = new GenVortexTemple();
	private GenSpiritDungeon DUNGEON = new GenSpiritDungeon();
	
	public BiomeMagicForest() {
		super("Magic Forest", 0F, 1F);

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

		for (int i = 0; i < 4; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			BIG_TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}

		for (int i = 0; i < 8; i++) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			TREE.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));

		}
		
		generateDungeon(worldIn, rand, pos);
		
		if (rand.nextInt(100) == 0) {
			int j = rand.nextInt(16) + 8;
			int k = rand.nextInt(16) + 8;
			VORTEX.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
		}
		
	}
	
	private void generateDungeon(World worldIn, Random rand, BlockPos pos) {
		if (rand.nextInt(250) == 0) {
			boolean flag = true;

			for (int i = -32; i < 48; i += 16) {
				for (int j = -32; j < 48; j += 16) {
					if (worldIn.getBiome(pos.add(i, 0, j)) != BiomeInit.MAGIC_FOREST) {
						flag = false;
					}
				}
			}
			

			if (flag) {
				int j = 8;
				int k = 8;
				BlockPos p = pos.add(j, 0, k);
				int y = getFloorHeight.calculateGenerationHeight(worldIn, p.getX(), p.getZ(),
						this.fillerBlock.getBlock());
				p = new BlockPos(p.getX(), y, p.getZ());
				DUNGEON.generate(worldIn, rand, p);
			}
		}

	}

}
