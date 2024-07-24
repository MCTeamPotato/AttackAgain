package com.teampotato.attackagain.event;

import com.teampotato.attackagain.attribute.AttackAttribute;
import com.teampotato.attackagain.config.AttackConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

import static com.teampotato.attackagain.AttackAgain.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEvent {
    @SubscribeEvent
    public static void changeAttribute(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!player.getPersistentData().contains("hasJoinedBefore")) {
            player.getAttribute(AttackAttribute.ATTACK_PROBABILITY.get()).setBaseValue(AttackConfig.PROBABILITY.get());
            player.getAttribute(AttackAttribute.ATTACK_DAMAGE.get()).setBaseValue(AttackConfig.DAMAGE.get());
            player.getAttribute(AttackAttribute.ATTACK_FREQUENCY.get()).setBaseValue(AttackConfig.FREQUENCY.get());
            player.getPersistentData().putBoolean("hasJoinedBefore", true);
        }
    }

    @SubscribeEvent
    public static void attackAgain(LivingHurtEvent event) {
        LivingEntity monster = event.getEntity();
        if (event.getSource().getEntity() instanceof ServerPlayer player && monster.isAlive()) {
            Random random = new Random();
            if (random.nextInt(100) + 1 <= player.getAttribute(AttackAttribute.ATTACK_PROBABILITY.get()).getValue()) {
                float damage = Math.round(player.getAttribute(AttackAttribute.ATTACK_DAMAGE.get()).getValue());
                float frequency = Math.round(player.getAttribute(AttackAttribute.ATTACK_FREQUENCY.get()).getValue());
                float hurt = event.getAmount();
                event.setAmount(hurt + frequency * (hurt * damage));
            }
        }
    }
}