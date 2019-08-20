package gosynmod.common.world.gen.stage2.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenStructureStage2{
	public static final GenSpiritDungeon SPIRIT_DUNGEON = new GenSpiritDungeon();

	public void generateStructure(WorldGenerator generator, World world, Random random, int x, int z,
			int chance, int offset, Block topBlock, Class<?>... classes) {
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int y = calculateGenerationHeight(world, x, z, topBlock) + offset;
		BlockPos pos = new BlockPos(x, y, z);

		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if (classesList.contains(biome)) {
			if (random.nextInt(chance) == 0) {
				if (y < 210 && y > 10) {
					generator.generate(world, random, pos);
				}
			}
		}
	}

	public static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
		int y = world.getHeight();
		boolean foundGround = false;

		while (!foundGround && y-- >= 0) {
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == topBlock;
		}

		return y;
	}
}