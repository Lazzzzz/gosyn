package gosynmod.common.world.biomes.base;

import gosynmod.common.init.BlockInit;
import net.minecraft.world.biome.Biome;

public class BiomeStage2Base extends Biome {

	public BiomeStage2Base(String name, float setHeightVariation, float setTemperature) {

		super(new BiomeProperties(name).setBaseHeight(0.2F).setHeightVariation(setHeightVariation)
				.setTemperature(setTemperature).setRainDisabled().setWaterColor(5691638));

		topBlock = BlockInit.CRESEOL_GRASS.getDefaultState();
		fillerBlock = BlockInit.DIRT.getDefaultState();

		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();

	}

}
