package gosynmod.common.items.tools.melynch;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.items.tools.base.ToolsGosynShovel;
import net.minecraft.item.ItemSpade;

public class ToolsMelynchShovel extends ToolsGosynShovel implements IHasModel
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