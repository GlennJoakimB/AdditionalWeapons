package com.ridopipolop.additionalweapons.item;

import static com.ridopipolop.additionalweapons.AdditionalWeapons.REGISTRATE;

import com.ridopipolop.additionalweapons.AdditionalWeapons;
import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;


public class ModItems {

  // Adds the items to the Create tab.
  // Doesn't work at the moment
  static {
    REGISTRATE.setCreativeTab(AllCreativeModeTabs.BASE_CREATIVE_TAB.key());
  }

  // Define items
  public static final ItemEntry<Item> IMPACT_AXE = REGISTRATE.item("impact_axe", Item::new)
    .properties(p -> p.stacksTo(1))
    //.transform(CreateRegistrate.customRenderedItem(() -> WeaponItemRenderer::new)
    .register();
  
  public static final ItemEntry<Item> BROAD_GLAIVE = REGISTRATE.item("broad_glaive", Item::new)
    .properties(p -> p.stacksTo(1))
    .register();

  public static final ItemEntry<Item> RUBBER_DUCK = REGISTRATE.item("rubber_duck", Item::new)
    .properties(p -> p.stacksTo(16))
    .register();
  
  
  public static void register() {
    AdditionalWeapons.LOGGER.info("Registiring items for " + AdditionalWeapons.NAME);
  }
}
