package com.itsfirestorm.world_of_color.recipes;

import com.itsfirestorm.world_of_color.api.PaintColor;
import com.itsfirestorm.world_of_color.api.PaintHelper;
import com.itsfirestorm.world_of_color.items.Paint;
import com.itsfirestorm.world_of_color.registries.ModRecipeSerializers;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PaintDyesArmor extends CustomRecipe {

    public PaintDyesArmor (CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, @NotNull Level level) {
        ItemStack armorStack = ItemStack.EMPTY;
        List<ItemStack> paintStacks = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.isEmpty()) continue;
            if (stack.getItem() instanceof Paint) {
                paintStacks.add(stack);
            } else if (stack.has(DataComponents.DYED_COLOR) || PaintHelper.isDyeableArmor(stack)) {
                if (!armorStack.isEmpty()) return false;
                armorStack = stack;
            } else {
                return false;
            }
        }

        return !armorStack.isEmpty() && !paintStacks.isEmpty();
    }

    public @NotNull ItemStack assemble(CraftingInput input, HolderLookup.@NotNull Provider provider) {
        ItemStack armorStack = ItemStack.EMPTY;
        List<ItemStack> paintStacks = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.isEmpty()) continue;
            if (stack.getItem() instanceof Paint) {
                paintStacks.add(stack);
            } else if (stack.has(DataComponents.DYED_COLOR) || PaintHelper.isDyeableArmor(stack)) {
                armorStack = stack;
            }
        }

        if (armorStack.isEmpty() || paintStacks.isEmpty()) return ItemStack.EMPTY;

        Optional<Integer> existingColor = armorStack.has(DataComponents.DYED_COLOR)
                ? Optional.of(Objects.requireNonNull(armorStack.get(DataComponents.DYED_COLOR)).rgb())
                : Optional.empty();

        List<PaintColor> paintColors = paintStacks.stream()
                .filter(s -> s.getItem() instanceof Paint)
                .map(s -> ((Paint) s.getItem()).getColor())
                .filter(Objects::nonNull)
                .toList();

        int mixedColor = PaintHelper.blend(existingColor, paintColors);

        ItemStack result = armorStack.copy();
        result.set(DataComponents.DYED_COLOR, new DyedItemColor(mixedColor, true));
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2; // At least 2 slots needed
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ModRecipeSerializers.PAINT_ARMOR_DYE.get();
    }
}
