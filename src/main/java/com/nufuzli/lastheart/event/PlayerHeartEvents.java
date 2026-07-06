package com.nufuzli.lastheart.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.nufuzli.lastheart.LastHeartMod;
import com.nufuzli.lastheart.util.HeartManager;

@Mod.EventBusSubscriber(modid = LastHeartMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerHeartEvents {

    @SubscribeEvent
    public static void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player && !event.getEntity().level().isClientSide) {
            Player player = (Player) event.getEntity();
            
            // Cancel normal death if player has extra hearts
            if (HeartManager.getExtraHearts(player) > 0) {
                event.setCanceled(true);
                HeartManager.handlePlayerDeath(player);
                
                // Reset player to full health after removing heart
                player.setHealth(player.getMaxHealth());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide) {
            // Update player health based on hearts
            HeartManager.updatePlayerMaxHealth(event.player);
        }
    }
}
