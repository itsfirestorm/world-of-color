package com.itsfirestorm.world_of_color.registries.client;

import com.itsfirestorm.world_of_color.WorldOfColor;
import com.itsfirestorm.world_of_color.fluids.PaintFluidType;
import com.itsfirestorm.world_of_color.registries.ModFluids;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

public class ModClientSetup {

    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        ResourceLocation LIQUID_SOFT_STILL = ResourceLocation.fromNamespaceAndPath(WorldOfColor.MODID, "block/liquid_soft_still");
        ResourceLocation LIQUID_SOFT_FLOW = ResourceLocation.fromNamespaceAndPath(WorldOfColor.MODID, "block/liquid_soft_flow");

        registerPaintFluidRendering(event, ModFluids.RED_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.BLUE_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.GREEN_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.YELLOW_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.PINK_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.BLACK_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.WHITE_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.PURPLE_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.MAGENTA_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.LIME_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.CYAN_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.LIGHTBLUE_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.ORANGE_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.BROWN_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.LIGHTGRAY_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
        registerPaintFluidRendering(event, ModFluids.GRAY_PAINT_TYPE.get(), LIQUID_SOFT_STILL, LIQUID_SOFT_FLOW);
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