package cofh.thermal.foundation.gametest;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.foundation.init.registries.TFndIDs.*;

public class RubberwoodTests {

    private static final BlockPos GROUND = new BlockPos(3, 0, 3);

    // The sapling grows through the tree grower's configured features, so this also loads the worldgen data.
    public static void saplingGrows(GameTestHelper helper) {

        helper.setBlock(GROUND, Blocks.DIRT);
        BlockPos saplingPos = GROUND.above();
        helper.setBlock(saplingPos, BLOCKS.get(ID_RUBBERWOOD_SAPLING));
        SaplingBlock sapling = (SaplingBlock) BLOCKS.get(ID_RUBBERWOOD_SAPLING);
        BlockPos pos = helper.absolutePos(saplingPos);

        for (int i = 0; i < 2 && helper.getLevel().getBlockState(pos).is(sapling); ++i) {
            BlockState state = helper.getLevel().getBlockState(pos);
            sapling.advanceTree(helper.getLevel(), pos, state, helper.getLevel().getRandom());
        }
        helper.assertBlockPresent(BLOCKS.get(ID_RUBBERWOOD_LOG), saplingPos);
        helper.succeed();
    }

    public static void logStrips(GameTestHelper helper) {

        BlockPos logPos = new BlockPos(3, 1, 3);
        helper.setBlock(logPos, BLOCKS.get(ID_RUBBERWOOD_LOG));
        Player player = helper.makeMockPlayer(GameType.SURVIVAL);
        player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.IRON_AXE));
        helper.useBlock(logPos, player);
        helper.assertBlockPresent(BLOCKS.get(ID_STRIPPED_RUBBERWOOD_LOG), logPos);
        helper.succeed();
    }

    // The composter only reads the compostables data map.
    public static void compostable(GameTestHelper helper) {

        for (String id : new String[]{ID_RUBBERWOOD_SAPLING, ID_RUBBERWOOD_LEAVES}) {
            Compostable compostable = ITEMS.get(id).builtInRegistryHolder().getData(NeoForgeDataMaps.COMPOSTABLES);
            helper.assertTrue(compostable != null && compostable.chance() == 0.3F, id + " should compost at 0.3");
        }
        helper.succeed();
    }

}
