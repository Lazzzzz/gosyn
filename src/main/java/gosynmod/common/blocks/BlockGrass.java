package gosynmod.common.blocks;

import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;

public class BlockGrass extends Block implements IHasModel{

	public BlockGrass() {
		super(Material.GRASS);
		setUnlocalizedName("gosyn_grass");
		setRegistryName("gosyn_grass");
		setCreativeTab(Gosyn.gosybblocktab);
		
		
		this.setHardness(0.6f);
		this.setResistance(3f);	
		this.setHarvestLevel("shovel", 0);
		this.setSoundType(SoundType.GROUND);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return BlockInit.DIRT.getItemDropped(BlockInit.DIRT.getDefaultState(), rand, fortune);
	}
	

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
		return true;
	}
	
	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}
	



}
