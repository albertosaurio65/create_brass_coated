package com.injir.create_brass_coated;

import com.injir.create_brass_coated.blocks.depot.BrassEjectorTargetHandler;
import com.injir.create_brass_coated.blocks.girder.brass.BrassGirderWrenchBehavior;
import com.injir.create_brass_coated.blocks.girder.copper.CopperGirderWrenchBehavior;
import com.simibubi.create.content.contraptions.components.fan.AirCurrent;
import com.simibubi.create.content.contraptions.components.structureMovement.interaction.controls.ControlsHandler;
import com.simibubi.create.content.contraptions.components.turntable.TurntableHandler;
import com.simibubi.create.content.logistics.item.LinkedControllerClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(Dist.CLIENT)
public class BrassClientEvents {


    private static final String ITEM_PREFIX = "item." + Create_Brass_Coated.ID;
    private static final String BLOCK_PREFIX = "block." + Create_Brass_Coated.ID;

    @SubscribeEvent
    public static void onTick(TickEvent.ClientTickEvent event) {
        if (!isGameActive())
            return;

        Level world = Minecraft.getInstance().level;
        if (event.phase == TickEvent.Phase.START) {
            BrassGirderWrenchBehavior.tick();
            CopperGirderWrenchBehavior.tick();
            return;
        }
        BrassEjectorTargetHandler.tick();


    }
    protected static boolean isGameActive() {
        return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
    }

    @SubscribeEvent
    public static void onRenderTick(TickEvent.RenderTickEvent event) {
        if (!isGameActive())
            return;
        TurntableHandler.gameRenderTick();
    }


}
