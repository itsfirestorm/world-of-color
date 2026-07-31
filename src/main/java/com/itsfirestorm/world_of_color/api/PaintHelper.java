package com.itsfirestorm.world_of_color.api;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.Optional;

public final class PaintHelper {
    private PaintHelper() {}

    public static int blend(Optional<Integer> existingColor, List<PaintColor> paints) {
        int totalR = 0, totalG = 0, totalB = 0, count = 0;

        if (existingColor.isPresent()) {
            int c = existingColor.get();
            totalR += (c >> 16) & 0xFF;
            totalG += (c >> 8) & 0xFF;
            totalB += c & 0xFF;
            count++;
        }

        for (PaintColor paint : paints) {
            int c = paint.getColor();
            totalR += (c >> 16) & 0xFF;
            totalG += (c >> 8) & 0xFF;
            totalB += c & 0xFF;
            count++;
        }

        if (count == 0) return 0xFFFFFF;
        return ((totalR / count) << 16) | ((totalG / count) << 8) | (totalB / count);
    }

    public static boolean isDyeableArmor(ItemStack stack) {
        if (stack.isEmpty()) return false;
        Item item = stack.getItem();
        return item == Items.LEATHER_HELMET
                || item == Items.LEATHER_CHESTPLATE
                || item == Items.LEATHER_LEGGINGS
                || item == Items.LEATHER_BOOTS
                || item == Items.LEATHER_HORSE_ARMOR
                || stack.has(DataComponents.DYED_COLOR);
    }
}