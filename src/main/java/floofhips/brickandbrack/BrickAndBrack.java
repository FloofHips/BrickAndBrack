package floofhips.brickandbrack;

import floofhips.brickandbrack.datagen.*;
import floofhips.brickandbrack.init.BlockInit;
import floofhips.brickandbrack.init.InitContent;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BrickAndBrack.MOD_ID)
public class BrickAndBrack
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "brickandbrack";

    public BrickAndBrack() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        InitContent.register();

        bus.addListener(this::setup);
        bus.addListener(this::dataSetup);
        bus.addListener(this::enqueueIMC);
        bus.addListener(this::processIMC);
        bus.addListener(this::doClientStuff);
        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("brickandbrack", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockInit.SHRUB.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.LATTICE_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockInit.LARGE_CHAINS.get(), RenderType.cutout());
    }

    private void dataSetup(GatherDataEvent event)
    {
        DataGenerator dataGenerator = event.getGenerator();
        if (event.includeServer())
        {
            dataGenerator.addProvider(new RecipeGen(dataGenerator));
            dataGenerator.addProvider(new LootTableGen(dataGenerator));
        }
        if (event.includeClient())
        {
            dataGenerator.addProvider(new LanguageGen(dataGenerator));
            dataGenerator.addProvider(new ItemModelGen(dataGenerator));
        }
    }

}
