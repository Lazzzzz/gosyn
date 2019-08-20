package gosynmod.common.dimension;

import gosynmod.common.init.BiomeInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesGosyn extends GenLayer {

	private Biome[] allowedBiomes = 
	{ 
			//STAGE 1
			BiomeInit.FLORY, 
			BiomeInit.WET_LANDS,
			BiomeInit.MELYNCH_FOREST,
			
			//STAGE 2
			BiomeInit.MAGIC_FOREST,
			BiomeInit.MUSHROOOM,
			BiomeInit.CORRUPTED,
			
			//STAGE 3
			BiomeInit.DARK_FOREST 
			
	};

	public GenLayerBiomesGosyn(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = Biome.getIdForBiome(this.allowedBiomes[nextInt(this.allowedBiomes.length)]);
			}
		}
		return dest;
	}
}
