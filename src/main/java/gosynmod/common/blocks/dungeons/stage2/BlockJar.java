package gosynmod.common.blocks.dungeons.stage2;

import java.util.Random;

import javax.annotation.Nullable;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.util.jar.JarLoot;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
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

public class BlockJar extends Block implements IHasModel {

	public BlockJar() {
		super(Material.GLASS);
		setUnlocalizedName("loot_jar");
		setRegistryName("loot_jar");
		setCreativeTab(Gosyn.gosybblocktab);

		this.setHardness(0.5f);
		this.setResistance(2.5f);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.GLASS);

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D);

	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(0D, 0D, 0D, 1D, 0.6D, 1D);

	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		new JarLoot().spawnLoot(worldIn, new Random(), pos);
		super.onBlockDestroyedByPlayer(worldIn, pos, state);
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Blocks.AIR.getItemDropped(Blocks.AIR.getDefaultState(), rand, fortune);
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
