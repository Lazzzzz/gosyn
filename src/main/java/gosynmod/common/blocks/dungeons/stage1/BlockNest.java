package gosynmod.common.blocks.dungeons.stage1;

import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNest extends Block implements IHasModel {

	public BlockNest() {
		super(Material.ROCK);
		setUnlocalizedName("nest_block");
		setRegistryName("nest_block");
		setCreativeTab(Gosyn.gosybblocktab);

		this.setHardness(2f);
		this.setResistance(30f);
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.CLOTH);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
