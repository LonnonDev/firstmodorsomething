package com.lonnonjamesd.testmod.blocks;

import com.lonnonjamesd.testmod.setup.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class Coolblock {
    public static void register() {}

    public static final RegistryObject<Block> COOL_BLOCK = register("cool_block", () ->
            new Block(AbstractBlock.Properties.of(Material.BAMBOO)
                    .strength(1f, 20f)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
    ));

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }
}
