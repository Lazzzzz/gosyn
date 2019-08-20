package gosynmod.common.items;

import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.world.gen.stage2.structures.GenSpiritDungeon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDebug extends Item implements IHasModel {
	public ItemDebug() {
		setUnlocalizedName("debug");
		setRegistryName("debug");
		setCreativeTab(Gosyn.gosybitemstab);
		setMaxStackSize(1);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");

	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		if (!worldIn.isRemote) {
			new GenSpiritDungeon().generate(worldIn, new Random(), playerIn.getPosition());
		}

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
