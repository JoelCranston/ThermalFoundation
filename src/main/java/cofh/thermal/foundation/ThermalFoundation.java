package cofh.thermal.foundation;

import cofh.thermal.foundation.init.registries.TFndBlocks;
import cofh.thermal.foundation.init.registries.TFndEntities;
import cofh.thermal.foundation.init.registries.TFndItems;
import cofh.thermal.foundation.util.TFndProxy;
import cofh.thermal.foundation.util.TFndProxyClient;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import static cofh.lib.util.FlagManager.setFlag;
import static cofh.lib.util.constants.ModIds.ID_THERMAL_FOUNDATION;
import static cofh.thermal.foundation.client.model.geom.ModelLayers.RUBBERWOOD_BOAT_LAYER;
import static cofh.thermal.foundation.client.model.geom.ModelLayers.RUBBERWOOD_CHEST_BOAT_LAYER;
import static cofh.thermal.lib.util.ThermalFlags.*;

@Mod (ID_THERMAL_FOUNDATION)
public class ThermalFoundation {

    public static final TFndProxy PROXY = FMLEnvironment.getDist().isClient() ? new TFndProxyClient() : new TFndProxy();

    public ThermalFoundation(ModContainer modContainer, IEventBus modEventBus) {

        setFeatureFlags();

        modEventBus.addListener(this::entityLayerSetup);
        modEventBus.addListener(this::entityRendererSetup);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        TFndBlocks.register();
        TFndItems.register();

        TFndEntities.register();
    }

    private void setFeatureFlags() {

        setFlag(FLAG_RESOURCE_NITER, true);
        setFlag(FLAG_RESOURCE_SULFUR, true);

        setFlag(FLAG_RESOURCE_TIN, true);
        setFlag(FLAG_RESOURCE_LEAD, true);
        setFlag(FLAG_RESOURCE_SILVER, true);
        setFlag(FLAG_RESOURCE_NICKEL, true);

        setFlag(FLAG_RESOURCE_RUBBERWOOD, true);
    }

    public static final BlockSetType BLOCK_SET_TYPE_RUBBERWOOD = BlockSetType.register(new BlockSetType("thermal:rubberwood"));
    public static final WoodType WOOD_TYPE_RUBBERWOOD = WoodType.register(new WoodType("thermal:rubberwood", BLOCK_SET_TYPE_RUBBERWOOD));

    // region INITIALIZATION
    private void entityLayerSetup(final EntityRenderersEvent.RegisterLayerDefinitions event) {

        event.registerLayerDefinition(RUBBERWOOD_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(RUBBERWOOD_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
    }

    private void entityRendererSetup(final EntityRenderersEvent.RegisterRenderers event) {

        PROXY.registerBoatModels(event);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(TFndBlocks::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            Sheets.addWoodType(WOOD_TYPE_RUBBERWOOD);
        });
    }
    // endregion
}
