package dev.dtzudontsay.knownworld.world.geography;

/**
 * First-stage projection.
 *
 * For Milestone 1 Minecraft X maps directly to east metres and Minecraft Z
 * maps directly to south, therefore north is -Z.
 *
 * Later this class will own the transformation between the canonical master
 * map and Minecraft coordinates without changing the 1 block = 1 metre rule.
 */
public final class WorldProjection {
    public static final double METRES_PER_BLOCK = 1.0;

    private WorldProjection() {
    }

    public static WorldCoordinate fromMinecraft(double minecraftX, double minecraftZ) {
        return new WorldCoordinate(
                minecraftX * METRES_PER_BLOCK,
                -minecraftZ * METRES_PER_BLOCK
        );
    }
}
