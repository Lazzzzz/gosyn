package gosynmod.proxy;

import gosynmod.common.interfaces.ParticleTypes;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
	}

	public void spawnParticle(World world, ParticleTypes particleType, double x, double y, double z, double velX,
			double velY, double velZ) {
	}
	
}