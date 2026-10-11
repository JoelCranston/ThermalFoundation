# Progress log

## Ported to 26.1.2 (2026-10-11)

Added to the port after the other four repos were done, because ThermalCore and ThermalExpansion recipes call for
Foundation's metals and can't be crafted without it. Forked from upstream's NeoForge 1.20.4 branch and ported
straight to 26.1.2 using the other repos' API notes.

- **B.0**: ModDevGradle, Java 25, `neoforge.mods.toml`, the shared 26.1.2 access transformer, a `gametest` source
  set. 289 compile errors.
- **Code**: every block and item gets its id before construction (`id ->` registrations; CoFHCore's
  `OreBlockCoFH.createStoneOre/createDeepslateOre` now take the id). Logs, leaves, signs and the flower pot follow
  vanilla's 26.1 shapes (`logProperties`, `TintedParticleLeavesBlock`, `wallVariant`). Boats register with a drop
  item and vanilla's boat and chest boat layers; CoFHCore's `BoatItemCoFH` widened to `AbstractBoat`, since a 26.1
  chest boat isn't a `Boat`. `ItemBlockRenderTypes` calls go (layers come from sprites). The model and blockstate
  providers are deleted, as in the other repos; tags, loot, recipes and datagen follow ThermalCore's shapes.
  The wandering trader trade became data, and composting a data map.
- **Resources**: generated assets moved into `resources`, generated data regenerated (singular folders, `c:` tags).
  Hand-written data: `forge:` → `c:`, crafting ingredients as strings and `result.id`, the loot tables' enchantment
  sub-predicate, `neoforge:conditions` for the recycling recipes (the Forge-era `conditions` key was silently
  ignored, so their tag checks never ran), `minecraft:iron_chain` in the hanging sign. Press recipes gated on TE's
  dies. Item definitions for every item.
- **GameTests (5)**: sapling grows (needs `sky_access`: a GameTest area is roofed by default, which stopped even an
  oak sapling), log strips, sapling and leaves compost, recipe sync, plus vanilla's built-in test.
