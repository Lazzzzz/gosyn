package gosynmod.common.items.tools;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.item.ItemPickaxe;

public class ToolsMelynchPickaxe extends ItemPickaxe implements IHasModel
{
	public ToolsMelynchPickaxe() 
	{
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_pickaxe");
		setRegistryName("melynch_pickaxe");
		setCreativeTab(Gosyn.gosybtoolstab);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() 
	{
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}