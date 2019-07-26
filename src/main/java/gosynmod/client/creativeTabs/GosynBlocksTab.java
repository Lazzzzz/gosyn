package gosynmod.client.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GosynBlocksTab extends CreativeTabs {
	
	public GosynBlocksTab(String label) { 
		super(label);
		this.setBackgroundImageName("item_search.png");
		
	}

	public ItemStack getTabIconItem() { 
		return new ItemStack(Item.getItemFromBlock(Blocks.BRICK_BLOCK));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return true;
	}
}