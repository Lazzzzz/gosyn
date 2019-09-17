package gosynmod.common.blocks.plants.stage2;

import javax.annotation.Nullable;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCorruptedGrass extends Block implements IHasModel{

	public BlockCorruptedGrass() {
		super(Material.VINE);
		setUnlocalizedName("corrupted_grass");
		setRegistryName("corrupted_grass");
		setCreativeTab(Gosyn.gosynplantstab);
		
		
		this.setHardness(0.1f);
		this.setResistance(0.1f);	
		this.setSoundType(SoundType.PLANT);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
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
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (worldIn.getBlockState(pos.down()).isFullBlock() == false) worldIn.destroyBlock(pos, true);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.down()).isFullBlock();
	}
	
	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}
}
