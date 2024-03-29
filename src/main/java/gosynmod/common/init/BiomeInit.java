package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.world.biomes.stage1.biomeFlory.BiomeFlory;
import gosynmod.common.world.biomes.stage1.biomeMelynchForest.BiomeMelynchForest;
import gosynmod.common.world.biomes.stage1.biomeWetLands.BiomeWetlands;
import gosynmod.common.world.biomes.stage2.MagicForest.BiomeMagicForest;
import gosynmod.common.world.biomes.stage2.Mushrooom.BiomeMushrooom;
import gosynmod.common.world.biomes.stage2.RootForest.BiomeRootForest;
import gosynmod.common.world.biomes.stage3.BiomeDarkForest;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	
	public static final Biome FLORY 		 = new BiomeFlory();
	public static final Biome WET_LANDS 	 = new BiomeWetlands();
	public static final Biome MELYNCH_FOREST = new BiomeMelynchForest();
	
	public static final Biome MAGIC_FOREST = new BiomeMagicForest();
	public static final Biome MUSHROOOM    = new BiomeMushrooom();
	public static final Biome ROOT_FOREST  = new BiomeRootForest();
	
	public static final Biome DARK_FOREST = new BiomeDarkForest();

	public static final List<Biome> biomesSpawn = new ArrayList<>();	

	public static void registerBiomes() {
		initBiomeNoOverworld(FLORY, "Flory", BiomeType.COOL, Type.PLAINS, Type.RARE);
		initBiomeNoOverworld(WET_LANDS, "Wet Lands", BiomeType.WARM, Type.SWAMP, Type.RARE);
		initBiomeNoOverworld(MELYNCH_FOREST, "Melynch Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		
		initBiomeNoOverworld(MAGIC_FOREST, "Magic Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		initBiomeNoOverworld(MUSHROOOM, "Mushrooom", BiomeType.COOL, Type.FOREST, Type.RARE);
		initBiomeNoOverworld(ROOT_FOREST, "Root Forest", BiomeType.COOL, Type.PLAINS, Type.RARE);
	
		initBiomeNoOverworld(DARK_FOREST, "Dark Forest", BiomeType.WARM, Type.FOREST, Type.RARE);
		
		biomesSpawn.add(FLORY);
		biomesSpawn.add(WET_LANDS);
		biomesSpawn.add(MELYNCH_FOREST);
		
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
