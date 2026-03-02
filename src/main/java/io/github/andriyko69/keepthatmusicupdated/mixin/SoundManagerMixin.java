package io.github.andriyko69.keepthatmusicupdated.mixin;

import io.github.andriyko69.keepthatmusicupdated.interfaces.ISoundManagerMixin;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SoundManager.class)
public class SoundManagerMixin implements ISoundManagerMixin {

    @Final
    @Shadow
    private SoundEngine soundEngine;

    @Inject(method = "stop()V", at = @At("HEAD"), cancellable = true)
    private void close(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "pause()V", at = @At("HEAD"), cancellable = true)
    private void pause(CallbackInfo ci) {
        ci.cancel();
    }


    @Override
    public SoundEngine keepThatMusic_Updated$getSoundEngine() {
        return this.soundEngine;
    }
}
