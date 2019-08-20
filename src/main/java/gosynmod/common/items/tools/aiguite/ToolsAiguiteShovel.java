package gosynmod.common.items.tools.aiguite;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.init.ToolsTypeInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.item.ItemSpade;

public class ToolsAiguiteShovel extends ItemSpade implements IHasModel
{
	public ToolsAiguiteShovel() 
	{
		super(ToolsTypeInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_shovel");
		setRegistryName("aiguite_shovel");
		setCreativeTab(Gosyn.gosybtoolstab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}