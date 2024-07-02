package com.ridopipolop.additionalweapons.mixin;

import com.ridopipolop.additionalweapons.AdditionalWeapons;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MinecraftMixin {
	@Inject(method = "init", at = @At("TAIL"))
	private void exampleMixin(CallbackInfo ci) {
		AdditionalWeapons.LOGGER.info("A quick hello from {}", AdditionalWeapons.NAME);
	}
}
