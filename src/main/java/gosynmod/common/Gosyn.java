package gosynmod.common;

import java.io.File;

import gosynmod.client.creativeTabs.GosynBlocksTab;
import gosynmod.client.creativeTabs.GosynItemsTab;
import gosynmod.client.creativeTabs.GosynToolsTab;
import gosynmod.common.handlers.RegistryHandler;
import gosynmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Gosyn 
{
	
	public static File config;
	
	@Instance
	public static Gosyn instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMOM_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs gosybblocktab = new GosynBlocksTab("gosynBlock");
	public static final CreativeTabs gosybitemstab = new GosynItemsTab("gosynItems");
	public static final CreativeTabs gosybtoolstab = new GosynToolsTab("gosynTools");
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		RegistryHandler.postInitRegistries(event);
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}
}

