package com.itsfirestorm.world_of_color.registries;

import com.itsfirestorm.world_of_color.WorldOfColors;
import com.itsfirestorm.world_of_color.fluids.PaintFluid;
import com.itsfirestorm.world_of_color.fluids.PaintFluidType;
import com.itsfirestorm.world_of_color.api.PaintColor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.EnumMap;
import java.util.Map;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(BuiltInRegistries.FLUID, WorldOfColors.MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, WorldOfColors.MODID);

    private static final Map<PaintColor, DeferredHolder<FluidType, PaintFluidType>> TYPES = new EnumMap<>(PaintColor.class);
    private static final Map<PaintColor, DeferredHolder<Fluid, PaintFluid.Source>> FLUID_HOLDERS = new EnumMap<>(PaintColor.class);

    static {
        for (PaintColor color : PaintColor.values()) {
            DeferredHolder<FluidType, PaintFluidType> type = FLUID_TYPES.register(color.getId() + "_paint", () ->
                    new PaintFluidType(FluidType.Properties.create().density(2000).viscosity(6000).temperature(300), color));
            DeferredHolder<Fluid, PaintFluid.Source> fluid = FLUIDS.register(color.getId() + "_paint", () ->
                    new PaintFluid.Source(type));
            TYPES.put(color, type);
            FLUID_HOLDERS.put(color, fluid);
        }
    }

    public static DeferredHolder<FluidType, PaintFluidType> getType(PaintColor color) { return TYPES.get(color); }
    public static DeferredHolder<Fluid, PaintFluid.Source> getFluid(PaintColor color) { return FLUID_HOLDERS.get(color); }
}
