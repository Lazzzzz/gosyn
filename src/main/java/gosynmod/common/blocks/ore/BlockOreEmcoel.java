package gosynmod.common.blocks.ore;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockOreEmcoel extends Block implements IHasModel{

	public BlockOreEmcoel() {
		super(Material.ROCK);
		setUnlocalizedName("ore_emcoal");
		setRegistryName("ore_emcoal");
		setCreativeTab(Gosyn.gosybblocktab);
		
		
		this.setHardness(1.5f);
		this.setResistance(30f);	
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
