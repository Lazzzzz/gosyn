package gosynmod.common.items;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemAiguiteGem extends Item implements IHasModel {
	public ItemAiguiteGem() {
		setUnlocalizedName("aiguite_gem");
		setRegistryName("aiguite_gem");
		setCreativeTab(Gosyn.gosybitemstab);
		setMaxStackSize(64);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
