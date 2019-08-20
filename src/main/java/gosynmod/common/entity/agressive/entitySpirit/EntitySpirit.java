package gosynmod.common.entity.agressive.entitySpirit;

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
import net.minecraft.world.World;

public class EntitySpirit extends EntityMob implements IAnimatedEntity {

	private Animation animation = NO_ANIMATION;
	private int animationTick;

	public static final Animation ANIMATION_JAW = Animation.create(20);
	public static final Animation ANIMATION_DEATH = Animation.create(20);

	private static final Animation[] ANIMATIONS = { ANIMATION_JAW };
	public AnimationAI currentAnim;

	public EntitySpirit(World worldIn) {
		super(worldIn);
		this.setSize(1F, 1F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

}
