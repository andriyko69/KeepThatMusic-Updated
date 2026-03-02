package io.github.andriyko69.keepthatmusicupdated.mixin;

import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MusicManager.class)
public class MusicManagerMixin {

    @Inject(method = "stopPlaying()V", at = @At("HEAD"), cancellable = true)
    private void stopPlaying(CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "stopPlaying(Lnet/minecraft/sounds/Music;)V", at = @At("HEAD"), cancellable = true)
    private void stopPlayingMusic(CallbackInfo ci) {
        ci.cancel();
    }
}