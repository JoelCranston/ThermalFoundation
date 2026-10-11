package cofh.thermal.foundation.client.model.geom;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModelLayers {

    private ModelLayers() {

    }

    public static final ModelLayerLocation RUBBERWOOD_BOAT_LAYER = new ModelLayerLocation(Identifier.parse("thermal:boat/rubberwood"), "main");
    public static final ModelLayerLocation RUBBERWOOD_CHEST_BOAT_LAYER = new ModelLayerLocation(Identifier.parse("thermal:chest_boat/rubberwood"), "main");

}