package com.ridopipolop.createadditionalweapons;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.fabricmc.api.ModInitializer;

// import com.ridopipolop.createadditionalweapons.item.ModItemGroups;
import com.ridopipolop.createadditionalweapons.item.ModItems;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAdditionalWeapons implements ModInitializer {
	public static final String MOD_ID = "createadditionalweapons";
	public static final String NAME = "Create: Additional Weapons";
	public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
  public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateAdditionalWeapons.MOD_ID);


	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] is loading alongside Create [{}]!", NAME, Create.VERSION);
		LOGGER.info(EnvExecutor.unsafeRunForDist(
				() -> () -> "{} is accessing Porting Lib from the client!",
				() -> () -> "{} is accessing Porting Lib from the server!"
		), NAME);

    // Initialize the mod classes here:
    // ModItemGroups.registerItemGroups();
    ModItems.register();

    // fabric exclusive, squeeze this in here to register before stuff is used
    REGISTRATE.register();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
