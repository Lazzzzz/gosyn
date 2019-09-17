package gosynmod.common.blocks.dungeons.stage2;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSpiritPad extends Block{
	public BlockSpiritPad() {
		super(Material.ROCK);
		setUnlocalizedName("spirit_pad");
		setRegistryName("spirit_pad");
		setCreativeTab(Gosyn.gosybblocktab);
		
		
		this.setBlockUnbreakable();
		this.setSoundType(SoundType.STONE);
		
		BlockInit.BLOCKS.add(this);
	}
	
}
