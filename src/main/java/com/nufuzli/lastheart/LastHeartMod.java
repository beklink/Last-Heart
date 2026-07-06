package com.nufuzli.lastheart;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;
import com.nufuzli.lastheart.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("lastheart")
public class LastHeartMod {
    public static final String MODID = "lastheart";
    private static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public LastHeartMod() {
        IEventBus modEventBus = FXModLoadingContext.getInstance().getModEventBus();
        
        ModItems.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);

        LOGGER.info("Last Heart Mod loaded!");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Last Heart Mod common setup complete!");
    }
}
