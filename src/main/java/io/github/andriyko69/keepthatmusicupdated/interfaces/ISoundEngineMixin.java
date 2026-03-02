package io.github.andriyko69.keepthatmusicupdated.interfaces;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;

public interface ISoundEngineMixin {
    ChannelAccess.ChannelHandle keepThatMusic_Updated$getChannelHandle(SoundInstance soundInstance);
}
