package ch.fire.urban;

import ch.fire.urban.gui.GameOverlayHandler;
import ch.fire.urban.init.BlockMod;
import ch.fire.urban.init.ItemMod;
import ch.fire.urban.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)


public class Main {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	
	
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		ItemMod.init();
		ItemMod.register();
		BlockMod.init();
		BlockMod.register();
		
	}
	
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GameOverlayHandler());
		proxy.RegisterRenders();
		
	}
	
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		
	}
}
