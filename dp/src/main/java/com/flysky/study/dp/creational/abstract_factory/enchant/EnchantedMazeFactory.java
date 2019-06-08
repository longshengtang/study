package com.flysky.study.dp.creational.abstract_factory.enchant;

import com.flysky.study.dp.creational.abstract_factory.Door;
import com.flysky.study.dp.creational.abstract_factory.MazeFactory;
import com.flysky.study.dp.creational.abstract_factory.Room;

public class EnchantedMazeFactory extends MazeFactory {
    @Override
    public Room makeRoom(int no) {
        return new EnchantedRoom(no, getSpell());
    }

    private Spell getSpell() {
        return new Spell();
    }

    @Override
    public Door makeDoor(Room room1, Room room2) {
        return new DoorNeedingSpell(room1, room2);
    }
}
