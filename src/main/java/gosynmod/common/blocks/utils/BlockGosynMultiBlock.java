package gosynmod.common.blocks.utils;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGosynMultiBlock extends Block{

	public BlockGosynMultiBlock() {
		super(Material.ROCK);
		setUnlocalizedName("multi_block");
		setRegistryName("multi_block");
		
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);

		BlockInit.BLOCKS.add(this);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}
	
	
	
}
