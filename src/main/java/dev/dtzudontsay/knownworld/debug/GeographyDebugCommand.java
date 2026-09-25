package dev.dtzudontsay.knownworld.debug;

import com.mojang.brigadier.context.CommandContext;
import dev.dtzudontsay.knownworld.world.data.GeographicDataManager;
import dev.dtzudontsay.knownworld.world.geography.WorldCoordinate;
import dev.dtzudontsay.knownworld.world.geography.WorldProjection;
import dev.dtzudontsay.knownworld.world.terrain.TerrainSample;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;

public final class GeographyDebugCommand {

    private GeographyDebugCommand() {
    }

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                dispatcher.register(
                        Commands.literal("knownworld")
                                .then(Commands.literal("geo")
                                        .executes(GeographyDebugCommand::executeGeo))
                )
        );
    }

    private static int executeGeo(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        Vec3 position = source.getPosition();

        WorldCoordinate worldCoordinate =
                WorldProjection.fromMinecraft(position.x, position.z);

        TerrainSample terrain =
                GeographicDataManager.getInstance().sample(worldCoordinate);

        source.sendSuccess(
                () -> Component.literal(
                        "Known World | Minecraft X %.2f Z %.2f | East %.2f m North %.2f m"
                                .formatted(
                                        position.x,
                                        position.z,
                                        worldCoordinate.eastMetres(),
                                        worldCoordinate.northMetres()
                                )
                ),
                false
        );

        source.sendSuccess(
                () -> Component.literal(
                        "Scale 1 block = 1 m | Region %s | Elevation %.1f m | Data %s"
                                .formatted(
                                        terrain.region(),
                                        terrain.elevationMetres(),
                                        terrain.dataSource()
                                )
                ),
                false
        );

        return 1;
    }
}
