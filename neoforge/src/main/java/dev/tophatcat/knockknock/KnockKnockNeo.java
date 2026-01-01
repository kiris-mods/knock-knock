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
