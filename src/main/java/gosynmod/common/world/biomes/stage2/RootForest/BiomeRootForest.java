package gosynmod.common.world.biomes.stage2.RootForest;

import java.util.Random;

import gosynmod.common.world.biomes.base.BiomeStage2Base;
import gosynmod.common.world.gen.stage2.structures.GenSpiritDungeon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeRootForest extends BiomeStage2Base {
	private GenSpiritDungeon DUNGEON = new GenSpiritDungeon();

	public BiomeRootForest() {
		super("Root Forest", 0.2F, 1F);

	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
	}

}
