package gosynmod.common.blocks.tileEntity.counter;

import javax.annotation.Nullable;

import gosynmod.common.blocks.tileEntity.BlockTileEntity;
import gosynmod.common.init.BlockInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class BlockSpiritCounter extends BlockTileEntity<TileEntitySpiritCounter> {

	public BlockSpiritCounter() {
		super(Material.ROCK);
		setUnlocalizedName("counter");
		setRegistryName("counter");
		BlockInit.BLOCKS.add(this);
	}

	@Override
	public Class<TileEntitySpiritCounter> getTileEntityClass() {
		return TileEntitySpiritCounter.class;
	}

	@Nullable
	@Override
	public TileEntitySpiritCounter createTileEntity(World world, IBlockState state) {
		return new TileEntitySpiritCounter();
	}


}
