package gosynmod.common.init;

import java.util.ArrayList;
import java.util.List;

import gosynmod.common.blocks.deco.BlockRockBrick;
import gosynmod.common.blocks.deco.BlockCreseolBrick.BlockCreseolBrick;
import gosynmod.common.blocks.deco.stairs.StairCreseolBrick;
import gosynmod.common.blocks.deco.stairs.StairRockBrick;
import gosynmod.common.blocks.deco.stairs.StairSpiritBrick;
import gosynmod.common.blocks.dungeons.stage2.BlockJar;
import gosynmod.common.blocks.dungeons.stage2.BlockSpiritDoor;
import gosynmod.common.blocks.dungeons.stage2.SpiritDungeonBricks;
import gosynmod.common.blocks.ground.BlockCreseolGrass;
import gosynmod.common.blocks.ground.BlockDirt;
import gosynmod.common.blocks.ground.BlockDirtyGrass;
import gosynmod.common.blocks.ground.BlockGrass;
import gosynmod.common.blocks.ground.BlockMud;
import gosynmod.common.blocks.ground.BlockRock;
import gosynmod.common.blocks.miscs.portal.BlockGosynPortal;
import gosynmod.common.blocks.miscs.portal.BlockPortalNull;
import gosynmod.common.blocks.plants.BlockCaveGrass;
import gosynmod.common.blocks.plants.stage1.BlockDoubleTallGrass;
import gosynmod.common.blocks.plants.stage1.BlockFallenLeaves;
import gosynmod.common.blocks.plants.stage1.BlockGalangal;
import gosynmod.common.blocks.plants.stage1.BlockGazania;
import gosynmod.common.blocks.plants.stage1.BlockGentian;
import gosynmod.common.blocks.plants.stage1.BlockMelynchVines;
import gosynmod.common.blocks.plants.stage1.BlockMoss;
import gosynmod.common.blocks.plants.stage1.BlockMudShortGrass;
import gosynmod.common.blocks.plants.stage1.BlockSlenderMonkey;
import gosynmod.common.blocks.plants.stage1.BlockSmallCattails;
import gosynmod.common.blocks.plants.stage1.BlockTallCattails;
import gosynmod.common.blocks.plants.stage1.BlockTallGrass;
import gosynmod.common.blocks.plants.stage2.BlockCorruptedGrass;
import gosynmod.common.blocks.plants.stage2.BlockCorruptedHangingPlant;
import gosynmod.common.blocks.plants.stage2.BlockCorruptedMoss;
import gosynmod.common.blocks.plants.stage2.BlockCreseolFern;
import gosynmod.common.blocks.plants.stage2.BlockCreseolSmallGrass;
import gosynmod.common.blocks.plants.stage2.BlockMagicMushrooom;
import gosynmod.common.blocks.tileEntity.counter.BlockSpiritCounter;
import gosynmod.common.blocks.tileEntity.magicalMushrooom.BlockMagicalMushrooom;
import gosynmod.common.blocks.tree.BlockCreseolBark;
import gosynmod.common.blocks.tree.BlockCreseolLeaves;
import gosynmod.common.blocks.tree.BlockCreseolRune1;
import gosynmod.common.blocks.tree.BlockCreseolRune2;
import gosynmod.common.blocks.tree.BlockCreseolRune3;
import gosynmod.common.blocks.tree.BlockCreseolRune4;
import gosynmod.common.blocks.tree.BlockMelynchBark;
import gosynmod.common.blocks.tree.BlockMelynchLeaves;
import gosynmod.common.blocks.tree.BlockMelynchPlanks;
import gosynmod.common.blocks.tree.BlockMushrooomStem;
import gosynmod.common.blocks.tree.mushrooomCap.BlockMushrooomCap;
import net.minecraft.block.Block;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//BLOCKS
	
	public static final Block TEST = new BlockMagicalMushrooom();
	
	public static final Block ROCK   		 = new BlockRock();
	public static final Block DIRT  		 = new BlockDirt();
	public static final Block MUD  			 = new BlockMud();
	public static final Block GRASS 		 = new BlockGrass();
	public static final Block DIRTY_GRASS	 = new BlockDirtyGrass();
	public static final Block MELYNCH_BARK   = new BlockMelynchBark();
	public static final Block MELYNCH_PLANKS = new BlockMelynchPlanks();
	public static final Block MELYNCH_LEAVES = new BlockMelynchLeaves();
	public static final Block CRESEOL_GRASS	 = new BlockCreseolGrass();
	public static final Block CRESEOL_BARK	 = new BlockCreseolBark();
	public static final Block CRESEOL_RUNE1	 = new BlockCreseolRune1();
	public static final Block CRESEOL_RUNE2	 = new BlockCreseolRune2();
	public static final Block CRESEOL_RUNE3	 = new BlockCreseolRune3();
	public static final Block CRESEOL_RUNE4	 = new BlockCreseolRune4();
	public static final Block CRESEOL_LEAVES = new BlockCreseolLeaves();
	public static final Block MUSHROOOM_STEM = new BlockMushrooomStem();
	public static final Block MUSHROOOM_CAP  = new BlockMushrooomCap();	
	
	public static final Block ROCKBRICK		 = new BlockRockBrick();
	public static final Block CRESEOLBRICK	 = new BlockCreseolBrick();
	public static final Block SPIRITBRICK	 = new SpiritDungeonBricks();
	public static final Block SPIRITDOOR	 = new BlockSpiritDoor();
	
	//TILE 
	public static final Block COUNTER = new BlockSpiritCounter();
	public static final Block LOOTJAR = new BlockJar();
	
	//STAIRS
	public static final Block ROCKBRICK_STAIR 	 = new StairRockBrick(); 
	public static final Block CRESEOLBRICK_STAIR = new StairCreseolBrick();
	public static final Block SPIRITBRICKS_STAIR = new StairSpiritBrick();
	
	//PLANTS
	public static final Block SMALL_CATTAILS = new BlockSmallCattails();
	public static final Block TALL_CATTAILS  = new BlockTallCattails();
	public static final Block TALL_GRASS	 = new BlockTallGrass();
	public static final Block DOUBLE_GRASS	 = new BlockDoubleTallGrass();
	public static final Block MELYNCH_VINES	 = new BlockMelynchVines();
	public static final Block GENTIAN		 = new BlockGentian();
	public static final Block GALANGAL		 = new BlockGalangal();
	public static final Block FALLEN_LEAVES	 = new BlockFallenLeaves();
	public static final Block MOSS			 = new BlockMoss();
	public static final Block CAVEGRASS		 = new BlockCaveGrass();
	public static final Block MUD_SHORTGRASS = new BlockMudShortGrass();
	public static final Block SLENDER_MONKEY = new BlockSlenderMonkey();
	public static final Block GAZANIA		 = new BlockGazania();
	public static final Block CRESEOL_FERN	 = new BlockCreseolFern();
	public static final Block CRESEOL_SGRASS = new BlockCreseolSmallGrass();
	public static final Block MUSHROOOM_MAG  = new BlockMagicMushrooom();
	
	public static final Block CORRUPTED_MOSS    = new BlockCorruptedMoss();
	public static final Block CORRUPTED_GRASS   = new BlockCorruptedGrass();
	public static final Block CORRUPTED_HANGING = new BlockCorruptedHangingPlant();
	
	public static final Block GOSYN_PORTAL	   = new BlockGosynPortal();
	public static final Block GOSYN_PORTALNULL = new BlockPortalNull();
}
