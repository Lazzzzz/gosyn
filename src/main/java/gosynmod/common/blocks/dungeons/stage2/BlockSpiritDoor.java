package gosynmod.common.blocks.dungeons.stage2;

import javax.annotation.Nullable;

import gosynmod.common.blocks.miscs.portal.enumPortal;
import gosynmod.common.init.BlockInit;
import gosynmod.common.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockSpiritDoor extends Block implements IMetaName {

	public static final PropertyEnum<enumPortal.EnumType> VARIANT = PropertyEnum.<enumPortal.EnumType>create("variant",
			enumPortal.EnumType.class);

	public BlockSpiritDoor() {
		super(Material.PORTAL);
		setUnlocalizedName("spirit_door");
		setRegistryName("spirit_door");

		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumPortal.EnumType.X));
		this.setSoundType(SoundType.GLASS);
		this.setBlockUnbreakable();
		BlockInit.BLOCKS.add(this);

	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		 switch ((enumPortal.EnumType)state.getValue(VARIANT)) {
         case X:
        	 return new AxisAlignedBB(-1D, -1D, 0D, 2D, 2D, 1D);
         default:
        	 return new AxisAlignedBB(0D, -1D, -1D, 1D, 2D, 2D);
		}

		
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		 switch ((enumPortal.EnumType)blockState.getValue(VARIANT)) {
         case X:
        	 return new AxisAlignedBB(-1D, -1D, 0D, 2D, 2D, 1D);
         default:
        	 return new AxisAlignedBB(0D, -1D, -1D, 1D, 2D, 2D);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumPortal.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumPortal.EnumType.byMetadata(meta));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumPortal.EnumType variant : enumPortal.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumPortal.EnumType.values()[stack.getItemDamage()].getName();

	}

}
