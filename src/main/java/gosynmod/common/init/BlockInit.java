package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.blocks.BlockDirt;
import gosynmod.common.blocks.BlockDirtyGrass;
import gosynmod.common.blocks.BlockGrass;
import gosynmod.common.blocks.BlockMelynchBark;
import gosynmod.common.blocks.BlockMelynchLeaves;
import gosynmod.common.blocks.BlockMelynchPlanks;
import gosynmod.common.blocks.BlockMud;
import gosynmod.common.blocks.BlockRock;
import gosynmod.common.blocks.plants.BlockFallenLeaves;
import gosynmod.common.blocks.plants.BlockGentian;
import gosynmod.common.blocks.plants.BlockMudShortGrass;
import gosynmod.common.blocks.plants.BlockSlenderMonkey;
import gosynmod.common.blocks.plants.BlockSmallCattails;
import gosynmod.common.blocks.plants.BlockTallCattails;
import gosynmod.common.blocks.plants.BlockTallGrass;
import net.minecraft.block.Block;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//BLOCKS
	
	public static final Block ROCK   		 = new BlockRock();
	public static final Block DIRT  		 = new BlockDirt();
	public static final Block MUD  			 = new BlockMud();
	public static final Block GRASS 		 = new BlockGrass();
	public static final Block DIRTY_GRASS	 = new BlockDirtyGrass();
	public static final Block MELYNCH_BARK   = new BlockMelynchBark();
	public static final Block MELYNCH_PLANKS = new BlockMelynchPlanks();
	public static final Block MELYNCH_LEAVES = new BlockMelynchLeaves();
	
	//PLANTS
	public static final Block SMALL_CATTAILS = new BlockSmallCattails();
	public static final Block TALL_CATTAILS  = new BlockTallCattails();
	public static final Block TALL_GRASS	 = new BlockTallGrass();
	public static final Block GENTIAN		 = new BlockGentian();
	public static final Block FALLEN_LEAVES	 = new BlockFallenLeaves();
	public static final Block MUD_SHORTGRASS = new BlockMudShortGrass();
	public static final Block SLENDER_MONKEY = new BlockSlenderMonkey();
}
