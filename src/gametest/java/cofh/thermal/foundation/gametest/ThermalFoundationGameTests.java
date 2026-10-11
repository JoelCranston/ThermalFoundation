package cofh.thermal.foundation.gametest;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.FunctionGameTestInstance;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.gametest.framework.TestData;
import net.minecraft.gametest.framework.TestEnvironmentDefinition;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Rotation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterGameTestsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

import static cofh.lib.util.constants.ModIds.ID_THERMAL_FOUNDATION;

@EventBusSubscriber (modid = ID_THERMAL_FOUNDATION)
public class ThermalFoundationGameTests {

    private static final Map<String, Consumer<GameTestHelper>> TESTS = new LinkedHashMap<>();

    static {
        TESTS.put("rubberwood_sapling_grows", RubberwoodTests::saplingGrows);
        TESTS.put("rubberwood_log_strips", RubberwoodTests::logStrips);
        TESTS.put("rubberwood_compostable", RubberwoodTests::compostable);
        TESTS.put("recipes_sync", RecipeTests::recipesSync);
    }

    @SubscribeEvent
    public static void registerFunctions(RegisterEvent event) {

        event.register(Registries.TEST_FUNCTION, helper -> TESTS.forEach((name, test) -> helper.register(id(name), test)));
    }

    @SubscribeEvent
    public static void registerTests(RegisterGameTestsEvent event) {

        Holder<TestEnvironmentDefinition<?>> environment = event.registerEnvironment(id("default"));
        // Sky access leaves the test area unroofed, so a tree has room to grow.
        TestData<Holder<TestEnvironmentDefinition<?>>> data = new TestData<>(environment, id("empty"), 400, 0, true, Rotation.NONE, false, 1, 1, true, 0);
        TESTS.keySet().forEach(name -> event.registerTest(id(name), new FunctionGameTestInstance(ResourceKey.create(Registries.TEST_FUNCTION, id(name)), data)));
    }

    private static Identifier id(String path) {

        return Identifier.fromNamespaceAndPath(ID_THERMAL_FOUNDATION, path);
    }

}
