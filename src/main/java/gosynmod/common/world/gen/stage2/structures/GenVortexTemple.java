package gosynmod.common.world.gen.stage2.structures;

import java.util.Random;

import gosynmod.common.entity.other.EntityVortex;
import gosynmod.common.init.BlockInit;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class GenVortexTemple extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (!(worldIn.getBlockState(position.add(i, -1, j)).isFullBlock()))
					return false;
			}
		}
		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				for (int k = 0; k < 4; k++) {
					if (worldIn.getBlockState(position.add(i, k, j)).isFullBlock())
						return false;
				}
			}
		}

		for (int i = -2; i < 3; i++) {
			for (int j = -2; j < 3; j++) {
				if (i == 0 && j == 0) {
					worldIn.setBlockState(position.add(i, 0, j), BlockInit.CRESEOLBRICK.getStateFromMeta(5));
				}
				worldIn.setBlockState(position.add(i, -1, j), BlockInit.CRESEOLBRICK.getDefaultState());
			}
		}
		worldIn.setBlockState(position.add(-1, 0, 0), BlockInit.CRESEOLBRICK_STAIR.getStateFromMeta(8));
		worldIn.setBlockState(position.add(1, 0, 0), BlockInit.CRESEOLBRICK_STAIR.getStateFromMeta(9));
		worldIn.setBlockState(position.add(0, 0, -1), BlockInit.CRESEOLBRICK_STAIR.getStateFromMeta(10));
		worldIn.setBlockState(position.add(0, 0, 1), BlockInit.CRESEOLBRICK_STAIR.getStateFromMeta(11));

		placeCollum(worldIn, position.add(-2, 0, -2), rand);
		placeCollum(worldIn, position.add(2, 0, -2), rand);
		placeCollum(worldIn, position.add(-2, 0, 2), rand);
		placeCollum(worldIn, position.add(2, 0, 2), rand);

		EntityVortex e = new EntityVortex(worldIn);
		e.posX = position.getX() + 0.5;
		e.posY = position.getY() + 1;
		e.posZ = position.getZ() + 0.5;
		worldIn.spawnEntity(e);

		return true;
	}

	private void placeCollum(World worldIn, BlockPos position, Random rand) {
		int size = rand.nextInt(3) + 2;
		for (int i = 0; i < size; i++) {
			if (worldIn.getBlockState(position.up(i)) == Blocks.AIR.getDefaultState()) {
				if (i == size / 2) {
					worldIn.setBlockState(position.up(i), BlockInit.CRESEOLBRICK.getStateFromMeta(rand.nextInt(2) + 2));
				} else
					worldIn.setBlockState(position.up(i), BlockInit.CRESEOLBRICK.getDefaultState());
			} else
				break;

		}
	}

}
