package gosynmod.common.blocks.tree;

import java.util.List;
import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.interfaces.ParticleTypes;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMelynchLeaves extends BlockLeaves implements IHasModel {
	public static String type;

	public BlockMelynchLeaves() {
		setUnlocalizedName("melynch_leaves");
		setRegistryName("melynch_leaves");
		setSoundType(SoundType.PLANT);
		setCreativeTab(Gosyn.gosybblocktab);
		setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true))
				.withProperty(DECAYABLE, Boolean.valueOf(true)));
		Blocks.FIRE.setFireInfo(this, 5, 5);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	/*
	 * @Override public Item getItemDropped(IBlockState state, Random rand, int
	 * fortune) { return Item.getItemFromBlock(BlockInit.SAPLING_COPPIR);
	 * 
	 * }
	 */

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue())
			i |= 2;
		if (!((Boolean) state.getValue(CHECK_DECAY)).booleanValue())
			i |= 4;
		return i;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		if (rand.nextInt(30) == 0) {
			if (worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()) {
				double x = rand.nextDouble();
				double z = rand.nextDouble();
				Gosyn.proxy.spawnParticle(worldIn, ParticleTypes.FALLING_LEAF, pos.getX() + x, pos.getY(),
						pos.getZ() + z, 0.05f, -0.1f, 0);
			}
		}
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(this);
	}

	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		return;
	}

	@Override
	protected int getSaplingDropChance(IBlockState state) {
		return 30;
	}

	@Override
	public net.minecraft.block.BlockPlanks.EnumType getWoodType(int meta) {
		return null;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return NonNullList.withSize(1, new ItemStack(this));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { CHECK_DECAY, DECAYABLE });
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		return true;
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}