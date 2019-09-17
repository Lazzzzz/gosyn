package gosynmod.common.dimension;

import gosynmod.common.init.DimensionInit;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;

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
		return new ChunkTemplate(world, this.world.getSeed());
	}

	@Override
	public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
		return WorldSleepResult.ALLOW;
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
    public boolean isSurfaceWorld()
    {
    	return true;
    }
    
    
    @Override
    public float getStarBrightness(float par1) {
    	return 1F;
    }
    
    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
    	return 0.5f;
    }

    @Override
    public IRenderHandler getSkyRenderer() {
    	return super.getSkyRenderer();
    }
    
    @Override
    public float getCloudHeight() {
    	return 100F;
    }
    
    
    
}
