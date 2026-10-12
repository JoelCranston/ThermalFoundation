# TODO

## Owed

1. **Client pass.** Nothing on this branch has been seen in a client.

## Inbox

- **The wandering trader's rubberwood sapling ignores "Enable Wandering Trader Trades"**: NeoForge builds trades
  while the datapacks load, before ThermalCore's server config exists, so reading it threw and stopped the server
  from starting. The trade is always on (upstream's default), as on `26.1.2`.
- **Press recipes that use ThermalExpansion's dies load only when the die exists** (`neoforge:item_exists`).
- **Composting is the `neoforge:compostables` data map**: 21.1's composter reads only the data map, so
  `ComposterBlock.add` did nothing.
- The recycling recipes' Forge-era `conditions` key is now `neoforge:conditions` (it was silently ignored).
