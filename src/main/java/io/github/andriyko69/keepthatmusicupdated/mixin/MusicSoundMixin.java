package io.github.andriyko69.keepthatmusicupdated.mixin;

import net.minecraft.sounds.Music;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Music.class)
public class MusicSoundMixin {

    @Inject(method = "replaceCurrentMusic", at = @At("HEAD"), cancellable = true)
    private void replaceCurrentMusic(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        cir.cancel();
    }

    @Inject(method = "getMaxDelay", at = @At("HEAD"), cancellable = true)
    private void getMaxDelay(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(-1);
        cir.cancel();
    }
}
