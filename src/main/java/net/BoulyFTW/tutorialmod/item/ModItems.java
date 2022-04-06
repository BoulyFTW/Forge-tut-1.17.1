package net.BoulyFTW.tutorialmod.item;

import net.BoulyFTW.tutorialmod.TutorialMod;
import net.BoulyFTW.tutorialmod.item.custom.SmartBlowtorchItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register( "titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register( "titanium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register( "raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> SMART_BLOW_TORCH = ITEMS.register( "smart_blow_torch",
            () -> new SmartBlowtorchItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> MANGO = ITEMS.register( "mango",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build())));

    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register( "titanium_sword",
            () -> new SwordItem(ModTiers.TITANIUM, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register( "titanium_pickaxe",
            () -> new PickaxeItem(ModTiers.TITANIUM, 1, 2f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register( "titanium_axe",
            () -> new AxeItem(ModTiers.TITANIUM, 5, -2f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register( "titanium_shovel",
            () -> new ShovelItem(ModTiers.TITANIUM, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register( "titanium_hoe",
            () -> new HoeItem(ModTiers.TITANIUM, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> GODWEPON = ITEMS.register( "godwepon",
            () -> new SwordItem(ModTiers.TITANIUM, 69413, 69f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}