package gosynmod.common.blocks.dungeons.stage1;

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

public class BlockFortnestBrick extends Block implements IHasModel, IMetaName{

	public static final PropertyEnum<enumFortnestBrickWalls.EnumType> VARIANT = PropertyEnum.<enumFortnestBrickWalls.EnumType>create(
			"variant", enumFortnestBrickWalls.EnumType.class);
	
	public BlockFortnestBrick() {
		super(Material.ROCK);
		setUnlocalizedName("fortnest_brick");
		setRegistryName("fortnest_brick");
		setCreativeTab(Gosyn.gosybblocktab);
		
		
		this.setHardness(1.5f);
		this.setResistance(30f);	
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
		
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, enumFortnestBrickWalls.EnumType.VARIANT_0));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public int damageDropped(IBlockState state) {
		return ((enumFortnestBrickWalls.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((enumFortnestBrickWalls.EnumType) state.getValue(VARIANT)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, enumFortnestBrickWalls.EnumType.byMetadata(meta));
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (enumFortnestBrickWalls.EnumType variant : enumFortnestBrickWalls.EnumType.values()) {
			items.add(new ItemStack(this, 1, variant.getMeta()));

		}
	}

	@Override
	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return enumFortnestBrickWalls.EnumType.values()[stack.getItemDamage()].getName();

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < enumFortnestBrickWalls.EnumType.values().length; i++) {

			Gosyn.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
					"fortnest_brick_" + i, "inventory");
		}

	}
}
