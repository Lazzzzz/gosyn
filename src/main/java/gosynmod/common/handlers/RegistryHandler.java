package gosynmod.common.handlers;

import gosynmod.common.Gosyn;
import gosynmod.common.Reference;
import gosynmod.common.init.BlockInit;
import gosynmod.common.init.ItemInit;
import gosynmod.common.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();

	}

	@SubscribeEvent
	public static void registerEnchantment(RegistryEvent.Register<Enchantment> event) {
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		RenderHandler.registerEntityRenders();

		for (Item item : ItemInit.ITEMS) {
			if (item instanceof IHasModel) {
				((IHasModel) item).registerModels();
			}
		}
		for (Block block : BlockInit.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}
	}

	public static void preInitRegistries(FMLPreInitializationEvent event) {

		//GameRegistry.registerWorldGenerator(new WorldGenCustomOre(), 0);

		//BiomeInit.registerBiomes();
		//DimensionInit.registerDimensions();
		//EntityInit.registerEntitites();
		//ConfigHandler.registerConfig(event);

	}

	public static void initRegistries(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Gosyn.instance, new GuiHandler());
		//OreDictionnarCompat.registerOres();

	}

	public static void postInitRegistries(FMLPostInitializationEvent event) {
	}

	public static void serverRegistries(FMLServerStartingEvent event) {
		//event.registerServerCommand(new CommandTeleportDimension());
	}
}
