package gosynmod.common.blocks.plants.stage1;

import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSmallCattails extends BlockBush implements IHasModel {
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	private static String type;

	public BlockSmallCattails() {
		setUnlocalizedName("small_cattails");
		setRegistryName("small_cattails");
		setCreativeTab(Gosyn.gosynplantstab);
		setSoundType(SoundType.PLANT);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return SAPLING_AABB;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState soil = worldIn.getBlockState(pos.down());
	
		if 	(  worldIn.getBlockState(pos.west().down()) != Blocks.WATER.getDefaultState()
			&& worldIn.getBlockState(pos.east().down()) != Blocks.WATER.getDefaultState()
			&& worldIn.getBlockState(pos.south().down()) != Blocks.WATER.getDefaultState()
			&& worldIn.getBlockState(pos.north().down()) != Blocks.WATER.getDefaultState()) {
			return false;

		}

		return soil == BlockInit.MUD.getDefaultState();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	protected boolean canSustainBush(IBlockState state) {
		return true;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Blocks.AIR.getItemDropped(Blocks.AIR.getDefaultState(), rand, fortune);
	}

	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}