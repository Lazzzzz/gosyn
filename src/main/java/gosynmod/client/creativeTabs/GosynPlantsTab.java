package gosynmod.client.creativeTabs;

import gosynmod.common.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GosynPlantsTab extends CreativeTabs {
	
	public GosynPlantsTab(String label) { 
		super(label);
		this.setBackgroundImageName("item_search.png");
		
	}

	public ItemStack getTabIconItem() { 
		return new ItemStack(Item.getItemFromBlock(BlockInit.SMALL_CATTAILS));
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return true;
	}
}