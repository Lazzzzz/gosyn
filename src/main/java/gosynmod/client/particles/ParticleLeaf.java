package gosynmod.client.particles;

import gosynmod.common.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ParticleLeaf extends Particle {
	private final ResourceLocation sprite = new ResourceLocation(Reference.MOD_ID,
			"textures/particles/particle_falling_leaf.png");

	private final float mulRotX;

	private final float mulRotY;

	private float prevRotX;

	private float prevRotY;

	private float rotX;

	private float rotY;

	public ParticleLeaf(World worldIn, double posXIn, double posYIn, double posZIn, double motionX, double motionY,
			double motionZ) {
		super(worldIn, posXIn, posYIn, posZIn);

		this.particleRed = 0.627f;
		this.particleGreen = 0.753f;
		this.particleBlue = 0.522f;

		this.motionY = motionY;
		this.motionX = motionX;
		this.motionZ = motionZ;

		this.mulRotY = (this.rand.nextFloat() * 100) * (float) (this.motionY);
		this.mulRotX = (this.rand.nextFloat() * 100) * (float) (this.motionY);

		this.particleMaxAge = 100;
		this.canCollide = false;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (motionY > -0.01f) setExpired();
		if (posX != prevPosX) {
			this.prevRotX = this.rotX;
			this.prevRotY = this.rotY;

			this.rotX += this.mulRotX;
			this.rotY += this.mulRotY;
		}else {
			setExpired();
		}
	}

	@Override
	public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX,
			float rotationZ, float rotationYZ, float rotationXY, float rotationXZ) {
		Minecraft.getMinecraft().renderEngine.bindTexture(this.sprite);

		GlStateManager.disableLighting();

		double x = this.prevPosX + (this.posX - this.prevPosX) * (double) partialTicks - interpPosX;
		double y = this.prevPosY + (this.posY - this.prevPosY) * (double) partialTicks - interpPosY;
		double z = this.prevPosZ + (this.posZ - this.prevPosZ) * (double) partialTicks - interpPosZ;

		int brightness = this.getBrightnessForRender(partialTicks);

		int j = brightness >> 16 & 65535;
		int k = brightness & 65535;

		float scale = 0.1F * this.particleScale;

		float f2 = this.prevRotX + ((this.rotX - this.prevRotX) * partialTicks);
		float f3 = this.prevRotY + ((this.rotY - this.prevRotY) * partialTicks);

		int i = 0;

		rotationX = MathHelper.cos(f3 * 0.017453292F) * (float) (1 - i * 2);
		rotationZ = MathHelper.sin(f3 * 0.017453292F) * (float) (1 - i * 2);

		rotationYZ = -rotationZ * MathHelper.sin(f2 * 0.017453292F) * (float) (1 - i * 2);
		rotationXY = rotationX * MathHelper.sin(f2 * 0.017453292F) * (float) (1 - i * 2);
		rotationXZ = MathHelper.cos(f2 * 0.017453292F);

		Vec3d[] avec3d = new Vec3d[] {
				new Vec3d((double) (-rotationX * scale - rotationXY * scale), (double) (-rotationZ * scale),
						(double) (-rotationYZ * scale - rotationXZ * scale)),
				new Vec3d((double) (-rotationX * scale + rotationXY * scale), (double) (rotationZ * scale),
						(double) (-rotationYZ * scale + rotationXZ * scale)),
				new Vec3d((double) (rotationX * scale + rotationXY * scale), (double) (rotationZ * scale),
						(double) (rotationYZ * scale + rotationXZ * scale)),
				new Vec3d((double) (rotationX * scale - rotationXY * scale), (double) (-rotationZ * scale),
						(double) (rotationYZ * scale - rotationXZ * scale)) };

		float a = 1.0f - (Math.max(0.0f, this.particleAge - 70.0f) * 0.03f);

		buffer.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
		buffer.pos(x + avec3d[0].x, y + avec3d[0].y, z + avec3d[0].z).tex(0.0D, 1.0D)
				.color(this.particleRed, this.particleGreen, this.particleBlue, a).lightmap(j, k).endVertex();
		buffer.pos(x + avec3d[1].x, y + avec3d[1].y, z + avec3d[1].z).tex(1.0D, 1.0D)
				.color(this.particleRed, this.particleGreen, this.particleBlue, a).lightmap(j, k).endVertex();
		buffer.pos(x + avec3d[2].x, y + avec3d[2].y, z + avec3d[2].z).tex(1.0D, 0.0D)
				.color(this.particleRed, this.particleGreen, this.particleBlue, a).lightmap(j, k).endVertex();
		buffer.pos(x + avec3d[3].x, y + avec3d[3].y, z + avec3d[3].z).tex(0.0D, 0.0D)
				.color(this.particleRed, this.particleGreen, this.particleBlue, a).lightmap(j, k).endVertex();

		Tessellator.getInstance().draw();
	}

	@Override
	public int getFXLayer() {
		return 3;
	}

}