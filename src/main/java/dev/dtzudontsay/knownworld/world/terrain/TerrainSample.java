package dev.dtzudontsay.knownworld.world.terrain;

/**
 * A single query result from the Known World geographic data system.
 *
 * Values are deliberately minimal in Milestone 1. Elevation, climate, region,
 * rivers and biome data will be added through the same sampling API.
 */
public record TerrainSample(
        double elevationMetres,
        String region,
        String dataSource
) {
}
