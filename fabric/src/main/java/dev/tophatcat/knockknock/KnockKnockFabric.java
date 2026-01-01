/*
 * The Knock Knock mod, revived for both NeoForge and Fabric.
 * Copyright (C) KiriCattus 2013 - 2026
 * https://github.com/kiris-mods/knock-knock/blob/dev/LICENSE.md
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
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
