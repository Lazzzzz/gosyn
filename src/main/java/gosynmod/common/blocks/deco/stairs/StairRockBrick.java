package gosynmod.common.blocks.deco.stairs;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class StairRockBrick extends BlockStairs implements IHasModel{

	public StairRockBrick() {
		super(BlockInit.ROCKBRICK.getDefaultState());
			setUnlocalizedName("rock_brick_stair");
			setRegistryName("rock_brick_stair");
			setCreativeTab(Gosyn.gosybblocktab);
			
			this.setHardness(1.5f);
			this.setResistance(30f);	
			this.setHarvestLevel("pickaxe", 0);
			this.setSoundType(SoundType.STONE);
			
			this.useNeighborBrightness = true;
			
			BlockInit.BLOCKS.add(this);
			ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
			
				
		}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
		

}
