
package gosynmod.common.world.biomes.stage2.Mushrooom;

import java.util.Random;

import gosynmod.common.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class GenMushrooom extends WorldGenAbstractTree {
	
	public static final IBlockState LOG   = BlockInit.MUSHROOOM_STEM.getDefaultState();
	
	public GenMushrooom() {
		super(false);
		
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		IBlockState LEAVE = BlockInit.MUSHROOOM_CAP.getStateFromMeta(rand.nextInt(4));
		int x = pos.getX();
		int y = pos.getY() - 1;
		int z = pos.getZ();

		if (world.getBlockState(new BlockPos(x, y, z)) == BlockInit.CRESEOL_GRASS.getDefaultState()
				|| world.getBlockState(new BlockPos(x, y, z)) == BlockInit.ROCK.getDefaultState()) {
			
			int size = rand.nextInt(4) + 4;
			
			int deltax = rand.nextInt(3)-1;
			int deltaz = rand.nextInt(3)-1;
			int deltay = rand.nextInt(3)+1;
			int deltaSize = size - deltay;
			
			int sizexz = rand.nextInt(1)+1;
			int sizey  = rand.nextInt(5);
		
			for (int i = deltay; i >= 0; i--) {
				x = pos.getX();
				y = pos.getY() + i ;
				z = pos.getZ();
				world.setBlockState(new BlockPos(x,y,z), LOG);
				
			}
			
			for (int i = deltaSize; i >= 0; i--) {
				x = pos.getX()     +deltax;
				y = pos.getY() + i + deltay;
				z = pos.getZ()     +deltaz;
				world.setBlockState(new BlockPos(x,y,z), LOG);
			}
			
			for (int i = -sizexz; i <= sizexz; i++) {
				for (int j = -sizexz; j <= sizexz; j++) {
					x = pos.getX() + deltax + i;
					y = pos.getY() + size;
					z = pos.getZ() + deltaz + j;
					world.setBlockState(new BlockPos(x,y,z), LEAVE);
				}
			}
			
			for (int i = 0; i < sizexz*2+1; i++) {
				for (int j = 0; j < sizey; j++) {
					x = pos.getX() + deltax + i - sizexz;
					y = pos.getY() + size - j - 1;
					z = pos.getZ() + deltaz + sizexz + 1;
					world.setBlockState(new BlockPos(x,y,z), LEAVE);
					
					z = pos.getZ() + deltaz - (sizexz + 1);
					world.setBlockState(new BlockPos(x,y,z), LEAVE);
					
				}
			}
			
			for (int i = 0; i < sizexz*2+1; i++) {
				for (int j = 0; j < sizey; j++) {
					x = pos.getX() + deltax + sizexz + 1;
					y = pos.getY() + size - j - 1;
					z = pos.getZ() + deltaz + i - sizexz;
					world.setBlockState(new BlockPos(x,y,z), LEAVE);
					
					x = pos.getX() + deltax - (sizexz + 1);
					world.setBlockState(new BlockPos(x,y,z), LEAVE);
					
				}
			}
			
		}

		return true;

	}
}
