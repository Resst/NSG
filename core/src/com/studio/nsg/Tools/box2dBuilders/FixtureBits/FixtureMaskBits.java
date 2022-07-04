package com.studio.nsg.Tools.box2dBuilders.FixtureBits;

public class FixtureMaskBits {
    public static final int
            COLLISION           = 0b00001,
            FRIENDLY_HIT_BOX    = 0b10000,
            FRIENDLY_HURT_BOX   = 0b01000,
            ENEMY_HIT_BOX       = 0b00100,
            ENEMY_HURT_BOX      = 0b00010;
}
