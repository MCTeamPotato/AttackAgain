package com.teampotato.attackagain;

import com.teampotato.attackagain.attribute.AttackAttribute;
import com.teampotato.attackagain.config.AttackConfig;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AttackAgain.MODID)
public class AttackAgain {
    public static final String MODID = "attack_again";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public AttackAgain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AttackConfig.CONFIG);
        AttackAttribute.ATTRIBUTES.register(modEventBus);
    }
}
