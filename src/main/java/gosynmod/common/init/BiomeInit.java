package gosynmod.common.init;

import gosynmod.common.handlers.ConfigHandler;
import gosynmod.common.world.biomes.stage1.biomeFlory.BiomeFlory;
import gosynmod.common.world.biomes.stage1.biomeWetLands.BiomeWetlands;
import gosynmod.common.world.biomes.stage2.BiomeDenseForest;
import gosynmod.common.world.biomes.stage3.BiomeDarkForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	public static final Biome FLORY 	= new BiomeFlory();
	public static final Biome WET_LANDS = new BiomeWetlands();
	
	public static final Biome DENSE_FOREST = new BiomeDenseForest();
	
	public static final Biome DARK_FOREST = new BiomeDarkForest();

	public static void registerBiomes() {
		initBiomeNoOverworld(FLORY, "Flory", BiomeType.COOL, Type.PLAINS, Type.RARE);
		initBiomeNoOverworld(WET_LANDS, "Wet Lands", BiomeType.WARM, Type.SWAMP, Type.RARE);
		
		initBiomeNoOverworld(DENSE_FOREST, "Dense Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
	
		initBiomeNoOverworld(DARK_FOREST, "Dark Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
	}

	private static Biome initBiomeNoOverworld(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Register " + name);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		System.out.println("Biome added " + name);
		return biome;
	}


}
