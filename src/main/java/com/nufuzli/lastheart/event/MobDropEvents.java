package com.nufuzli.lastheart.event;

import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Warden;
import net.minecraft.world.entity.monster.RavagerCreeper;
import net.minecraft.world.entity.guardian.ElderGuardian;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Enderman;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.nufuzli.lastheart.LastHeartMod;
import com.nufuzli.lastheart.item.ModItems;

@Mod.EventBusSubscriber(modid = LastHeartMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobDropEvents {

    @SubscribeEvent
    public static void onMobDrop(LivingDropsEvent event) {
        if (event.getEntity().level().isClientSide) return;
        
        java.util.Random random = event.getEntity().level().random;

        // Half-Heart drops (20% - 100%)
        if (event.getEntity() instanceof WitherBoss) {
            if (random.nextInt(100) < 20) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HALF_HEART.get())));
            }
        } else if (event.getEntity() instanceof EnderDragon) {
            // 100% drop
            event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                new ItemStack(ModItems.HALF_HEART.get())));
        } else if (event.getEntity() instanceof ElderGuardian) {
            if (random.nextInt(100) < 25) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HALF_HEART.get())));
            }
        } else if (event.getEntity() instanceof Warden) {
            if (random.nextInt(100) < 25) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HALF_HEART.get())));
            }
        }

        // Heart-Tier drops (0.5% - 15%)
        if (event.getEntity() instanceof IronGolem) {
            if (random.nextInt(200) == 0) { // 0.5%
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof Witch) {
            if (random.nextInt(100) < 5) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof WitherSkeleton) {
            if (random.nextInt(100) < 15) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof PiglinBrute) {
            if (random.nextInt(100) < 10) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof Vindicator) {
            if (random.nextInt(100) < 10) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof Evoker) {
            if (random.nextInt(100) < 10) {
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        } else if (event.getEntity() instanceof Enderman) {
            if (random.nextInt(100) < 1) { // 1%
                event.getDrops().add(new net.minecraftforge.event.entity.living.LivingDropsEvent.EntityItemContainer(
                    new ItemStack(ModItems.HEART_TIER.get())));
            }
        }
    }
}
