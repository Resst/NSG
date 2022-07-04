package com.studio.nsg.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.studio.nsg.components.BodyComponent;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.utils.ComponentFactory;

public class Player extends NsgEntity{

    private final float speed = 10f;

    public Player() {
        super();
        add(ComponentFactory.ComponentType.PLAYER);
        setRegion(new Texture("badlogic.jpg"));
    }

    public void move(Vector2 direction){
        getComponent(BodyComponent.class).body
                .setLinearVelocity(direction.x * speed, direction.y * speed);
    }
}
