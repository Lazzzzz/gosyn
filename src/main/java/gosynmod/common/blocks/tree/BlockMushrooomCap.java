package gosynmod.common.blocks.tree;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockMushrooomCap extends Block implements IHasModel{

	public BlockMushrooomCap() {
		super(Material.WOOD);
		setUnlocalizedName("mushrooom_cap");
		setRegistryName("mushrooom_cap");
		setCreativeTab(Gosyn.gosybblocktab);
		Blocks.FIRE.setFireInfo(this, 5, 5);
		
		this.setHardness(2f);
		this.setResistance(15f);	
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
