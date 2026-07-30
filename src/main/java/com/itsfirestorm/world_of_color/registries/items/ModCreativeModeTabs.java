package com.itsfirestorm.world_of_color.registries.items;

import com.itsfirestorm.world_of_color.WorldOfColor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, WorldOfColor.MODID);

    public static final Supplier<CreativeModeTab> WORLD_OF_COLOR_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "world_of_color_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAINBOW_PAINT.get()))
                    .title(Component.translatable("creativetab.world_of_color.paint"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(ModItems.REDPAINT);
                        output.accept(ModItems.BLUEPAINT);
                        output.accept(ModItems.YELLOWPAINT);
                        output.accept(ModItems.GREENPAINT);
                        output.accept(ModItems.PINKPAINT);
                        output.accept(ModItems.BLACKPAINT);
                        output.accept(ModItems.WHITEPAINT);
                        output.accept(ModItems.PURPLEPAINT);
                        output.accept(ModItems.MAGENTAPAINT);
                        output.accept(ModItems.LIMEPAINT);
                        output.accept(ModItems.CYANPAINT);
                        output.accept(ModItems.LIGHTBLUEPAINT);
                        output.accept(ModItems.ORANGEPAINT);
                        output.accept(ModItems.BROWNPAINT);
                        output.accept(ModItems.LIGHTGRAYPAINT);
                        output.accept(ModItems.GRAYPAINT);
                    })).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
