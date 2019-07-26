package gosynmod.common.init;

import gosynmod.common.handlers.ConfigHandler;
import gosynmod.common.world.biomes.BiomeFlory;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit {
	public static final Biome FLORY = new BiomeFlory();

	public static void registerBiomes() {
		initBiomeNoOverworld(FLORY, "Flory", BiomeType.COOL, Type.PLAINS, Type.RARE);
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

	private static Biome initBiomeOverworld(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("Biome Register " + name);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 0));

		System.out.println("Biome added " + name);
		return biome;
	}

}
