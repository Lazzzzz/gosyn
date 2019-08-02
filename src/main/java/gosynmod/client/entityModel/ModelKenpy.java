package gosynmod.client.entityModel;

import gosynmod.common.entity.agressive.entityKenpy.EntityKenpy;
import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelGiantSnail - LaZz_ Created using Tabula 7.0.1
 */
public class ModelKenpy extends AdvancedModelBase {
	public AdvancedModelRenderer Body;
	public AdvancedModelRenderer shape4;
	public AdvancedModelRenderer head;
	public AdvancedModelRenderer shape18;
	public AdvancedModelRenderer shape19;
	public AdvancedModelRenderer shape20;
	public AdvancedModelRenderer shape21;
	public AdvancedModelRenderer joint;
	public AdvancedModelRenderer shape6;
	public AdvancedModelRenderer shape7;
	public AdvancedModelRenderer shape8;
	public AdvancedModelRenderer shape10;
	public AdvancedModelRenderer shape12;
	public AdvancedModelRenderer shape11;
	public AdvancedModelRenderer joint2;
	public AdvancedModelRenderer shape16;
	public AdvancedModelRenderer shape13;
	public AdvancedModelRenderer joint3;
	public AdvancedModelRenderer shape17;
	public AdvancedModelRenderer shape22;
	public AdvancedModelRenderer shape23;
	public AdvancedModelRenderer shape24;
	public AdvancedModelRenderer shape26;
	public AdvancedModelRenderer shape27;
	public AdvancedModelRenderer shape28;
	public AdvancedModelRenderer shape29;
	public AdvancedModelRenderer shape30;
	public AdvancedModelRenderer shape31;
	public AdvancedModelRenderer shape32;
	public AdvancedModelRenderer shape33;
	public AdvancedModelRenderer shape38;
	public AdvancedModelRenderer shape34;
	public AdvancedModelRenderer shape35;
	public AdvancedModelRenderer shape36;
	public AdvancedModelRenderer shape37;

	private ModelAnimator animator;

