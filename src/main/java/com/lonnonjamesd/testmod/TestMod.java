package com.lonnonjamesd.testmod;

import com.lonnonjamesd.testmod.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("testmod")
public class TestMod
{
    public static final String MOD_ID = "testmod";
    // Directly reference a log4j logger.

    private static final Logger LOGGER = LogManager.getLogger();

    public TestMod() {
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
}
