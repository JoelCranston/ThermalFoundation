# Progress log

## Ported to 1.21.1 (2026-10-11)

Cut from `1.20.4` after the `26.1.2` port, for parity with the other repos' `1.21.1` branches. Built against
CoFHCore and ThermalCore `1.21.1` in git worktrees (`../wt-1.21.1/`).

- Build: ModDevGradle, Java 21, NeoForge 21.1.251, `neoforge.mods.toml`, the shared 1.21.1 access transformer.
- 26 compile errors: `@EventBusSubscriber`, `BootstrapContext`, `ResourceLocation.fromNamespaceAndPath/parse`,
  registry-aware loot tables (`fortune()`) and recipe provider, the datapack registry provider ahead of the tags.
- Resources: singular data folders, `c:` tags, `result.id`, the loot enchantments sub-predicate,
  `neoforge:conditions`, press recipes gated with `neoforge:item_exists`, a compostables data map. Generated assets
  and data regenerated (the model providers still exist on 1.21.1).
- The trader event threw at boot (server config not loaded yet); the trade is now always on.
