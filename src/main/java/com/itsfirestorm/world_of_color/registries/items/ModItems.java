package com.itsfirestorm.world_of_color.registries.items;

import com.itsfirestorm.world_of_color.WorldOfColor;
import com.itsfirestorm.world_of_color.items.Paint;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.itsfirestorm.world_of_color.registries.ModFluids.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(WorldOfColor.MODID);

    public static final DeferredItem<Item> RAINBOW_PAINT = ITEMS.register("rainbow_paint",
            () -> new Paint(new Item.Properties(), null));

    public static final DeferredItem<Item> REDPAINT = ITEMS.register("red_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), RED_PAINT));
    public static final DeferredItem<Item> BLUEPAINT = ITEMS.register("blue_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), BLUE_PAINT));
    public static final DeferredItem<Item> YELLOWPAINT = ITEMS.register("yellow_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), YELLOW_PAINT));
    public static final DeferredItem<Item> GREENPAINT = ITEMS.register("green_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), GREEN_PAINT));
    public static final DeferredItem<Item> PINKPAINT = ITEMS.register("pink_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), PINK_PAINT));
    public static final DeferredItem<Item> BLACKPAINT = ITEMS.register("black_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), BLACK_PAINT));
    public static final DeferredItem<Item> WHITEPAINT = ITEMS.register("white_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), WHITE_PAINT));
    public static final DeferredItem<Item> PURPLEPAINT = ITEMS.register("purple_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), PURPLE_PAINT));
    public static final DeferredItem<Item> MAGENTAPAINT = ITEMS.register("magenta_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), MAGENTA_PAINT));
    public static final DeferredItem<Item> LIMEPAINT = ITEMS.register("lime_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), LIME_PAINT));
    public static final DeferredItem<Item> CYANPAINT = ITEMS.register("cyan_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), CYAN_PAINT));
    public static final DeferredItem<Item> LIGHTBLUEPAINT = ITEMS.register("light_blue_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), LIGHTBLUE_PAINT));
    public static final DeferredItem<Item> ORANGEPAINT = ITEMS.register("orange_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), ORANGE_PAINT));
    public static final DeferredItem<Item> BROWNPAINT = ITEMS.register("brown_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), BROWN_PAINT));
    public static final DeferredItem<Item> LIGHTGRAYPAINT = ITEMS.register("light_gray_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), LIGHTGRAY_PAINT));
    public static final DeferredItem<Item> GRAYPAINT = ITEMS.register("gray_paint",
            () -> new Paint(new Item.Properties().stacksTo(64), GRAY_PAINT));
}
