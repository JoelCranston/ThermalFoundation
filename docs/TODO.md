# TODO

## Owed

1. **Client pass (Joel).** Nothing here has been seen in a client: item and block models (every item got an
   `items/*.json`; coins and plates dispatch on stack count), the rubberwood boat and chest boat (model layers,
   textures, placing and riding), standing and hanging signs (sign textures come from `Sheets.addWoodType`), leaves
   and their falling particles, doors and trapdoors (cutout now comes from the sprite), ore generation in a new world.

## Inbox

- **The wandering trader's rubberwood sapling ignores "Enable Wandering Trader Trades"** (ThermalCore config).
  Trades are data on 26.1 (`villager_trade` + the `wandering_trader/uncommon` tag), and no CoFH load condition reads
  that config. The trade is always on, as upstream's default was; a datapack can remove it.
- **Press recipes that use ThermalExpansion's dies load only when the die is registered** (`neoforge:registered`).
  Upstream had no condition and logged 64 parse errors when TE wasn't installed.
- **Composting moved to the `neoforge:compostables` data map**: the 26.1 composter reads only the data map, so
  upstream's `ComposterBlock.add` calls did nothing. Stripping still works through `AxeItem.STRIPPABLES`, which the
  axe falls back to after the data map.
- **Leaves are `TintedParticleLeavesBlock`** (falling-leaf particles in the biome's foliage colour); the leaf texture
  itself is pre-coloured and untinted, as before.
