package com.nufuzli.lastheart.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class HeartManager {
    private static final String EXTRA_HEARTS_NBT = "ExtraHearts";
    private static final int MAX_EXTRA_HEARTS = 10;
    private static final int DEFAULT_HEARTS = 20; // 10 satir (20 half-hearts)

    /**
     * Handle player death - removes one extra heart if available
     */
    public static void handlePlayerDeath(Player player) {
        int extraHearts = getExtraHearts(player);

        if (extraHearts > 0) {
            // O'yin tugamaydi, faqat yurak yo'qoladi
            int newHearts = extraHearts - 1;
            setExtraHearts(player, newHearts);
            
            player.displayClientMessage(
                Component.literal("§c❤ Yurak yo'qoldi! Qolgan: " + newHearts),
                true
            );

            playHeartLostSound(player);
            applyRedScreenEffect(player);

            if (newHearts <= 0) {
                player.displayClientMessage(
                    Component.literal("§4§l⚠ OXIRGI YURAK! O'YIN TUGADI!"),
                    false
                );
            }
        } else {
            // O'yin tugadi - final death
            player.setHealth(0);
        }
    }

    /**
     * Add extra heart to player
     */
    public static void addExtraHeart(Player player) {
        int currentHearts = getExtraHearts(player);
        
        if (currentHearts < MAX_EXTRA_HEARTS) {
            int newHearts = currentHearts + 1;
            setExtraHearts(player, newHearts);
            
            player.displayClientMessage(
                Component.literal("§a❤ Yurak qo'shildi! Jami: " + newHearts),
                true
            );
            
            playHeartAddedSound(player);
            updatePlayerMaxHealth(player);
        } else {
            player.displayClientMessage(
                Component.literal("§e❤ Maksimal yurakka yetdingiz! (10 qo'shimcha)"),
                true
            );
        }
    }

    /**
     * Remove extra heart from player (multiplayer - take from others)
     */
    public static void removeExtraHeartFromPlayer(Player player) {
        int currentHearts = getExtraHearts(player);
        
        if (currentHearts > 0) {
            int newHearts = currentHearts - 1;
            setExtraHearts(player, newHearts);
            
            player.displayClientMessage(
                Component.literal("§c❤ Yurak olib tashlandi! Qolgan: " + newHearts),
                true
            );
            
            playHeartLostSound(player);
            updatePlayerMaxHealth(player);
        }
    }

    /**
     * Get extra hearts count
     */
    public static int getExtraHearts(Player player) {
        return player.getPersistentData().getInt(EXTRA_HEARTS_NBT);
    }

    /**
     * Set extra hearts count
     */
    public static void setExtraHearts(Player player, int count) {
        int clamped = Math.max(0, Math.min(count, MAX_EXTRA_HEARTS));
        player.getPersistentData().putInt(EXTRA_HEARTS_NBT, clamped);
        updatePlayerMaxHealth(player);
    }

    /**
     * Update player maximum health based on extra hearts
     */
    public static void updatePlayerMaxHealth(Player player) {
        int extraHearts = getExtraHearts(player);
        float maxHealth = DEFAULT_HEARTS + (extraHearts * 2.0f);
        
        player.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
            .setBaseValue(maxHealth);
    }

    /**
     * Apply red screen effect when health is critical
     */
    private static void applyRedScreenEffect(Player player) {
        if (player.getHealth() <= 2.0f) {
            player.addEffect(new MobEffectInstance(
                MobEffects.BLINDNESS,
                40, // 2 seconds
                0,
                false,
                false
            ));
        }
    }

    /**
     * Play sound when heart is lost
     */
    private static void playHeartLostSound(Player player) {
        player.level().playSound(
            player,
            player.getX(), player.getY(), player.getZ(),
            SoundEvents.ITEM_BREAK,
            SoundSource.PLAYERS,
            1.0f, 0.5f
        );
    }

    /**
     * Play sound when heart is added
     */
    private static void playHeartAddedSound(Player player) {
        player.level().playSound(
            player,
            player.getX(), player.getY(), player.getZ(),
            SoundEvents.ITEM_PICKUP,
            SoundSource.PLAYERS,
            1.0f, 1.2f
        );
    }
}
