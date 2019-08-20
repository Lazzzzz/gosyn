package gosynmod.common.world.biomes.stage2.CorruptedGrave;

import java.util.Random;

import gosynmod.common.init.BiomeInit;
import gosynmod.common.init.BlockInit;
import gosynmod.common.util.jar.getFloorHeight;
import gosynmod.common.world.biomes.base.BiomeStage2Base;
import gosynmod.common.world.gen.stage2.structures.GenSpiritDungeon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeCorruptedGrave extends BiomeStage2Base {
	private GenSpiritDungeon DUNGEON = new GenSpiritDungeon();

	public BiomeCorruptedGrave() {
		super("Corrupted Grave", 0.2F, 1F);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
	}

}
