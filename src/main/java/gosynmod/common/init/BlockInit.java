package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.blocks.BlockDirt;
import gosynmod.common.blocks.BlockGrass;
import gosynmod.common.blocks.BlockRock;
import net.minecraft.block.Block;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ROCK  = new BlockRock();
	public static final Block DIRT  = new BlockDirt();
	public static final Block GRASS = new BlockGrass();
}
