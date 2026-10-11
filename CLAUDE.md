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

**This repo went 1.20.4 → 26.1.2 directly** (branches `1.20.4`, `26.1.2`), with no `1.21.1` branch: the API work was
already solved and written down by the other repos' two hops. A `1.21.1` branch can be cut later if that version ships.

## Current state

**Ported (2026-10-11): compiles, `runData` clean, boots headless to `Done` (1949 recipes on its own), 5 GameTests
pass.** Loaded in ThermalExpansion's or ThermalDynamics' dev runs with `-PwithFoundation`; TE with Foundation and
Dynamics loads 2550 recipes with no data errors. `../CoFHCore/scripts/verify_all.sh` covers it.

Unverified in a client: the rubberwood boats, signs and hanging signs, leaves, ores and every item model.
