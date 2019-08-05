package gosynmod.client.particles;

import gosynmod.common.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ParticlesVortex extends Particle {

	private int i;
	private int i2;

	public ParticlesVortex(World world, double x, double y, double z, double f, double f1, double f2) {
		this(world, x, y, z, 1.0F, f, f1, f2);
	}

	public ParticlesVortex(World world, double x, double y, double z, float f, double f1, double f2, double f3) {
		super(world, x, y, z, 0.0D, 0.0D, 0.0D);
		motionX = 0;
		motionY = 0.05f;
		motionZ = 0;
		particleRed = 1f;
		particleGreen = rand.nextFloat();
		particleBlue = 1F;
		particleScale = 0.3f + rand.nextFloat() / 5;
		particleScale *= f;
		i = particleMaxAge = 50 + rand.nextInt(51);
		particleMaxAge *= f;
		i2 = i / 2;
		canCollide = false;

		this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks()
				.getAtlasSprite(new ResourceLocation(Reference.MOD_ID, "particles/particle_vortex").toString()));
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entity, float partialTicks, float rotationX,
			float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {

		particleAlpha = getGlowBrightness();
		super.renderParticle(buffer, entity, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
	}

	@Override
	public void onUpdate() {
		this.motionX = MathHelper.sin(i * .4f) * .4;
		this.motionZ = MathHelper.cos(i * .4f) * .4;

		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (i <= 1) {
			setExpired();
		} else {
			this.posX += this.motionX;
			this.posY += this.motionY;
			this.posZ += this.motionZ;
			i--;
		}
	}

	public float getGlowBrightness() {
		return 1F;
	}

	@Override
	public int getBrightnessForRender(float partialTicks) {
		return 240;
	}

	@Override
	public int getFXLayer() {
		return 1;
	}

}