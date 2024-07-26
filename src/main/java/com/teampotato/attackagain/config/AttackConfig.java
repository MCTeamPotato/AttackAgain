package com.teampotato.attackagain.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class AttackConfig {
    public static ForgeConfigSpec CONFIG;
    public static ForgeConfigSpec.ConfigValue<Double> PROBABILITY;
    public static ForgeConfigSpec.ConfigValue<Double> DAMAGE;
    public static ForgeConfigSpec.ConfigValue<Double> FREQUENCY;
    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("Potion Level Fix").comment("These settings will only apply when you first enter the world. Subsequently, you can control the attributes in-game.");
        PROBABILITY = builder
                .comment("The larger this number, the higher the probability of a subsequent attack. Range:0~100, default: 15.0")
                .define("Attack Again Probability", 15.0);
        DAMAGE = builder
                .comment("The damage percentage of a subsequent attack, default: 0.35")
                .define("Attack Again Percentage", 0.35);
        FREQUENCY = builder
                .comment("The frequency of subsequent attacks, default: 1.0")
                .define("Attack Again Frequency", 1.0);
        builder.pop();
        CONFIG = builder.build();
    }
}
