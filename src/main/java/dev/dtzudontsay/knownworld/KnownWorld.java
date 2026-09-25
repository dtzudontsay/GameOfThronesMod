package dev.dtzudontsay.knownworld;

import dev.dtzudontsay.knownworld.debug.GeographyDebugCommand;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class KnownWorld implements ModInitializer {
    public static final String MOD_ID = "knownworld";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        GeographyDebugCommand.register();
        LOGGER.info("Known World initialized. Horizontal scale: 1 block = 1 metre.");
    }
}
