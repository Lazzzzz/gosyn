package gosynmod.common.entity.agressive.entityKenpy;

import java.util.Random;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;

public class AIKenpyPinch extends AnimationAI<EntityKenpy> {

	protected Animation animation;
	protected EntityKenpy kenpy;
	protected Random rand;

	public AIKenpyPinch(EntityKenpy kenpy, Animation animation) {
		super(kenpy);
		setMutexBits(4);
		this.kenpy = kenpy;
		this.rand = new Random();
		this.animation = animation;
	}

	@Override
	public Animation getAnimation() {
		return animation;
	}

	@Override
	public boolean isAutomatic() {
		return true;
	}

	@Override
	public void startExecuting() {
		super.startExecuting();
		kenpy.currentAnim = this;
	}

	@Override
	public void updateTask() {
		super.updateTask();
	}


	@Override
	public void resetTask() {
		super.resetTask();
		kenpy.currentAnim = null;
	}

}
