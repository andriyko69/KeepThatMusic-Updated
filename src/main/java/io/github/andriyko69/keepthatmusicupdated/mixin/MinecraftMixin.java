package io.github.andriyko69.keepthatmusicupdated.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Shadow
    private volatile boolean pause;

    @Final
    @Shadow
    private MusicManager musicManager;


    @Inject(method = "tick", at = @At("RETURN"))
    private void keepthatmusic$tick(CallbackInfo ci) {
        if (pause) {
            this.musicManager.tick();
        }
    }
}