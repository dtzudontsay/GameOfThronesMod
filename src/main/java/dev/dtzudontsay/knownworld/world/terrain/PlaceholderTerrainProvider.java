package dev.dtzudontsay.knownworld.world.terrain;

import dev.dtzudontsay.knownworld.world.geography.WorldCoordinate;

/**
 * Temporary provider used only to prove that arbitrary world coordinates can
 * be queried deterministically before real geographic datasets are connected.
 */
public final class PlaceholderTerrainProvider implements TerrainProvider {

    @Override
    public TerrainSample sample(WorldCoordinate coordinate) {
        return new TerrainSample(
                0.0,
                "UNASSIGNED",
                "MILESTONE_1_PLACEHOLDER"
        );
    }
}
