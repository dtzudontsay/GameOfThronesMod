package dev.dtzudontsay.knownworld.world.data;

import dev.dtzudontsay.knownworld.world.geography.WorldCoordinate;
import dev.dtzudontsay.knownworld.world.terrain.PlaceholderTerrainProvider;
import dev.dtzudontsay.knownworld.world.terrain.TerrainProvider;
import dev.dtzudontsay.knownworld.world.terrain.TerrainSample;

/**
 * Single access point for world-scale geographic data.
 *
 * Future providers for elevation, coastlines, climate, rivers, roads and
 * regions will be coordinated here.
 */
public final class GeographicDataManager {
    private static final GeographicDataManager INSTANCE = new GeographicDataManager();

    private final TerrainProvider terrainProvider;

    private GeographicDataManager() {
        this.terrainProvider = new PlaceholderTerrainProvider();
    }

    public static GeographicDataManager getInstance() {
        return INSTANCE;
    }

    public TerrainSample sample(WorldCoordinate coordinate) {
        return terrainProvider.sample(coordinate);
    }
}
