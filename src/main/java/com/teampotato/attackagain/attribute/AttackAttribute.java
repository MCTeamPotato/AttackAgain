package com.teampotato.attackagain.attribute;

import com.teampotato.attackagain.AttackAgain;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AttackAttribute {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, AttackAgain.MODID);

    public static final RegistryObject<Attribute> ATTACK_PROBABILITY = ATTRIBUTES.register("attack_probability",
            () -> new RangedAttribute("attribute.name.attack_again.attack_probability", 1, 0, 100).setSyncable(true));

    public static final RegistryObject<Attribute> ATTACK_DAMAGE = ATTRIBUTES.register("attack_damage",
            () -> new RangedAttribute("attribute.name.attack_again.attack_damage", 1, 0, Integer.MAX_VALUE).setSyncable(true));

    public static final RegistryObject<Attribute> ATTACK_FREQUENCY = ATTRIBUTES.register("attack_frequency",
            () -> new RangedAttribute("attribute.name.attack_again.attack_frequency", 1, 0, Integer.MAX_VALUE).setSyncable(true));
}
