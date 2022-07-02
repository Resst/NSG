package com.studio.nsg.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.utils.ComponentFactory;

public class Player extends NsgEntity{
    public Player() {
        super();
        add(ComponentFactory.ComponentType.PLAYER);
        setRegion(new Texture("badlogic.jpg"));
    }
}
