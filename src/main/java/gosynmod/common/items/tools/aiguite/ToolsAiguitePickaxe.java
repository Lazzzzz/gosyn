package gosynmod.common.items.tools.aiguite;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.init.ToolsTypeInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.items.tools.base.ToolsGosynPickaxe;

public class ToolsAiguitePickaxe extends ToolsGosynPickaxe implements IHasModel
{
	public ToolsAiguitePickaxe() 
	{
		super(ToolsTypeInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_pickaxe");
		setRegistryName("aiguite_pickaxe");
		setCreativeTab(Gosyn.gosybtoolstab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}