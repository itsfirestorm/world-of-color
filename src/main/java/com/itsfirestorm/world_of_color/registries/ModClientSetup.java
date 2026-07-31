package com.itsfirestorm.world_of_color.registries;

import com.itsfirestorm.world_of_color.WorldOfColors;
import com.itsfirestorm.world_of_color.api.PaintColor;
import com.itsfirestorm.world_of_color.api.WorldOfColorsAPI;
import com.itsfirestorm.world_of_color.fluids.PaintFluidType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

public class ModClientSetup {

    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        ResourceLocation still = ResourceLocation.fromNamespaceAndPath(WorldOfColors.MODID, "block/liquid_soft_still");
        ResourceLocation flow = ResourceLocation.fromNamespaceAndPath(WorldOfColors.MODID, "block/liquid_soft_flow");

        for (PaintColor color : PaintColor.values()) {
            WorldOfColorsAPI.registry().getPaintFluidType(color).ifPresent(fluidType ->
                    registerPaintFluidRendering(event, fluidType, still, flow));
        }
    }

    private static void registerPaintFluidRendering(
            RegisterClientExtensionsEvent event,
            PaintFluidType fluidType,
            ResourceLocation still,
            ResourceLocation flow
    ) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            @Override
            public @NotNull ResourceLocation getStillTexture() {
                return still;
            }

            @Override
            public ResourceLocation getOverlayTexture() {
                return still;
            }

            @Override
            public @NotNull ResourceLocation getFlowingTexture() {
                return flow;
            }

            @Override
            /* ARGB Format: 0xAARRGGBB
             * AA: Alpha || RR: Red || GG: Green || BB: Blue
             * We want paint to be fully opaque since it is a dense liquid.
             */
            public int getTintColor() {
                return 0xFF000000 | fluidType.getPaintColor().getColor();
            }
        }, fluidType);
    }
}