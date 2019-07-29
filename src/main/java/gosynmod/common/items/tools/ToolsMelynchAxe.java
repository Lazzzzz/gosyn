package gosynmod.common.items.tools;

import java.util.Set;

import com.google.common.collect.Sets;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ToolsMelynchAxe extends ItemTool implements IHasModel {
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG,
			Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER,
			Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, BlockInit.MELYNCH_BARK, BlockInit.MELYNCH_PLANKS);

	public ToolsMelynchAxe() {
		super(ToolMaterial.WOOD, EFFECTIVE_ON);
		setUnlocalizedName("melynch_axe");
		setRegistryName("melynch_axe");
		setCreativeTab(Gosyn.gosybtoolstab);
		this.attackSpeed = -3.0F;

		ItemInit.ITEMS.add(this);
	}

	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? 1
				: this.toolMaterial.getEfficiency();
	}
	
	@Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getDestroySpeed(stack, state) : this.efficiency;
    }
	

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(this, 0, "inventory");
	}
}