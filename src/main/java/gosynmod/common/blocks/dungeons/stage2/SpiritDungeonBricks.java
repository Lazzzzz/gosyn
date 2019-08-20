package gosynmod.common.blocks.dungeons.stage2;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpiritDungeonBricks extends Block implements IHasModel, IMetaName{

	public static final PropertyEnum<enumSpiritBricks.EnumType> VARIANT = PropertyEnum.<enumSpiritBricks.EnumType>create(
			"variant", enumSpiritBricks.EnumType.class);
	
	public SpiritDungeonBricks() {
		super(Material.ROCK);
		setUnlocalizedName("spirit_bricks");
		setRegistryName("spirit_bricks");
		setCreativeTab(Gosyn.gosybblocktab);
		
		
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumSpiritBricks.EnumType.VARIANT_0));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumSpiritBricks.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumSpiritBricks.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumSpiritBricks.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumSpiritBricks.EnumType variant : enumSpiritBricks.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumSpiritBricks.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumSpiritBricks.EnumType.values().length; i++) {

			Gosyn.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"spirit_bricks_" + i, "inventory");
		}

	}

}
