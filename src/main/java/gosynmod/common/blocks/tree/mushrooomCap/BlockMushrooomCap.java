package gosynmod.common.blocks.tree.mushrooomCap;

import gosynmod.common.Gosyn;
import gosynmod.common.blocks.ItemBlockVariants;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import gosynmod.common.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockMushrooomCap extends Block implements IHasModel, IMetaName{

	public static final PropertyEnum<enumMushrooom.EnumType> VARIANT = PropertyEnum.<enumMushrooom.EnumType>create(
			"variant", enumMushrooom.EnumType.class);
	
	public BlockMushrooomCap() {
		super(Material.WOOD);
		setUnlocalizedName("mushrooom_cap");
		setRegistryName("mushrooom_cap");
		setCreativeTab(Gosyn.gosybblocktab);
		Blocks.FIRE.setFireInfo(this, 5, 5);
		
		this.setHardness(2f);
		this.setResistance(15f);	
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumMushrooom.EnumType.VARIANT_0));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumMushrooom.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumMushrooom.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumMushrooom.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumMushrooom.EnumType variant : enumMushrooom.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumMushrooom.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumMushrooom.EnumType.values().length; i++) {

			Gosyn.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"mushrooom_cap_" + i, "inventory");
		}

	}
	
}
