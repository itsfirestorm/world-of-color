package com.itsfirestorm.world_of_color.fluids;

import com.itsfirestorm.world_of_color.util.PaintColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.FluidType;

public class PaintFluidType extends FluidType {
    private final PaintColor color;

    public PaintFluidType(Properties props, PaintColor color) {
        super(props);
        this.color = color;
    }

    public PaintColor getPaintColor() {
        return color;
    }

    @Override
    public boolean canConvertToSource(FluidState state, LevelReader reader, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canDrownIn(LivingEntity entity) {
        return true;
    }

    @Override
    public boolean canExtinguish(Entity entity) {
        return true;
    }

    @Override
    public boolean canHydrate(Entity entity) {
        return false;
    }
}
