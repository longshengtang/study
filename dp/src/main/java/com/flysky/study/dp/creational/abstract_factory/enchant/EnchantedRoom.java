package com.flysky.study.dp.creational.abstract_factory.enchant;

import com.flysky.study.dp.creational.abstract_factory.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int no, Spell spell) {
        super(no);
        this.spell = spell;
    }

    private Spell spell;
}
