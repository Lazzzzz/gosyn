package gosynmod.common.world.gen.stage1.structures;

import java.util.Random;

import gosynmod.common.world.gen.stage1.structures.part.FortnestConnector;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FortnestMazePlacer {

	public void generateMaze(World world, BlockPos pos) {

		MazeGenerator[] mazeList = 
			
			{ 
				new MazeGenerator(12, 12), 
				new MazeGenerator(12, 12),
				new MazeGenerator(12, 12),
				new MazeGenerator(12, 12) 
			};
		
		
		for (int m = 0; m < mazeList.length; m++) {

			MazeGenerator maze = mazeList[m];
			
			char[][] grid = maze.getGrid();
			
			for (int i = 1; i < grid.length - 2; i++) {
				for (int j = 1; j < grid[i].length - 2; j++) {
					String q = Character.toString(grid[i][j]);
					
					if (q.equals(".")) {

						boolean[] walls = { false, false, false, false };
						if (!Character.toString(grid[i - 1][j]).equals(".")) {
							walls[0] = true;
						}
						if (!Character.toString(grid[i + 1][j]).equals(".")) {
							walls[1] = true;
						}
						if (!Character.toString(grid[i][j - 1]).equals(".")) {
							walls[2] = true;
						}
						if (!Character.toString(grid[i][j + 1]).equals(".")) {
							walls[3] = true;
						}

						new FortnestConnector().generate(world, new Random(), pos.add(i * 8, m * 5, j * 8), walls);

					}
				}
			}
		}
	}

	public void placeStairs(World world, BlockPos pos, MazeGenerator[] mazeList) {
		
		
		
	}

}
