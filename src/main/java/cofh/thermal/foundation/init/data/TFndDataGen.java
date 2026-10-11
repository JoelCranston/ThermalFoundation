package cofh.thermal.foundation.init.data;

import cofh.thermal.foundation.init.data.providers.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_FOUNDATION;

@EventBusSubscriber (modid = ID_THERMAL_FOUNDATION)
public class TFndDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent.Client event) {

        PackOutput output = event.getGenerator().getPackOutput();

        TFndDatapackRegistryProvider datapackRegistry = event.createProvider(TFndDatapackRegistryProvider::new);
        CompletableFuture<HolderLookup.Provider> lookup = datapackRegistry.getRegistryProvider();
        TFndTagsProvider.Block blockTags = event.addProvider(new TFndTagsProvider.Block(output, lookup));
        event.addProvider(new TFndTagsProvider.Item(output, lookup, blockTags.contentsGetter()));

        event.addProvider(new TFndLootTableProvider(output, lookup));
        event.addProvider(new TFndRecipeProvider.Runner(output, lookup));
    }

}
