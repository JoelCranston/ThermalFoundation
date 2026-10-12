package cofh.thermal.foundation.common.event;

import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import static cofh.core.util.helpers.ItemHelper.cloneStack;
import static cofh.lib.util.constants.ModIds.ID_THERMAL_FOUNDATION;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.foundation.init.registries.TFndIDs.ID_RUBBERWOOD_SAPLING;

@EventBusSubscriber (modid = ID_THERMAL_FOUNDATION)
public class TFndCommonSetupEvents {

    //    @SubscribeEvent
    //    public static void setupVillagerTrades(final VillagerTradesEvent event) {
    //
    //        if (!ThermalConfig.enableVillagerTrades.get()) {
    //            return;
    //        }
    //    }

    // Trades load with the datapacks, before the server config, so the trade can't be gated on it.
    @SubscribeEvent
    public static void setupWandererTrades(final WandererTradesEvent event) {

        event.getRareTrades().add(new BasicItemListing(cloneStack(Items.EMERALD, 8), cloneStack(ITEMS.get(ID_RUBBERWOOD_SAPLING)), 8, 1, 0.05F));
    }

}
