package com.nufuzli.lastheart.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.nufuzli.lastheart.LastHeartMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, LastHeartMod.MODID);

    // Heart Soul - crafted item for creating extra hearts
    public static final RegistryObject<Item> HEART_SOUL = ITEMS.register("heart_soul",
        () -> new Item(new Item.Properties()
            .stacksTo(64)));

    // Half Heart - dropped from special mobs
    public static final RegistryObject<Item> HALF_HEART = ITEMS.register("half_heart",
        () -> new Item(new Item.Properties()
            .stacksTo(64)));

    // Heart Tier - crafting material for half heart
    public static final RegistryObject<Item> HEART_TIER = ITEMS.register("heart_tier",
        () -> new Item(new Item.Properties()
            .stacksTo(64)));

    // Extra Heart - final craftable heart item
    public static final RegistryObject<Item> EXTRA_HEART = ITEMS.register("extra_heart",
        () -> new Item(new Item.Properties()
            .stacksTo(10)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
