package com.itsfirestorm.world_of_color.registries;

import com.itsfirestorm.world_of_color.WorldOfColor;
import com.itsfirestorm.world_of_color.api.PaintColor;
import com.itsfirestorm.world_of_color.items.Paint;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.Map;

import static com.itsfirestorm.world_of_color.registries.ModFluids.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WorldOfColor.MODID);

    public static final DeferredItem<Item> RAINBOW_PAINT = ITEMS.register("rainbow_paint",
            () -> new Paint(new Item.Properties(), null));

    private static final Map<PaintColor, DeferredItem<Item>> PAINTS = new EnumMap<>(PaintColor.class);

    static {
        for (PaintColor color : PaintColor.values()) {
            DeferredItem<Item> item = ITEMS.register(color.getId() + "_paint",
                    () -> new Paint(new Item.Properties().stacksTo(64), ModFluids.getFluid(color)));
            PAINTS.put(color, item);
        }
    }

    public static DeferredItem<Item> getPaint(PaintColor color) { return PAINTS.get(color); }
}
