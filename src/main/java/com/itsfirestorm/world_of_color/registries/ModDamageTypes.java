package com.itsfirestorm.world_of_color.registries;

import com.itsfirestorm.world_of_color.WorldOfColor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {
    public static final ResourceKey<DamageType> TASTE_RAINBOW = ResourceKey.create(
            Registries.DAMAGE_TYPE,
            ResourceLocation.fromNamespaceAndPath(WorldOfColor.MODID, "rainbow")
    );
}
