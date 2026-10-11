package cofh.thermal.foundation.init.registries;

import cofh.core.common.entity.BoatCoFH;
import cofh.core.common.entity.ChestBoatCoFH;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;

import static cofh.thermal.core.ThermalCore.ENTITIES;
import static cofh.thermal.core.ThermalCore.ITEMS;
import static cofh.thermal.foundation.init.registries.TFndIDs.ID_RUBBERWOOD_BOAT;
import static cofh.thermal.foundation.init.registries.TFndIDs.ID_RUBBERWOOD_CHEST_BOAT;

public class TFndEntities {

    private TFndEntities() {

    }

    public static void register() {

    }

    public static final DeferredHolder<EntityType<?>, EntityType<BoatCoFH>> RUBBERWOOD_BOAT = ENTITIES.register(ID_RUBBERWOOD_BOAT, id -> EntityType.Builder.<BoatCoFH>of((type, level) -> new BoatCoFH(type, level, ITEMS.getSup(ID_RUBBERWOOD_BOAT)), MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, id)));
    public static final DeferredHolder<EntityType<?>, EntityType<ChestBoatCoFH>> RUBBERWOOD_CHEST_BOAT = ENTITIES.register(ID_RUBBERWOOD_CHEST_BOAT, id -> EntityType.Builder.<ChestBoatCoFH>of((type, level) -> new ChestBoatCoFH(type, level, ITEMS.getSup(ID_RUBBERWOOD_CHEST_BOAT)), MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(ResourceKey.create(Registries.ENTITY_TYPE, id)));

}
