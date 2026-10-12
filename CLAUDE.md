# ThermalFoundation — NeoForge port

## Where things are

| File | Read it when |
|---|---|
| **This file** | Always. Context, decisions, and current state. |
| `../CoFHCore/CLAUDE.md` | Always, next. The whole port's decisions, working method and state live there. |
| [docs/TODO.md](docs/TODO.md) | Picking up work. **Anything noticed mid-session goes in its Inbox.** |
| [docs/progress-log.md](docs/progress-log.md) | The story behind a decision. Append-only. |
| `../CoFHCore/docs/api-notes-26.1.2.md` | Writing any code against a 26.1.2 API. Foundation's own shapes are in its "B.10 ThermalFoundation" section. |
| `../CoFHCore/docs/code-style.md` | Before writing any code. Upstream CoFH's style. |

## Context

Thermal Foundation is the Thermal Series' resource mod: tin, lead, silver and nickel; bronze, electrum, invar and
constantan; ruby and sapphire; apatite, cinnabar, niter and sulfur ores; oil sands; the rubberwood set (logs, leaves,
sapling, planks, doors, signs, boats); their worldgen. It registers everything through ThermalCore's
`RegistrationHelper` into the `thermal` namespace and enables it with `ThermalFlags`. Without it, ThermalCore and
ThermalExpansion recipes that call for these materials load but can't be crafted.

It depends on **CoFHCore** and **ThermalCore** (`includeBuild`), and was added to the port on 2026-10-11, after the
other four repos were done. Forked from `CoFH/ThermalFoundation` (branch `1.20.x`, NeoForge 1.20.4) to
`JoelCranston/ThermalFoundation`; `upstream` is CoFH's.

## Decisions already made

Same as CoFHCore's (`../CoFHCore/CLAUDE.md`): license, NeoForge 26.1.2.109, ModDevGradle 2.0.147, branch per target
version, upstream code style, verify every shape against the jar.

Branches: `1.20.4` (upstream's base), `1.21.1` and `26.1.2`, each ported from `1.20.4` (Joel asked for the `1.21.1`
branch after the `26.1.2` port).

## Current state

**Branch `1.21.1` (2026-10-11): compiles, `runData` clean, boots headless to `Done` with 1723 recipes, no data
errors.** Ported 1.20.4 → 1.21.1 for parity with the other repos' `1.21.1` branches; the `26.1.2` branch was ported
separately from `1.20.4`. Shapes are in `../CoFHCore/docs/api-notes-1.21.1.md`. No GameTests on this branch (the
other repos' `1.21.1` branches have none either), and nothing has been seen in a client.

To build it, CoFHCore and ThermalCore must be on their `1.21.1` branches (`includeBuild`). The port used git
worktrees under `../wt-1.21.1/` for that, so the main checkouts stayed on `26.1.2`.
