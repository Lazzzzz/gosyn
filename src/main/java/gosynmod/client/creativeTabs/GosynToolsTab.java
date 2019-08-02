package gosynmod.client.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GosynToolsTab extends CreativeTabs {
	
	public GosynToolsTab(String label) { 
		super(label);
		this.setBackgroundImageName("item_search.png");
		
	}

	public ItemStack getTabIconItem() { 
		return new ItemStack(Items.STONE_PICKAXE);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasSearchBar() {
		return true;
	}
}