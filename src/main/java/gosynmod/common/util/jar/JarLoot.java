package gosynmod.common.util.jar;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class JarLoot {
	private final SetLoot [] list = {			
	
	};

	public void spawnLoot(World worldIn, Random rand, BlockPos pos) {
		for (int i = 0; i < this.list.length; i ++) {
			list[i].isPick(worldIn, rand, pos);
				
		}
	}

}

