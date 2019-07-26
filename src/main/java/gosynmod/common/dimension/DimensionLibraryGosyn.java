package gosynmod.common.dimension;

import gosynmod.common.init.DimensionInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProvider.WorldSleepResult;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibraryGosyn extends WorldProvider {

	@Override
	public void init() {
		this.hasSkyLight = true;
		this.biomeProvider = new BiomeProviderGosyn(this.world.getSeed());
	}

	public DimensionType getDimensionType() {
		return DimensionInit.GOSYN;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkTemplate(world, world.rand.nextLong());
	}

	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
    public boolean isSurfaceWorld()
    {
    	return true;
    }

    
    
    
}
