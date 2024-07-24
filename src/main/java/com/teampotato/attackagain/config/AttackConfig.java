package com.teampotato.attackagain.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AttackConfig {
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.ConfigValue<Integer> PROBABILITY;
    public static ForgeConfigSpec.ConfigValue<Integer> DAMAGE;
    public static ForgeConfigSpec.ConfigValue<Integer> FREQUENCY;
    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Potion Level Fix").comment("These settings will only apply when you first enter the world. Subsequently, you can control the attributes in-game.");
        PROBABILITY = builder
                .comment("The larger this number, the higher the probability of a subsequent attack. Range:0~100, default: 30")
                .define("Attack Again Probability", 30);
        DAMAGE = builder
                .comment("The damage percentage of a subsequent attack, default: 1")
                .define("Damage Percentage", 1);
        FREQUENCY = builder
                .comment("The frequency of subsequent attacks")
                .define("Damage Frequency", 1);
        builder.pop();
        CONFIG = builder.build();
    }
}
