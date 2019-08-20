package gosynmod.common.entity.other;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityVortex extends EntityMob implements IAnimatedEntity {

	public EntityVortex(World worldIn) {
		super(worldIn);
		this.setSize(0.3f, 3f);
		this.setNoAI(true);
	}

	@Override
	public void onLivingUpdate() {
		if (!this.world.isRemote) {
			IBlockState state = world.getBlockState(getPosition().down());
			if (state == Blocks.AIR.getDefaultState())
				this.setDead();
		}
		super.onLivingUpdate();

	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean hitByEntity(Entity entityIn) {
		return false;
	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
		if (!world.isRemote) {
			double d0 = entityIn.posX;
			double d1 = entityIn.posY;
			double d2 = entityIn.posZ;

			for (int i = 0; i < 32; ++i) {
				double d3 = entityIn.posX + (((EntityLivingBase) entityIn).getRNG().nextDouble() - 0.5D) * 200.0D;
				double d4 = MathHelper.clamp(
						entityIn.posY + (double) (((EntityLivingBase) entityIn).getRNG().nextInt(16) - 8), 0.0D,
						(double) (world.getActualHeight() - 1));
				double d5 = entityIn.posZ + (((EntityLivingBase) entityIn).getRNG().nextDouble() - 0.5D) * 200.0D;

				if (entityIn.isRiding()) {
					entityIn.dismountRidingEntity();
				}

				((EntityLivingBase) entityIn).attemptTeleport(d3, d4, d5);
			}

		}

	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0d);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0);
	}

	private BlockPos getExit() {

		return null;
	}

	@Override
	public int getAnimationTick() {
		return 0;
	}

	@Override
	public void setAnimationTick(int tick) {
	}

	@Override
	public Animation getAnimation() {
		return null;
	}

	@Override
	public void setAnimation(Animation animation) {
	}

	@Override
	public Animation[] getAnimations() {
		return null;
	}

}
