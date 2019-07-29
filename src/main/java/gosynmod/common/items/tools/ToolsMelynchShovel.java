package gosynmod.common.items.tools;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ToolsMelynchShovel extends ItemSpade implements IHasModel
{
	public ToolsMelynchShovel() 
	{
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_shovel");
		setRegistryName("melynch_shovel");
		setCreativeTab(Gosyn.gosybtoolstab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}