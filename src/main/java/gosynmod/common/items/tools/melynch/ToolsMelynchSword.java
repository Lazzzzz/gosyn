package gosynmod.common.items.tools.melynch;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.items.tools.base.ToolsGosynSword;

public class ToolsMelynchSword extends ToolsGosynSword implements IHasModel {
	public ToolsMelynchSword() {
		super(ToolMaterial.WOOD);
		setUnlocalizedName("melynch_sword");
		setRegistryName("melynch_sword");
		setCreativeTab(Gosyn.gosybtoolstab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}