package cofh.thermal.foundation.init.registries;

import cofh.core.common.entity.BoatCoFH;
import cofh.core.common.entity.ChestBoatCoFH;
import cofh.core.common.item.BoatItemCoFH;
import cofh.lib.common.item.HangingSignItemCoFH;
import cofh.lib.common.item.SignItemCoFH;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_FOUNDATION;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.blocksTab;
import static cofh.thermal.core.init.registries.ThermalCreativeTabs.toolsTab;
import static cofh.thermal.core.util.RegistrationHelper.*;
import static cofh.thermal.foundation.init.registries.TFndEntities.RUBBERWOOD_BOAT;
import static cofh.thermal.foundation.init.registries.TFndEntities.RUBBERWOOD_CHEST_BOAT;
import static cofh.thermal.foundation.init.registries.TFndIDs.ID_RUBBERWOOD_BOAT;
import static cofh.thermal.foundation.init.registries.TFndIDs.ID_RUBBERWOOD_CHEST_BOAT;

public class TFndItems {

    private TFndItems() {

    }

    public static void register() {

        registerMetalSet("tin", ID_THERMAL_FOUNDATION);
        registerMetalSet("lead", ID_THERMAL_FOUNDATION);
        registerMetalSet("silver", ID_THERMAL_FOUNDATION);
        registerMetalSet("nickel", ID_THERMAL_FOUNDATION);
        registerAlloySet("bronze", ID_THERMAL_FOUNDATION);
        registerAlloySet("electrum", ID_THERMAL_FOUNDATION);
        registerAlloySet("invar", ID_THERMAL_FOUNDATION);
        registerAlloySet("constantan", ID_THERMAL_FOUNDATION);
        registerGemSet("ruby", ID_THERMAL_FOUNDATION);
        registerGemSet("sapphire", ID_THERMAL_FOUNDATION);

        toolsTab(250, registerItem(ID_RUBBERWOOD_BOAT, id -> new BoatItemCoFH(RUBBERWOOD_BOAT, (type, level, x, y, z) -> new BoatCoFH(RUBBERWOOD_BOAT::get, level, ITEMS.getSup(ID_RUBBERWOOD_BOAT), x, y, z), itemProperties(id)).setModId(ID_THERMAL_FOUNDATION)));
        toolsTab(250, registerItem(ID_RUBBERWOOD_CHEST_BOAT, id -> new BoatItemCoFH(RUBBERWOOD_CHEST_BOAT, (type, level, x, y, z) -> new ChestBoatCoFH(RUBBERWOOD_CHEST_BOAT::get, level, ITEMS.getSup(ID_RUBBERWOOD_CHEST_BOAT), x, y, z), itemProperties(id)).setModId(ID_THERMAL_FOUNDATION)));

        blocksTab(150, registerItem("rubberwood_sign", id -> new SignItemCoFH(blockItemProperties(id).stacksTo(16), BLOCKS.get("rubberwood_sign"), BLOCKS.get("rubberwood_wall_sign")).setModId(ID_THERMAL_FOUNDATION)));
        blocksTab(150, registerItem("rubberwood_hanging_sign", id -> new HangingSignItemCoFH(BLOCKS.get("rubberwood_hanging_sign"), BLOCKS.get("rubberwood_wall_hanging_sign"), blockItemProperties(id).stacksTo(16)).setModId(ID_THERMAL_FOUNDATION)));
    }

}
