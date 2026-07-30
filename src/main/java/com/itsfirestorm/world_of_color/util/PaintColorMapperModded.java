package com.itsfirestorm.world_of_color.util;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.block.DyedBlockList;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaintColorMapperModded {
    private static final Map<Item, Item[]> COLOR_FAMILIES = new HashMap<>();

    /*
     * TODO: Make this datapack compatible
     */

    static {
        registerDyedBlockList(AllBlocks.SEATS);
        registerDyedBlockList(AllBlocks.TOOLBOXES);
        registerDyedBlockList(AllBlocks.TABLE_CLOTHS);
        registerDyedBlockList(AllBlocks.PACKAGE_POSTBOXES);
        registerDyedBlockList(AllBlocks.DYED_VALVE_HANDLES);
        Item[] valveFamily = COLOR_FAMILIES.get(AllBlocks.DYED_VALVE_HANDLES.get(DyeColor.WHITE).asItem());
        COLOR_FAMILIES.put(AllBlocks.COPPER_VALVE_HANDLE.asItem(), valveFamily);
    }

    private static void register(Item... items) {
        for (Item item : items) {
            COLOR_FAMILIES.put(item, items);
        }
    }

    private static void registerDyedBlockList(DyedBlockList<?> dyedBlockList) {
        Item[] family = new Item[16];
        for (DyeColor color : DyeColor.values()) {
            family[color.getId()] = dyedBlockList.get(color).asItem();
        }
        for (Item item : family) {
            if (item != null) COLOR_FAMILIES.put(item, family);
        }
    }

    private static void registerSparse(Item red, Item yellow, Item green, Item blue,
                                       Item pink, Item black, Item white) {
        Item[] family = new Item[16];
        family[DyeColor.RED.getId()]    = red;
        family[DyeColor.YELLOW.getId()] = yellow;
        family[DyeColor.GREEN.getId()]  = green;
        family[DyeColor.BLUE.getId()]   = blue;
        family[DyeColor.PINK.getId()]   = pink;
        family[DyeColor.BLACK.getId()]  = black;
        family[DyeColor.WHITE.getId()]  = white;

        for (Item item : family) {
            if (item != null) COLOR_FAMILIES.put(item, family);
        }
    }

    public static boolean isRecolorable(ItemStack stack) {
        return COLOR_FAMILIES.containsKey(stack.getItem());
    }

    public static Optional<ItemStack> recolor(ItemStack stack, PaintColor color) {
        Item[] family = COLOR_FAMILIES.get(stack.getItem());
        if (family == null) return Optional.empty();

        // To avoid duplication, static import toDyeColor from PaintColorMapper
        DyeColor dyeColor = PaintColorMapper.toDyeColor(color);
        if (dyeColor == null) return Optional.empty();

        Item result = family[dyeColor.getId()];
        if (result == null) return Optional.empty();

        ItemStack resultStack = new ItemStack(result, 1);

        // Preserve NBT
        resultStack.applyComponentsAndValidate(stack.getComponentsPatch());
        return Optional.of(resultStack);
    }
}
