package io.github.andriyko69.keepthatmusicupdated.mixin;

import io.github.andriyko69.keepthatmusicupdated.interfaces.ISoundEngineMixin;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(SoundEngine.class)
public class SoundEngineMixin implements ISoundEngineMixin {
    @Final
    @Shadow
    private Map<SoundInstance, ChannelAccess.ChannelHandle> instanceToChannel;


    @Override
    public ChannelAccess.ChannelHandle keepThatMusic_Updated$getChannelHandle(SoundInstance soundInstance) {
        return this.instanceToChannel.get(soundInstance);
    }
}
