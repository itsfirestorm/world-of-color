package com.itsfirestorm.world_of_color.api;

import net.minecraft.resources.ResourceLocation;

import static com.itsfirestorm.world_of_color.WorldOfColor.MODID;

public final class RecipeIds {
    private RecipeIds() {}

    public static final ResourceLocation PAINT_ARMOR_DYE =
            ResourceLocation.fromNamespaceAndPath(MODID, "paint_armor_dye");

    public static final ResourceLocation PAINT_BLOCK_DYE =
            ResourceLocation.fromNamespaceAndPath(MODID, "paintable");
}