package gosynmod.common.blocks.tree;

import java.util.List;
import java.util.Random;

import gosynmod.common.Gosyn;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCreseolRune3 extends Block implements IHasModel{

	private Random rand = new Random();
	
	public BlockCreseolRune3() {
		super(Material.WOOD);
		setUnlocalizedName("creseol_rune3");
		setRegistryName("creseol_rune3");
		setCreativeTab(Gosyn.gosybblocktab);
		Blocks.FIRE.setFireInfo(this, 5, 5);
		
		this.setHardness(2f);
		this.setResistance(10f);	
		this.setHarvestLevel("axe", 0);
		this.setSoundType(SoundType.WOOD);
		this.setTickRandomly(true);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if (!worldIn.isRemote) {
			if (playerIn.inventory.getCurrentItem().getItem() == ItemInit.CRESEOL_TABLET_EMPTY
					&& hand == EnumHand.MAIN_HAND) {
				if (rand.nextInt(5) == 0) {
					playerIn.setHeldItem(hand, new ItemStack(ItemInit.CRESEOL_TABLET));
					worldIn.setBlockState(pos, BlockInit.CRESEOL_BARK.getDefaultState());
					worldIn.setBlockState(pos, BlockInit.CRESEOL_BARK.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));

					return true;
				} else {
					worldIn.setBlockState(pos, BlockInit.CRESEOL_BARK.getDefaultState());
					worldIn.setBlockState(pos, BlockInit.CRESEOL_BARK.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y));

					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return BlockInit.CRESEOL_BARK.getItemDropped(BlockInit.CRESEOL_BARK.getDefaultState(), rand, fortune);
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		world.scheduleUpdate(pos, this, this.tickRate(world));

	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		AxisAlignedBB box = new AxisAlignedBB(pos.getX() - 5, pos.getY() - 5, pos.getZ() - 5, pos.getX() + 5,
				pos.getY() + 5, pos.getZ() + 5);

		List list = worldIn.getEntitiesWithinAABB(EntityPlayer.class, box);
		if (!list.isEmpty()) {

			for (int i = 0; i <= list.size() - 1; i++) {
				((EntityLivingBase) list.get(i))
						.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 100, 0, false, false));
			}

		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public int tickRate(World world) {
		return 200;
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		return false;
	}

	@Override
	public void registerModels() {
		Gosyn.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		for (int i = 0; i < 5; i++) {
			double x = pos.getX() + rand.nextFloat();
			double y = pos.getY() + rand.nextFloat();
			double z = pos.getZ() + rand.nextFloat();
			double vx = rand.nextDouble() - 0.5;
			double vy = rand.nextDouble() - 0.5;
			double vz = rand.nextDouble() - 0.5;

			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, y, z, vx, vy, vz);
		}

		super.randomDisplayTick(stateIn, worldIn, pos, rand);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

}