	public ModelKenpy() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Body = new AdvancedModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(-4.0F, 16.0F, -4.0F);
		this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 5, 10, 0.0F);
		this.joint2 = new AdvancedModelRenderer(this, 0, 0);
		this.joint2.setRotationPoint(0.0F, -0.5F, -2.0F);
		this.joint2.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(joint2, 0.0F, 0.7853981633974483F, 0.0F);
		this.joint3 = new AdvancedModelRenderer(this, 0, 0);
		this.joint3.setRotationPoint(0.0F, 0.0F, -2.0F);
		this.joint3.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(joint3, 0.0F, -0.7853981633974483F, 0.0F);
		this.shape30 = new AdvancedModelRenderer(this, 45, 24);
		this.shape30.setRotationPoint(-0.2F, 9.0F, 0.0F);
		this.shape30.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape30, 0.0F, 0.0F, 0.296705972839036F);
		this.shape35 = new AdvancedModelRenderer(this, 52, 28);
		this.shape35.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape35.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shape21 = new AdvancedModelRenderer(this, 53, 24);
		this.shape21.setRotationPoint(8.0F, 3.5F, 2.0F);
		this.shape21.addBox(0.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
		this.shape11 = new AdvancedModelRenderer(this, 0, 15);
		this.shape11.setRotationPoint(2.0F, 1.0F, 0.0F);
		this.shape11.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shape11, 0.0F, -0.7853981633974483F, 0.0F);
		this.shape31 = new AdvancedModelRenderer(this, 0, 0);
		this.shape31.setRotationPoint(0.2F, 0.0F, 0.0F);
		this.shape31.addBox(-0.5F, -4.5F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(shape31, 0.0F, 0.0F, -0.5235987755982988F);
		this.shape26 = new AdvancedModelRenderer(this, 45, 20);
		this.shape26.setRotationPoint(-0.2F, 8.7F, 0.0F);
		this.shape26.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape26, 0.0F, 0.0F, -0.296705972839036F);
		this.shape4 = new AdvancedModelRenderer(this, 0, 15);
		this.shape4.setRotationPoint(2.0F, 0.0F, 7.0F);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 4, 3, 8, 0.0F);
		this.setRotateAngle(shape4, 0.7853981633974483F, 0.0F, 0.0F);
		this.shape20 = new AdvancedModelRenderer(this, 53, 20);
		this.shape20.setRotationPoint(-1.0F, 3.5F, 2.0F);
		this.shape20.addBox(0.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
		this.shape22 = new AdvancedModelRenderer(this, 28, 21);
		this.shape22.setRotationPoint(-1.0F, 0.0F, -0.5F);
		this.shape22.addBox(0.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(shape22, 0.0F, 0.0F, -0.4886921905584123F);
		this.shape6 = new AdvancedModelRenderer(this, 36, 0);
		this.shape6.setRotationPoint(0.0F, -0.85F, 0.0F);
		this.shape6.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
		this.shape29 = new AdvancedModelRenderer(this, 40, 23);
		this.shape29.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.shape29.addBox(-0.6F, 1.0F, -0.5F, 1, 8, 1, 0.0F);
		this.setRotateAngle(shape29, 0.0F, 0.0F, -0.7853981633974483F);
		this.shape13 = new AdvancedModelRenderer(this, 8, 26);
		this.shape13.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.shape13.addBox(-0.5F, -0.5F, -2.5F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shape13, 0.0F, 0.7853981633974483F, 0.0F);
		this.head = new AdvancedModelRenderer(this, 49, 12);
		this.head.setRotationPoint(4.0F, 0.0F, -1.0F);
		this.head.addBox(-2.0F, -2.0F, -2.0F, 4, 5, 3, 0.0F);
		this.shape28 = new AdvancedModelRenderer(this, 40, 16);
		this.shape28.setRotationPoint(0.5F, -4.0F, 0.5F);
		this.shape28.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape28, -0.006981317007977318F, 0.0F, 0.0F);
		this.shape19 = new AdvancedModelRenderer(this, 32, 15);
		this.shape19.setRotationPoint(9.0F, 2.5F, 7.5F);
		this.shape19.addBox(-1.0F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
		this.shape12 = new AdvancedModelRenderer(this, 0, 26);
		this.shape12.setRotationPoint(-3.0F, 1.5F, -3.0F);
		this.shape12.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.shape10 = new AdvancedModelRenderer(this, 24, 26);
		this.shape10.setRotationPoint(1.0F, 1.5F, -3.0F);
		this.shape10.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
		this.joint = new AdvancedModelRenderer(this, 0, 0);
		this.joint.setRotationPoint(2.0F, 0.0F, 8.0F);
		this.joint.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
		this.setRotateAngle(joint, -0.7853981633974483F, 0.0F, 0.0F);
		this.shape8 = new AdvancedModelRenderer(this, 16, 17);
		this.shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape8.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 4, 0.0F);
		this.shape17 = new AdvancedModelRenderer(this, 16, 26);
		this.shape17.setRotationPoint(0.0F, -0.5F, 0.0F);
		this.shape17.addBox(-0.5F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shape17, 0.0F, -0.7853981633974483F, 0.0F);
		this.shape7 = new AdvancedModelRenderer(this, 30, 0);
		this.shape7.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.shape7.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 2, 0.0F);
		this.shape38 = new AdvancedModelRenderer(this, 0, 6);
		this.shape38.setRotationPoint(0.1F, 6.9F, 0.0F);
		this.shape38.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape38, 0.0F, 0.0F, -0.2530727415391778F);
		this.shape32 = new AdvancedModelRenderer(this, 55, 0);
		this.shape32.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.shape32.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shape16 = new AdvancedModelRenderer(this, 0, 19);
		this.shape16.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape16.addBox(-0.5F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(shape16, 0.0F, 0.7853981633974483F, 0.0F);
		this.shape34 = new AdvancedModelRenderer(this, 4, 0);
		this.shape34.setRotationPoint(0.2F, 0.0F, 0.0F);
		this.shape34.addBox(-0.5F, -4.5F, -0.5F, 1, 5, 1, 0.0F);
		this.setRotateAngle(shape34, 0.0F, 0.0F, 0.5235987755982988F);
		this.shape23 = new AdvancedModelRenderer(this, 40, 12);
		this.shape23.setRotationPoint(0.5F, -4.0F, 0.5F);
		this.shape23.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.shape27 = new AdvancedModelRenderer(this, 32, 21);
		this.shape27.setRotationPoint(-1.0F, 0.0F, -0.5F);
		this.shape27.addBox(0.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F);
		this.setRotateAngle(shape27, 0.0F, 0.0F, 0.4886921905584123F);
		this.shape36 = new AdvancedModelRenderer(this, 36, 23);
		this.shape36.setRotationPoint(0.6F, 0.0F, 0.0F);
		this.shape36.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(shape36, 0.0F, 0.0F, -0.7853981633974483F);
		this.shape33 = new AdvancedModelRenderer(this, 40, 23);
		this.shape33.setRotationPoint(-0.5F, 0.0F, 0.0F);
		this.shape33.addBox(-0.5F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
		this.setRotateAngle(shape33, 0.0F, 0.0F, 0.7853981633974483F);
		this.shape18 = new AdvancedModelRenderer(this, 24, 15);
		this.shape18.setRotationPoint(0.0F, 2.5F, 7.5F);
		this.shape18.addBox(-1.0F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
		this.shape37 = new AdvancedModelRenderer(this, 44, 28);
		this.shape37.setRotationPoint(-0.2F, 6.7F, 0.0F);
		this.shape37.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.setRotateAngle(shape37, 0.0F, 0.0F, 0.2530727415391778F);
		this.shape24 = new AdvancedModelRenderer(this, 36, 23);
		this.shape24.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape24.addBox(-1.0F, 0.0F, -0.5F, 1, 8, 1, 0.0F);
		this.setRotateAngle(shape24, 0.0F, 0.0F, 0.7853981633974483F);
		this.shape11.addChild(this.joint2);
		this.shape13.addChild(this.joint3);
		this.shape29.addChild(this.shape30);
		this.shape34.addChild(this.shape35);
		this.Body.addChild(this.shape21);
		this.shape10.addChild(this.shape11);
		this.shape20.addChild(this.shape31);
		this.shape24.addChild(this.shape26);
		this.Body.addChild(this.shape4);
		this.Body.addChild(this.shape20);
		this.shape18.addChild(this.shape22);
		this.joint.addChild(this.shape6);
		this.shape28.addChild(this.shape29);
		this.shape12.addChild(this.shape13);
		this.Body.addChild(this.head);
		this.shape27.addChild(this.shape28);
		this.Body.addChild(this.shape19);
		this.head.addChild(this.shape12);
		this.head.addChild(this.shape10);
		this.shape4.addChild(this.joint);
		this.shape7.addChild(this.shape8);
		this.joint3.addChild(this.shape17);
		this.shape6.addChild(this.shape7);
		this.shape33.addChild(this.shape38);
		this.shape31.addChild(this.shape32);
		this.joint2.addChild(this.shape16);
		this.shape21.addChild(this.shape34);
		this.shape22.addChild(this.shape23);
		this.shape19.addChild(this.shape27);
		this.shape35.addChild(this.shape36);
		this.shape32.addChild(this.shape33);
		this.Body.addChild(this.shape18);
		this.shape36.addChild(this.shape37);
		this.shape23.addChild(this.shape24);

		animator = ModelAnimator.create();
		updateDefaultPose();

	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityKenpy kenpy = (EntityKenpy) entity;
		animate(kenpy, f, f1, f2, f3, f4, f5);
		this.Body.render(f5);

	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer AdvancedModelRenderer, float x, float y, float z) {
		AdvancedModelRenderer.rotateAngleX = x;
		AdvancedModelRenderer.rotateAngleY = y;
		AdvancedModelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		resetToDefaultPose();
		EntityKenpy kenpy = (EntityKenpy) entity;
		// animate(kenpy, f, f1, f2, f3, f4, f5);
	}

	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityKenpy kenpy = (EntityKenpy) entity;
		animator.update(kenpy);

		float globalspeed = 1F;
		float globalheight = 1F;
		float globalangle = 1F;

		// WALK
		swing(shape29, globalspeed * 0.5f, globalangle * 0.5f, false, 0, 0, f, f1);
		swing(shape27, globalspeed * 0.5f, globalangle * 0.6f, false, 0, -0.25f, f, f1);

		swing(shape33, globalspeed * 0.5f, globalangle * 0.5f, false, 0, 0, f, f1);
		swing(shape31, globalspeed * 0.5f, globalangle * 0.6f, false, 0, 0, f, f1);

		swing(shape24, globalspeed * 0.5f, -globalangle * 0.5f, false, 0, 0, f, f1);
		swing(shape22, globalspeed * 0.5f, -globalangle * 0.6f, false, 0, 0.25f, f, f1);

		swing(shape36, globalspeed * 0.5f, -globalangle * 0.5f, false, 0, 0, f, f1);
		swing(shape34, globalspeed * 0.5f, -globalangle * 0.6f, false, 0, 0, f, f1);

		bob(shape18, globalspeed * 0.5f, globalheight * 0.5f, false, f, f1);
		bob(shape19, -globalspeed * 0.5f, globalheight * 0.5f, false, f, f1);
		bob(shape20, globalspeed * 0.4f, globalheight * 0.5f, false, f, f1);
		bob(shape21, -globalspeed * 0.4f, globalheight * 0.5f, false, f, f1);
		// walk(head, globalspeed * 0.25f, globalangle * 0.2f, false, 0, 0, f, f1);

		f = kenpy.ticksExisted;
		f1 = 0.5f;

		walk(shape6, -globalspeed * 0.05f, -globalangle * 0.5f, false, 0, 0, f, f1);
		walk(shape4, globalspeed * 0.05f, globalangle * 0.5f, false, 0, 0, f, f1);
		flap(shape4, globalspeed * 0.025f, globalangle * 0.25f, false, 0, 0, f, f1);
		bob(Body, globalspeed * 0.2f, globalheight * 0.3f, false, f, f1);
		bob(shape18, globalspeed * 0.2f, -globalheight * 0.3f, false, f, f1);
		bob(shape19, globalspeed * 0.2f, -globalheight * 0.3f, false, f, f1);
		bob(shape20, globalspeed * 0.2f, -globalheight * 0.3f, false, f, f1);
		bob(shape21, globalspeed * 0.2f, -globalheight * 0.3f, false, f, f1);
		// bob(head, globalspeed * 0.25f, globalheight * 0.75f, false, f, f1);

		// PINCH ANIMATION
		animator.setAnimation(kenpy.ANIMATION_PINCH);
		animator.resetKeyframe(5);
		animator.rotate(shape11, 0, 0.5f, 0);
		animator.rotate(shape13, 0, -0.5f, 0);
		animator.endKeyframe();
		animator.resetKeyframe(1);

		// ATTACK ANIMATION
		animator.setAnimation(kenpy.ANIMATION_ATTACK);
		animator.resetKeyframe(10);
		animator.rotate(shape4, 0.8f, 0f, 0f);
		animator.move(shape6, 0, 0, 0.8f);
		animator.rotate(shape6, -0.5f, 0f, 0f);
		animator.endKeyframe();

	}
}
