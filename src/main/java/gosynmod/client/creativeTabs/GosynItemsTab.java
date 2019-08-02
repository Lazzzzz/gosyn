package gosynmod.client.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GosynItemsTab extends CreativeTabs {
	
	public GosynItemsTab(String label) { 
		super(label);
		this.setBackgroundImageName("item_search.png");
		
	}

	public ItemStack getTabIconItem() { 
		return new ItemStack(Items.APPLE);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return true;
	}
}