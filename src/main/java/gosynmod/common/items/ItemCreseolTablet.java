package gosynmod.common.items;

import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCreseolTablet extends Item implements IHasModel {

	private Random rand = new Random();

	public ItemCreseolTablet() {
		setUnlocalizedName("creseol_tablet");
		setRegistryName("creseol_tablet");
		setCreativeTab(Gosyn.gosybitemstab);
		setMaxStackSize(1);
		setMaxDamage(100);

		ItemInit.ITEMS.add(this);

	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (entityIn instanceof EntityPlayer && !worldIn.isRemote) {

			EntityPlayer player = (EntityPlayer) entityIn;
			if (this.rand.nextInt(150) == 0 && !player.isCreative()) {
				stack.damageItem(1, player);
				if (stack.getItemDamage() == 0) {
					if (player.getHeldItemOffhand() == stack) {
						player.setHeldItem(EnumHand.OFF_HAND, new ItemStack(ItemInit.CRESEOL_TABLET_EMPTY));
					} else
						player.replaceItemInInventory(itemSlot, new ItemStack(ItemInit.CRESEOL_TABLET_EMPTY));
				}
			}
		}
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
