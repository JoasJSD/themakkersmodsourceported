package net.iegeliers.themakkersmod.block.custom.entity;

import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.block.custom.menu.MenuKnakworstOven;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TMMMenuType {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, TheMakkersMod.MODID);

    public static final RegistryObject<MenuType<MenuKnakworstOven>> KNAKWORST_OVEN_MENU = registerMenuType(
            (ID, inventory, extraData) -> new MenuKnakworstOven(ID, inventory), "knakworst_oven_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }

}