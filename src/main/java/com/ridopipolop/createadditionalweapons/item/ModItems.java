package com.ridopipolop.createadditionalweapons.item;

import static com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons.REGISTRATE;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModItems {

  // Define items
  public static final ItemEntry<Item> IMPACT_AXE = REGISTRATE
    .item("impact_axe", Item::new)
    .properties(p -> p.stacksTo(1))
    //.transform(CreateRegistrate.customRenderedItem(() -> WeaponItemRenderer::new)
    .register();
  
  public static final ItemEntry<Item> BROAD_GLAIVE = REGISTRATE
    .item("broad_glaive", Item::new)
    .properties(p -> p.stacksTo(1))
    .register();

  public static final ItemEntry<Item> RUBBER_DUCK = REGISTRATE
    .item("rubber_duck", Item::new)
    .properties(p -> p.stacksTo(64))
    .register();
  
  
  public static void register() {
    CreateAdditionalWeapons.LOGGER.info("Registiring items for " + CreateAdditionalWeapons.NAME);
  }
}
