package gosynmod.common.world.gen;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenGosynOre implements IWorldGenerator {

	private WorldGenerator ore_emcoel, ore_aiguite;

	public WorldGenGosynOre() {
		ore_emcoel = new WorldGenMinable(BlockInit.ORE_EMCOEL.getDefaultState(), 12,
				BlockMatcher.forBlock(BlockInit.ROCK));
		ore_aiguite = new WorldGenMinable(BlockInit.ORE_AIGUITE.getDefaultState(), 8,
				BlockMatcher.forBlock(BlockInit.ROCK));
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {
		case 130:
			runGenerator(ore_emcoel, world, random, chunkX, chunkZ, 30, 40, 256);
			runGenerator(ore_aiguite, world, random, chunkX, chunkZ, 30, 40, 100);
		}

	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance,
			int minHeight, int maxHeight) {

		if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256)
			throw new IllegalArgumentException("Ore generate out of bound");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(world, rand, new BlockPos(x, y, z));
		}

	}

}
