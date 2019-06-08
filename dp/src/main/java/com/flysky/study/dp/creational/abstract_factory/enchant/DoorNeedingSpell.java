package com.flysky.study.dp.creational.abstract_factory.enchant;

import com.flysky.study.dp.creational.abstract_factory.Door;
import com.flysky.study.dp.creational.abstract_factory.Room;

public class DoorNeedingSpell extends Door {
    public DoorNeedingSpell(Room room1, Room room2) {
        super(room1, room2);
    }
}
