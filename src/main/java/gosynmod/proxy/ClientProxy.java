package gosynmod.proxy;

import gosynmod.client.particles.ParticleLeaf;
import gosynmod.client.particles.ParticlesVortex;
import gosynmod.common.Reference;
import gosynmod.common.interfaces.ParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {

		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}

	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().world;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void spawnParticle(World world, ParticleTypes particleType, double x, double y, double z, double velX, double velY, double velZ) {
		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.getRenderViewEntity();
		world = this.getClientWorld();

		if (entity != null && mc.effectRenderer != null) {
			int i = mc.gameSettings.particleSetting;

			if (i == 1 && world.rand.nextInt(3) == 0) {
				i = 2;
			}

			double d0 = entity.posX - x;
			double d1 = entity.posY - y;
			double d2 = entity.posZ - z;

			if (d0 * d0 + d1 * d1 + d2 * d2 <= 1024D && i <= 1) {
				Particle particle = null;

				switch (particleType) {
				case VORTEX:
					particle = new ParticlesVortex(world, x, y, z, velX, velY, velZ);
					break;
				case FALLING_LEAF:
					particle = new ParticleLeaf(world, x, y, z, velX, velY, velZ);
					
				}

				if (particle != null) {
					mc.effectRenderer.addEffect(particle);
				}
			}
		}
	}

}