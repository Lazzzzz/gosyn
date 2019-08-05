package gosynmod.client.entityModel;

import java.util.Random;

import gosynmod.common.Reference;
import gosynmod.common.entity.other.EntityVortex;
import gosynmod.common.interfaces.ParticleTypes;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;

public class ModelVortex extends AdvancedModelBase {
	public AdvancedModelRenderer shape1;
	public AdvancedModelRenderer shape2;
	public AdvancedModelRenderer shape3;
	public AdvancedModelRenderer shape4;

	private ModelAnimator animator;

	private Random rand = new Random();

	public ModelVortex() {
		this.textureWidth = 16;
		this.textureHeight = 32;
		this.shape4 = new AdvancedModelRenderer(this, 0, 24);
		this.shape4.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shape4.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.shape2 = new AdvancedModelRenderer(this, 0, 0);
		this.shape2.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shape2.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.shape1 = new AdvancedModelRenderer(this, 0, 8);
		this.shape1.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shape1.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
		this.shape3 = new AdvancedModelRenderer(this, 0, 16);
		this.shape3.setRotationPoint(0.0F, 22.0F, 0.0F);
		this.shape3.addBox(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);

		animator = ModelAnimator.create();
		updateDefaultPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {

		EntityVortex vortex = (EntityVortex) entity;
		animate(vortex, f, f1, f2, f3, f4, f5);

		this.shape4.render(f5);
		this.shape2.render(f5);
		this.shape1.render(f5);
		this.shape3.render(f5);
	}

	public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
		ModelRenderer.rotateAngleX = x;
		ModelRenderer.rotateAngleY = y;
		ModelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entityIn) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
		resetToDefaultPose();

	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityVortex vortex = (EntityVortex) entity;
		animator.update(vortex);

		f = vortex.ticksExisted;
		f1 = 0.5f;

		setRotationAngles(f, f1, f2, f3, f4, f5, vortex);

		float globalspeed = 0.1F;
		float globalheight = 1F;
		float globalangle = 1F;

		bob(shape1, globalspeed * 0.3f, (float) (globalheight * 45), false, f, f1);
		bob(shape2, globalspeed * -0.4f, (float) (globalheight * 40), false, f, f1);
		bob(shape3, globalspeed * 0.2f, (float) (globalheight * 50), false, f, f1);
		bob(shape4, globalspeed * -0.5f, (float) (globalheight * 35), false, f, f1);

		shape1.rotationPointX = MathHelper.cos(f / 20) * globalangle * 8;
		shape1.rotationPointZ = MathHelper.sin(f / 20) * globalangle * 8;
		shape1.rotateAngleX = -MathHelper.cos(f) * globalangle * 4;
		shape1.rotateAngleZ = MathHelper.sin(f) * globalangle * 3;
		shape1.rotateAngleY = MathHelper.sin(f) * globalangle * 3;
		shape1.setScale(MathHelper.cos(f / 20), MathHelper.cos(f / 20), MathHelper.cos(f / 20));

		shape2.rotationPointX = MathHelper.cos(-f / 20) * globalangle * 5;
		shape2.rotationPointZ = MathHelper.sin(f / 20) * globalangle * 5;
		shape2.rotateAngleX = MathHelper.cos(f) * globalangle * 6;
		shape2.rotateAngleZ = -MathHelper.sin(f) * globalangle * 4;
		shape2.rotateAngleY = MathHelper.sin(f) * globalangle * 3;
		shape2.setScale(MathHelper.cos(f / 25), MathHelper.cos(f / 25), MathHelper.cos(f / 25));
		
		shape3.rotationPointX = MathHelper.cos(-f / 20) * globalangle * 5;
		shape3.rotationPointZ = MathHelper.sin(-f / 20) * globalangle * 5;
		shape3.rotateAngleX = -MathHelper.cos(f) * globalangle * 3;
		shape3.rotateAngleZ = -MathHelper.sin(f) * globalangle * 4;
		shape3.rotateAngleY = MathHelper.sin(f) * globalangle * 3;
		shape3.setScale(MathHelper.cos(f / 30), MathHelper.cos(f / 30), MathHelper.cos(f / 30));
		
		
		shape4.rotationPointX = MathHelper.cos(f / 20) * globalangle * 5;
		shape4.rotationPointZ = MathHelper.sin(-f / 20) * globalangle * 5;
		shape4.rotateAngleX = -MathHelper.cos(f) * globalangle * 4;
		shape4.rotateAngleZ = MathHelper.sin(f) * globalangle * 4;
		shape4.rotateAngleY = MathHelper.sin(f) * globalangle * 3;
		shape4.setScale(MathHelper.cos(f / 35), MathHelper.cos(f / 35), MathHelper.cos(f / 35));		

		SpawnParticles(vortex, vortex.posX + vortex.width / 2, vortex.posY, vortex.posZ + vortex.width / 2);

	}

	private void SpawnParticles(EntityVortex vortex, double x, double y, double z) {
		if (rand.nextInt(10) == 0)
			Reference.PROXY.spawnParticle(vortex.world, ParticleTypes.VORTEX, x, y, z, 0, 0, 0);

	}
}
