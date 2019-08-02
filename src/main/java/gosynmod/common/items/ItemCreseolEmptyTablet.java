package gosynmod.common.items;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemCreseolEmptyTablet extends Item implements IHasModel {
	public ItemCreseolEmptyTablet() {
		setUnlocalizedName("creseol_empty_tablet");
		setRegistryName("creseol_empty_tablet");
		setCreativeTab(Gosyn.gosybitemstab);
		setMaxStackSize(1);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
