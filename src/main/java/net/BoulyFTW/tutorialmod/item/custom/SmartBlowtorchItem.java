package net.BoulyFTW.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.BoulyFTW.tutorialmod.block.ModBlocks;
import net.BoulyFTW.tutorialmod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;


import java.util.Map;

public class SmartBlowtorchItem extends Item {
    private static final Map<Block, Item> BLOW_TORCH_ITEM_CRAFT =
            new ImmutableMap.Builder<Block, Item>()
                    .put(ModBlocks.TITANIUM_BLOCK.get(), ModItems.TITANIUM_NUGGET.get())
                    .put(ModBlocks.TITANIUM_ORE.get(), ModItems.TITANIUM_INGOT.get())
                    .put(Blocks.SAND, Blocks.GLASS.asItem())
                    .put(Blocks.IRON_ORE, Items.IRON_INGOT.asItem())
                    .put(Blocks.GOLD_ORE, Items.GOLD_INGOT.asItem())
                    .put(Blocks.OAK_WOOD, Items.CHARCOAL.asItem())
                    .put(Blocks.DARK_OAK_WOOD, Items.CHARCOAL.asItem())
                    .put(Blocks.BIRCH_WOOD, Items.CHARCOAL.asItem())
                    .put(Blocks.JUNGLE_WOOD, Items.CHARCOAL.asItem())
                    .put(Blocks.COPPER_ORE, Items.COPPER_INGOT.asItem())
                    .build();

    public SmartBlowtorchItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            Level level = pContext.getLevel();
            BlockPos positionClicked = pContext.getClickedPos();
            Block blockClicked = level.getBlockState(positionClicked).getBlock();

            if(canBlowTorch(blockClicked)) {
                ItemEntity entityItem = new ItemEntity(level,
                        positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                        new ItemStack(BLOW_TORCH_ITEM_CRAFT.get(blockClicked), 1));

                level.destroyBlock(positionClicked, false);
                level.addFreshEntity(entityItem);
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), p -> {
                    p.broadcastBreakEvent(pContext.getHand());
                });
            } else {
                pContext.getPlayer().sendMessage(new TextComponent("Cannot blow torch this Block!"),
                        Util.NIL_UUID);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private boolean canBlowTorch(Block block) {
        return BLOW_TORCH_ITEM_CRAFT.containsKey(block);
    }
}
