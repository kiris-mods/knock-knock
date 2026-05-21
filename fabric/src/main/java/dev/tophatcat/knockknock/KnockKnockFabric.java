package dev.tophatcat.knockknock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;

public class KnockKnockFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        AttackBlockCallback.EVENT.register(((player, world, hand, pos, direction) -> {
            BlockState blockState = world.getBlockState(pos);
            if (!player.isSpectator() && blockState.getBlock() instanceof TrapDoorBlock) {
                world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 2F, 0F);
            }
            if (!player.isSpectator() && blockState.getBlock() instanceof DoorBlock) {
                world.playSound(null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 2F, 0F);
            }

            return InteractionResult.PASS;
            })
        );
    }
}
