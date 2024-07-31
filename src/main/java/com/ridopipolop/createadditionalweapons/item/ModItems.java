package com.ridopipolop.createadditionalweapons.item;

import static com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons.REGISTRATE;

import com.ridopipolop.createadditionalweapons.CreateAdditionalWeapons;
import com.ridopipolop.createadditionalweapons.content.weapons.ImpactAxeItem;
import com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive.BroadGlaiveItem;
import com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive.BroadGlaiveItemRenderer;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ModItems {

  // Define items
  public static final ItemEntry<ImpactAxeItem> IMPACT_AXE = REGISTRATE
    .item("impact_axe", ImpactAxeItem::new)
    .properties(p -> p.stacksTo(1))
    //.transform(CreateRegistrate.customRenderedItem(() -> WeaponItemRenderer::new)
    .register();
  
  public static final ItemEntry<BroadGlaiveItem> BROAD_GLAIVE = REGISTRATE
    .item("broad_glaive", BroadGlaiveItem::new)
    .properties(p -> p.stacksTo(1).durability(500))
    .transform(CreateRegistrate.customRenderedItem(() -> BroadGlaiveItemRenderer::new))
    .model(AssetLookup.itemModelWithPartials())
    .register();

  public static final ItemEntry<Item> GOLDEN_DUCK = REGISTRATE
    .item("golden_duck", Item::new)
    .properties(p -> p.stacksTo(64))
    .register();
  
  
  public static void register() {
    CreateAdditionalWeapons.LOGGER.info("Registiring items for {}.", CreateAdditionalWeapons.NAME);
  }
}
