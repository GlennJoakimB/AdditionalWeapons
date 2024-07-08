package com.ridopipolop.createadditionalweapons.events;

import com.ridopipolop.createadditionalweapons.content.weapons.BroadGlaiveItem;

import io.github.fabricators_of_create.porting_lib.entity.events.EntityDataEvents;
import io.github.fabricators_of_create.porting_lib.entity.events.LivingEntityEvents;

public class CommonEvents {

  public static void register() {
    // External Events

    LivingEntityEvents.TICK.register(BroadGlaiveItem::holdingGlaiveIncreasesRange);
    EntityDataEvents.LOAD.register(BroadGlaiveItem::addRangeToJoiningPlayersHoldingGlaive);
  }
}
