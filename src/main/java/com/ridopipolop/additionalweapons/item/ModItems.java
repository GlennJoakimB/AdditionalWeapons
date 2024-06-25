package com.ridopipolop.additionalweapons.item;

import static com.ridopipolop.additionalweapons.AdditionalWeapons.REGISTRATE;

import com.ridopipolop.additionalweapons.AdditionalWeapons;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;


public class ModItems {

  // Define items
  public static final ItemEntry<Item> IMPACT_AXE = REGISTRATE.item("impact_axe", Item::new)
    .properties(p -> p.stacksTo(1))
    //.transform(CreateRegistrate.customRenderedItem(() -> WeaponItemRenderer::new)
    .register();
  
  
  public static void register() {
    AdditionalWeapons.LOGGER.info("Registiring items for " + AdditionalWeapons.NAME);
  }



//   // Initializes the items into existance
//   public static void Initialize() {
//     ItemGroupEvents
//       .modifyEntriesEvent(ItemGroups.COMBAT)
//       .register((itemGroup) -> itemGroup.add(ModItems.IMPACT_AXE));
//   }
}
