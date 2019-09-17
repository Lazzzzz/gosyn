package gosynmod.common.blocks.tileEntity.counter;

import java.util.List;
import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class TileEntitySpiritCounter extends TileEntity implements ITickable {

	int timer = 120;
	int counterDown = 0;
	boolean start = false;
	Random rand = new Random();
	boolean playerOnPos = false;
	int count = 0;
	BlockPos lastPos;
	BlockPos pos1;
	BlockPos pos2;
	BlockPos pos3;
	BlockPos pos4;
	int lastInt = 0;
	boolean win = false;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("win", win);
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		win = compound.getBoolean("win");

		super.readFromNBT(compound);
	}

	public AxisAlignedBB getRange() {
		return new AxisAlignedBB(getPos().getX() - 6, getPos().getY() - 2, getPos().getZ() - 6, getPos().getX() + 6,
				getPos().getY() + 3, getPos().getZ() + 6);
	}

	public void update() {
		if (!this.world.isRemote) {
			if (checkForPlayer() && win == false) {
				if (counterDown == 0) {
					if (playerOnPos == true) {
						count++;
						timer = (int) (timer * 0.97);
						if (count == 25) {
							win = true;
							wellPlay();
						}
					} else {
						if (count > 2) {
							timer = 100;
							counterDown = timer;
							setMalus();
							count = 0;
						}
					}

					getNewPos();

					playerOnPos = false;
					counterDown = timer;

				}
				counterDown--;
				playerOnPos = playerOnLastPos();
			}
		}
	}

	public void wellPlay() {
		List list = this.world.getEntitiesWithinAABB(EntityPlayer.class, getRange());
		if (!list.isEmpty()) {
			counterDown = 0;
			for (int i = 0; i < list.size(); i++) {
				EntityPlayer player = (EntityPlayer) list.get(i);
				player.sendMessage(new TextComponentString("WINNNN !!"));

			}
		}
		BlockPos p = this.getPos().add(-5, 0, 7);
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				world.setBlockToAir(p.add(0, i, j));

			}
		}

		reset();
	}

	public void setMalus() {

		List list = this.world.getEntitiesWithinAABB(EntityPlayer.class, getRange());

		int max = rand.nextInt(6) + 2;

		if (!list.isEmpty()) {
			counterDown = 0;
			for (int i = 0; i < list.size(); i++) {
				EntityPlayer player = (EntityPlayer) list.get(i);
				player.sendMessage(new TextComponentString("LOOSE : " + max + " spirits will spawn"));

			}
		}

		if (win == false) {
			for (int i = 0; i < max; i++) {
				EntityZombie e = new EntityZombie(world);
				e.setPosition(getPos().getX() + 0.5, getPos().getY() + 1, getPos().getZ() + 0.5);
				world.spawnEntity(e);
			}
		}
	}

	public void getNewPos() {

		reset();
		boolean done = false;
		int j = 0;
		while (!done) {
			j = rand.nextInt(4);
			if (j != lastInt) {
				done = true;
				lastInt = j;
			}
		}
		switch (j) {
		case 0:
			world.setBlockState(pos1, BlockInit.SPIRIT_PAD.getDefaultState());
			world.setBlockState(pos1.add(1, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos1.add(0, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos1.add(1, 0, 0), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			lastPos = pos1;
			break;
		case 1:
			world.setBlockState(pos2, BlockInit.SPIRIT_PAD.getDefaultState());
			world.setBlockState(pos2.add(1, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos2.add(0, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos2.add(1, 0, 0), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			lastPos = pos2;
			break;
		case 2:
			world.setBlockState(pos3, BlockInit.SPIRIT_PAD.getDefaultState());
			world.setBlockState(pos3.add(1, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos3.add(0, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos3.add(1, 0, 0), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			lastPos = pos3;
			break;
		case 3:
			world.setBlockState(pos4, BlockInit.SPIRIT_PAD.getDefaultState());
			world.setBlockState(pos4.add(1, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos4.add(0, 0, 1), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			world.setBlockState(pos4.add(1, 0, 0), BlockInit.GOSYN_MULTIBLOCK.getDefaultState());
			lastPos = pos4;
			break;
		}

	}

	public void reset() {
		if (lastPos != null) {
			world.setBlockState(lastPos, BlockInit.SPIRITBRICK.getStateFromMeta(1));
			world.setBlockState(lastPos.add(1, 0, 1), BlockInit.SPIRITBRICK.getStateFromMeta(1));
			world.setBlockState(lastPos.add(0, 0, 1), BlockInit.SPIRITBRICK.getStateFromMeta(1));
			world.setBlockState(lastPos.add(1, 0, 0), BlockInit.SPIRITBRICK.getStateFromMeta(1));
		}
	}

	public boolean playerOnLastPos() {
		if (lastPos != null) {
			AxisAlignedBB range = new AxisAlignedBB(lastPos.getX(), lastPos.getY() - 1, lastPos.getZ(),
					lastPos.getX() + 2, lastPos.getY() + 4, lastPos.getZ() + 2);
			List list = this.world.getEntitiesWithinAABB(EntityPlayer.class, range);

			if (!list.isEmpty()) {
				counterDown = 0;
				for (int i = 0; i < list.size(); i++) {
					EntityPlayer player = (EntityPlayer) list.get(i);
					player.sendMessage(new TextComponentString("Count: " + (count + 1) + " / 25"));

				}
				return true;
			}
		}
		return false;
	}

	public boolean checkForPlayer() {

		List list = world.getEntitiesWithinAABB(EntityPlayer.class, getRange());

		if (!list.isEmpty()) {
			setPosition();
			return true;
		}
		start = false;
		count = 0;
		timer = 100;
		counterDown = timer;
		reset();
		return false;
	}

	public void setPosition() {
		pos1 = getPos().add(-3, -2, 2);
		pos2 = getPos().add(-3, -2, -4);
		pos3 = getPos().add(3, -2, 2);
		pos4 = getPos().add(3, -2, -4);
	}

}
