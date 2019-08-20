package gosynmod.common.blocks.tileEntity.magicalMushrooom;

import javax.annotation.Nullable;

import gosynmod.common.Gosyn;
import gosynmod.common.blocks.tileEntity.BlockTileEntity;
import gosynmod.common.blocks.tileEntity.counter.TileEntitySpiritCounter;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;

public class BlockMagicalMushrooom extends BlockTileEntity<TileEntityMagicalMushroooms> implements IHasModel{

	public BlockMagicalMushrooom() {
		super(Material.ROCK);
		setUnlocalizedName("mushro");
		setRegistryName("mushro");
		setCreativeTab(Gosyn.gosybblocktab);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public Class<TileEntityMagicalMushroooms> getTileEntityClass() {
		return TileEntityMagicalMushroooms.class;
	}

	@Nullable
	@Override
	public TileEntityMagicalMushroooms createTileEntity(World world, IBlockState state) {
		return new TileEntityMagicalMushroooms();
	}
	
	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
