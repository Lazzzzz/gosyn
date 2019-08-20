package gosynmod.common.items.tools.aiguite;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.init.ToolsTypeInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.items.tools.base.ToolsGosynSword;

public class ToolsAiguiteSword extends ToolsGosynSword implements IHasModel {
	public ToolsAiguiteSword() {
		super(ToolsTypeInit.AIGUITE_TOOL);
		setUnlocalizedName("aiguite_sword");
		setRegistryName("aiguite_sword");
		setCreativeTab(Gosyn.gosybtoolstab);

		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}