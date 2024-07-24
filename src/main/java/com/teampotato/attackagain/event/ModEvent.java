package com.teampotato.attackagain.event;

import com.teampotato.attackagain.attribute.AttackAttribute;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.teampotato.attackagain.AttackAgain.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEvent {
    @SubscribeEvent
    public static void addAttribute(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, AttackAttribute.ATTACK_PROBABILITY.get());
        event.add(EntityType.PLAYER, AttackAttribute.ATTACK_DAMAGE.get());
        event.add(EntityType.PLAYER, AttackAttribute.ATTACK_FREQUENCY.get());
    }
}
