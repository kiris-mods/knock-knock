package dev.tophatcat.knockknock;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod("knockknock")
public class KnockKnockNeo {

    public KnockKnockNeo(IEventBus bus) {
        NeoForge.EVENT_BUS.addListener(this::onPlayerInteract);
    }

    public void onPlayerInteract(PlayerInteractEvent.LeftClickBlock event) {
        BlockState blockState = event.getLevel().getBlockState(event.getPos());
        if (!event.getEntity().isSpectator() && blockState.getBlock() instanceof TrapDoorBlock) {
            event.getLevel().playSound(null, event.getPos(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 2F, 0F);
        }
        if (!event.getEntity().isSpectator() && blockState.getBlock() instanceof DoorBlock) {
            event.getLevel().playSound(null, event.getPos(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 2F, 0F);
        }
    }
}
