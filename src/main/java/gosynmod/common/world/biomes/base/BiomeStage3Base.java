package gosynmod.common.world.biomes.base;

import gosynmod.common.init.BlockInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;

public class BiomeStage3Base extends Biome {

	public BiomeStage3Base(String name, float setHeightVariation, float setTemperature) {

		super(new BiomeProperties(name).setBaseHeight(-1.9F).setHeightVariation(setHeightVariation)
				.setTemperature(setTemperature).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.GRASS.getDefaultState();
		fillerBlock = BlockInit.DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

}
