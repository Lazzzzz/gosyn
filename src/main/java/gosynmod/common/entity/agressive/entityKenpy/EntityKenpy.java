package gosynmod.common.entity.agressive.entityKenpy;

import java.util.Random;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityKenpy extends EntityMob implements IAnimatedEntity {

	private Animation animation = NO_ANIMATION;
	private int animationTick;

	public static final Animation ANIMATION_PINCH = Animation.create(20);
	public static final Animation ANIMATION_ATTACK = Animation.create(20);
	public static final Animation ANIMATION_DEATH = Animation.create(20);

	private static final Animation[] ANIMATIONS = { ANIMATION_PINCH, ANIMATION_ATTACK, ANIMATION_DEATH };
	public AnimationAI currentAnim;

	public EntityKenpy(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(11, new AIKenpyAttack(this, ANIMATION_ATTACK, 1.23000000298023224D, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(11, new AIKenpyPinch(this, ANIMATION_PINCH));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000298023224D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6);
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (inWater && rand.nextInt(20) == 0) {
			onGround = false;
			motionX = getLookVec().x * 2f;
			motionY = 1f - rand.nextFloat();
			motionZ = getLookVec().z * 2f;

		}
		if (getAnimation() == ANIMATION_ATTACK && world.isRemote) {
			spawnParticles();
		}

		if (getAnimation() != NO_ANIMATION) {
			animationTick++;
			if (!world.isRemote && animationTick >= animation.getDuration()) {
				setAnimation(NO_ANIMATION);

			}
		}

		if (rand.nextInt(100) == 0)
			AnimationHandler.INSTANCE.sendAnimationMessage(this, ANIMATION_PINCH);

		if (getAttackTarget() != null && currentAnim == null && getAnimation() == NO_ANIMATION
				&& getAnimation() != ANIMATION_DEATH) {

			switch (new Random().nextInt(1)) {
			case 0:
				AnimationHandler.INSTANCE.sendAnimationMessage(this, ANIMATION_ATTACK);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public float getEyeHeight() {
		return 1F;
	}

	@Override
	public int getAnimationTick() {
		return animationTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		animationTick = tick;
	}

	@Override
	public Animation getAnimation() {
		return this.animation;
	}

	@Override
	public void setAnimation(Animation animation) {
		if (animation == NO_ANIMATION) {
			onAnimationFinish(this.animation);
			setAnimationTick(0);
		}
		this.animation = animation;
	}

	@Override
	public Animation[] getAnimations() {
		return ANIMATIONS;
	}

	protected void onAnimationFinish(Animation animation) {

	}

	public Animation getDeathAnimation() {
		return ANIMATION_DEATH;
	}

	protected void onDeathAIUpdate() {
		if (getAnimation() != ANIMATION_DEATH)
			AnimationHandler.INSTANCE.sendAnimationMessage(this, ANIMATION_DEATH);
	}

	protected void spawnParticles() {
		Vec3d v = this.getVectorForRotation(rotationPitch, rotationYaw);

		double x = this.getLookVec().x;
		double y = this.getLookVec().y;
		double z = this.getLookVec().z;

		if (rand.nextInt(4) == 0) {
			this.world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX + (this.width / 4) * x * 1.5f,
					this.posY + (double) this.height, this.posZ + (this.width / 4) * z * 1.5f, 1D, 1D, 1D);
		}

	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

}
