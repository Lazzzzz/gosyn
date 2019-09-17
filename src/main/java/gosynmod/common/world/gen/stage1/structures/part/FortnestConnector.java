package gosynmod.common.world.gen.stage1.structures.part;

import java.util.Random;

import gosynmod.common.Reference;
import gosynmod.common.init.BlockInit;
import gosynmod.common.interfaces.IStructure;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public class FortnestConnector extends WorldGenerator implements IStructure {
	public String structureName;

	public FortnestConnector() {
		this.structureName = "dungeons/stage1/connector";
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		return true;
	}

	public boolean generate(World worldIn, Random rand, BlockPos position, boolean[] walls) {
		this.generateStructure(worldIn, position, walls);
		return true;
	}

	public void generateStructure(World world, BlockPos pos1, boolean[] walls) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);

		int x2 = (template.getSize().getX() / 2);
		int z2 = (template.getSize().getZ() / 2);

		BlockPos pos = new BlockPos(pos1.getX() - x2, pos1.getY(), pos1.getZ() - z2);

		if (template != null) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));
			if (walls[0] == true) {
				for (int i = 1; i < 7; i++) {
					for (int j = 1; j < 4; j++) {
						world.setBlockState(pos.add(0, j, i), BlockInit.FORTNEST_WALLS.getStateFromMeta(j-1));
					}
				}
			}
			if (walls[1] == true) {
				for (int i = 1; i < 7; i++) {
					for (int j = 1; j < 4; j++) {
						world.setBlockState(pos.add(7, j, i),BlockInit.FORTNEST_WALLS.getStateFromMeta(j-1));
					}
				}
			}
			if (walls[2] == true) {
				for (int i = 1; i < 7; i++) {
					for (int j = 1; j < 4; j++) {
						world.setBlockState(pos.add(i, j, 0), BlockInit.FORTNEST_WALLS.getStateFromMeta(j-1));
					}
				}

			}
			if (walls[3] == true) {
				for (int i = 1; i < 7; i++) {
					for (int j = 1; j < 4; j++) {
						world.setBlockState(pos.add(i, j, 7), BlockInit.FORTNEST_WALLS.getStateFromMeta(j-1));
					}
				}
			}

		}
	}
}
