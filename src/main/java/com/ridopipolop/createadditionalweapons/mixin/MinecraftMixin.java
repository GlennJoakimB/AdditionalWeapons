package com.ridopipolop.createadditionalweapons.mixin;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class MinecraftMixin {
	@Inject(method = "init", at = @At("TAIL"))
	private void exampleMixin(CallbackInfo ci) {
		CreateAdditionalWeapons.LOGGER.info("A quick hello from {}", CreateAdditionalWeapons.NAME);
	}
}
