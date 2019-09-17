package gosynmod.common.blocks.ore;

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

public class BlockOreAiguite extends Block implements IHasModel {

	public BlockOreAiguite() {
		super(Material.ROCK);
		setUnlocalizedName("ore_aiguite");
		setRegistryName("ore_aiguite");
		setCreativeTab(Gosyn.gosybblocktab);

		this.setHardness(1.5f);
		this.setResistance(30f);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemInit.AIGUITE_GEM;

	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return random.nextInt(1) + 1;
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return true;
	}

}
