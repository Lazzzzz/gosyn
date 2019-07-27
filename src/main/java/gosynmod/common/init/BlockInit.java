package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.blocks.BlockDirt;
import gosynmod.common.blocks.BlockGrass;
import gosynmod.common.blocks.BlockMelynchBark;
import gosynmod.common.blocks.BlockMelynchLeaves;
import gosynmod.common.blocks.BlockMelynchPlanks;
import gosynmod.common.blocks.BlockMud;
import gosynmod.common.blocks.BlockRock;
import gosynmod.common.blocks.plants.BlockSmallCattails;
import net.minecraft.block.Block;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//BLOCKS
	
	public static final Block ROCK   		 = new BlockRock();
	public static final Block DIRT  		 = new BlockDirt();
	public static final Block MUD  			 = new BlockMud();
	public static final Block GRASS 		 = new BlockGrass();
	public static final Block MELYNCH_BARK   = new BlockMelynchBark();
	public static final Block MELYNCH_PLANKS = new BlockMelynchPlanks();
	public static final Block MELYNCH_LEAVES = new BlockMelynchLeaves();
	
	//PLANTS
	public static final Block SMALL_CATTAILS = new BlockSmallCattails();
}
