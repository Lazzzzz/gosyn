package gosynmod.common.items;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemMelynchStick extends Item implements IHasModel {
	public ItemMelynchStick() {
		setUnlocalizedName("melynch_stick");
		setRegistryName("melynch_stick");
		setCreativeTab(Gosyn.gosybitemstab);
		setMaxStackSize(64);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
