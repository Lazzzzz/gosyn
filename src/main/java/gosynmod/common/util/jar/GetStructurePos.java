package gosynmod.common.util.jar;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GetStructurePos {
	int sizeX;
	int sizeZ;
	BlockPos pos;
	IBlockState TOP;
	IBlockState FILLER;

	public GetStructurePos(BlockPos pos, int sizeX, int sizeZ) {
		this.pos = pos;
		this.sizeX = sizeX;
		this.sizeZ = sizeZ;
	}

	public void generate(World world, Random rand) {
		TOP = world.getBiome(pos).topBlock;
		FILLER = world.getBiome(pos).fillerBlock;

		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeZ; j++) {
				int size;
					size = 2;
				for (int k = 0; k < size; k++) {
					if (k == size - 1) {
						if (i == 0 || i == sizeX - 1)
							world.setBlockState(pos.add(i, k, j), TOP);
						else if (j == 0 || j == sizeZ - 1)
							world.setBlockState(pos.add(i, k, j), TOP);
						else
							world.setBlockState(pos.add(i, k, j), FILLER);
					} else
						world.setBlockState(pos.add(i, k, j), FILLER);

				}
			}
		}

		for (int i = 1; i < sizeX - 1; i++) {
			for (int j = 1; j < sizeZ - 1; j++) {
				for (int k = 2; k < 4; k++) {
					if (k < 3 - rand.nextInt(2))
						world.setBlockState(pos.add(i, k, j), FILLER);
					else
						world.setBlockState(pos.add(i, k, j), TOP);
				}
			}
		}

	}
}
