package gosynmod.common.world.gen.stage2.structures;

import java.util.Random;

import gosynmod.common.Reference;
import gosynmod.common.init.BlockInit;
import gosynmod.common.interfaces.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class GenSpiritDungeon extends WorldGenerator implements IStructure {
	public String structureName;
	int sizeX;
	int sizeZ;

	public GenSpiritDungeon() {
		this.structureName = "spirit_dungeon";
		this.sizeX = 29;
		this.sizeZ = 29;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position, rand);
		return true;
	}

	private boolean checkForSawn(Template template, World world, BlockPos pos) {
		boolean flag = true;

		BlockPos down = pos.add(0, -1, 0);
		if (world.getBlockState(down).isFullBlock() == false)
			return false;
		down = pos.add(0, -1, sizeZ);
		if (world.getBlockState(down).isFullBlock() == false)
			return false;
		down = pos.add(sizeX, -1, sizeZ);
		if (world.getBlockState(down).isFullBlock() == false)
			return false;
		down = pos.add(sizeX, -1, 0);
		if (world.getBlockState(down).isFullBlock() == false)
			return false;
		
		for (int i = 0; i < sizeX + 1; i++) {
			for (int j = 0; j < sizeZ + 1; j++) {
				for (int k = 3; k < 5; k++) {
					BlockPos top = pos.add(i, k, j);
					if (world.getBlockState(top) == world.getBiome(top).fillerBlock)
						return false;
					if (world.getBlockState(top) == world.getBiome(top).topBlock)
						return false;

				}

			}
		}

		return true;

	}

	public void generateStructure(World world, BlockPos pos, Random rand) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, "dungeons/" + structureName);
		Template template = manager.get(mcServer, location);

		int x2 = (template.getSize().getX());
		int y2 = (template.getSize().getY());
		int z2 = (template.getSize().getZ());

		boolean canPlace = checkForSawn(template, world, pos);
		if (canPlace) {
			System.out.println(pos.getX() + " " + pos.getY() + " " + pos.getZ());
			generarePlatform(world, pos, rand);
			IBlockState state = world.getBlockState(pos.up());
			world.notifyBlockUpdate(pos.up(), state, state, 3);
			template.addBlocksToWorldChunk(world, pos.up(), settings.setRotation(Rotation.NONE));
			generateDecoration(world, pos.up(), rand);
		}
	}

	public void generarePlatform(World world, BlockPos pos, Random rand) {
		IBlockState TOP = world.getBiome(pos).topBlock;

		for (int i = 0; i < 29; i++) {
			for (int j = 0; j < 29; j++) {
				if (!world.getBlockState(pos.add(i, 0, j)).isFullBlock()) {
					world.setBlockState(pos.add(i, 0, j), TOP);
				}
			}
		}
	}

	public void generateDecoration(World world, BlockPos pos, Random rand) {
		for (int i = 0; i < 29; i++) {
			for (int j = 0; j < 29; j++) {
				for (int k = 0; k < 18; k++) {
					BlockPos p = pos.add(i, k, j);
					if (world.getBlockState(p) == Blocks.AIR.getDefaultState()) {
						if (rand.nextInt(5) == 0) {
							if (world.getBlockState(p.up()).isFullBlock())
								world.setBlockState(p, BlockInit.CORRUPTED_HANGING.getDefaultState());
							else if (world.getBlockState(p.down()).isFullBlock()) {
								if (rand.nextBoolean())
									world.setBlockState(p, BlockInit.CORRUPTED_MOSS.getDefaultState());
								else
									world.setBlockState(p, BlockInit.CORRUPTED_GRASS.getDefaultState());
							}

						}
					} else if (world.getBlockState(p) == BlockInit.LOOTJAR.getDefaultState()) {
						if (rand.nextBoolean())
							world.setBlockToAir(p);

					} else if (world.getBlockState(p).getBlock() == Blocks.CHEST) {
						if (rand.nextBoolean())
							world.setBlockToAir(p);
					}
				}
			}
		}
	}
}