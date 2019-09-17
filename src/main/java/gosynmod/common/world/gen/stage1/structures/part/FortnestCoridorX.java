package gosynmod.common.world.gen.stage1.structures.part;

import java.util.Random;

import gosynmod.common.Reference;
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

public class FortnestCoridorX extends WorldGenerator implements IStructure {
	public String structureName;


	public FortnestCoridorX() {
		this.structureName = "dungeons/stage1/coridor_x";
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return true;
	}

	public void generateStructure(World world, BlockPos pos1) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
		Template template = manager.get(mcServer, location);

		int x2 = (template.getSize().getX()/2);
		int z2 = (template.getSize().getZ()/2);
		
		BlockPos pos = new BlockPos(pos1.getX() - x2, pos1.getY(), pos1.getZ() - z2);

		if (template != null) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			int i = 0;
			if (i == 0)
				template.addBlocksToWorldChunk(world, pos, settings.setRotation(Rotation.NONE));
			
		}
	}
}
