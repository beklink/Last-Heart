package com.nufuzli.lastheart.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import com.nufuzli.lastheart.LastHeartMod;
import com.nufuzli.lastheart.item.ModItems;
import com.nufuzli.lastheart.util.HeartManager;

@Mod.EventBusSubscriber(modid = LastHeartMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ItemUseEvents {

    @SubscribeEvent
    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getPlayer();
        
        if (!player.level().isClientSide) {
            // Check if holding Extra Heart
            if (player.getItemInHand(event.getHand()).is(ModItems.EXTRA_HEART.get())) {
                if (player.isShiftKeyDown()) {
                    // Shift + Right Click - remove from self
                    HeartManager.removeExtraHeartFromPlayer(player);
                    player.getItemInHand(event.getHand()).shrink(1);
                } else {
                    // Right Click - add to self
                    HeartManager.addExtraHeart(player);
                    player.getItemInHand(event.getHand()).shrink(1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getPlayer();
        Entity target = event.getTarget();
        
        if (!player.level().isClientSide && target instanceof Player targetPlayer) {
            // Check if holding Extra Heart and has special key combo
            if (player.getItemInHand(event.getHand()).is(ModItems.EXTRA_HEART.get())) {
                if (player.isShiftKeyDown() && player.isSteppingCarefully()) {
                    // Ctrl + Shift + Right Click on player - take heart
                    if (HeartManager.getExtraHearts(targetPlayer) > 0) {
                        HeartManager.removeExtraHeartFromPlayer(targetPlayer);
                        HeartManager.addExtraHeart(player);
                        
                        player.displayClientMessage(
                            net.minecraft.network.chat.Component.literal("§a❤ Yurakni oldingiz!"),
                            true
                        );
                    }
                }
            }
        }
    }
}
