package com.ridopipolop.createadditionalweapons.events;

import com.ridopipolop.createadditionalweapons.content.weapons.broad_glaive.BroadGlaiveItem;

import io.github.fabricators_of_create.porting_lib.entity.events.EntityDataEvents;
import io.github.fabricators_of_create.porting_lib.entity.events.LivingEntityEvents.LivingTickEvent;

public class CommonEvents {

  public static void register() {
    // External Events

    // Handle the range-increase of holding the glaive
    LivingTickEvent.TICK.register(BroadGlaiveItem::holdingGlaiveIncreasesRange);
    EntityDataEvents.LOAD.register(BroadGlaiveItem::addRangeToJoiningPlayersHoldingGlaive);
  }
}
