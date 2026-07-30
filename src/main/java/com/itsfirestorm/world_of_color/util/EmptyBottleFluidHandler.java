package com.itsfirestorm.world_of_color.util;

import com.itsfirestorm.world_of_color.fluids.PaintFluidType;
import com.itsfirestorm.world_of_color.registries.items.ModItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandlerItem;
import org.jetbrains.annotations.NotNull;

public class EmptyBottleFluidHandler implements IFluidHandlerItem {
    private ItemStack container;
    private static final int CAPACITY = 250; // 250mb = 1/4 bucket

    public EmptyBottleFluidHandler(ItemStack container) {
        this.container = container;
    }

    @Override
    public @NotNull ItemStack getContainer() {
        return container;
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public @NotNull FluidStack getFluidInTank(int tank) {
        return FluidStack.EMPTY; // Empty bottle has no fluid
    }

    @Override
    public int getTankCapacity(int tank) {
        return CAPACITY;
    }

    @Override
    public boolean isFluidValid(int tank, @NotNull FluidStack stack) {
        // Only accept paint fluids
        return stack.getFluidType() instanceof PaintFluidType;
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        // This is called when the bottle extracts fluid FROM a container
        if (resource.isEmpty()) {
            return 0;
        }
        int fillAmount = Math.min(CAPACITY, resource.getAmount());

        if (action.execute() && fillAmount == CAPACITY) { // Only fill if you can fill completely
            if ((resource.getFluidType() instanceof PaintFluidType paintFluidType)) {
                // Get the paint color from the fluid type
                ItemStack paintItem = getPaintItem(paintFluidType);

                // Transform the container
                container = paintItem.copy();
            }
        }

        return fillAmount;
    }

    private static @NotNull ItemStack getPaintItem(PaintFluidType paintFluidType) {
        PaintColor color = paintFluidType.getPaintColor();

        // Transform the empty bottle into the corresponding paint item
        return switch (color) {
            case RED -> new ItemStack(ModItems.REDPAINT.get());
            case BLUE -> new ItemStack(ModItems.BLUEPAINT.get());
            case GREEN -> new ItemStack(ModItems.GREENPAINT.get());
            case YELLOW -> new ItemStack(ModItems.YELLOWPAINT.get());
            case PINK -> new ItemStack(ModItems.PINKPAINT.get());
            case BLACK -> new ItemStack(ModItems.BLACKPAINT.get());
            case WHITE -> new ItemStack(ModItems.WHITEPAINT.get());
            case PURPLE -> new ItemStack(ModItems.PURPLEPAINT.get());
            case MAGENTA -> new ItemStack(ModItems.MAGENTAPAINT.get());
            case LIME -> new ItemStack(ModItems.LIMEPAINT.get());
            case CYAN -> new ItemStack(ModItems.CYANPAINT.get());
            case LIGHTBLUE -> new ItemStack(ModItems.LIGHTBLUEPAINT.get());
            case ORANGE -> new ItemStack(ModItems.ORANGEPAINT.get());
            case BROWN -> new ItemStack(ModItems.BROWNPAINT.get());
            case LIGHTGRAY -> new ItemStack(ModItems.LIGHTGRAYPAINT.get());
            case GRAY -> new ItemStack(ModItems.GRAYPAINT.get());
        };
    }

    @Override
    public @NotNull FluidStack drain(FluidStack resource, FluidAction action) {
        return FluidStack.EMPTY; // Cannot drain from empty bottle
    }

    @Override
    public @NotNull FluidStack drain(int maxDrain, FluidAction action) {
        return FluidStack.EMPTY; // Cannot drain from empty bottle
    }
}