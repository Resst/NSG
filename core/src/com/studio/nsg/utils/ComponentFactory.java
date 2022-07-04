package com.studio.nsg.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.studio.nsg.components.*;
import com.studio.nsg.systems.DrawingSystem;

public class ComponentFactory {
    public static Component getComponent(ComponentType componentType){
        Component res;

        switch (componentType){
            case TRANSFORM:
                TransformComponent transform = new TransformComponent();
                transform.scale.set(DrawingSystem.SCALE, DrawingSystem.SCALE);
                res = transform;
                break;
            case ENTITY_STAT:
                 res = new EntityStatComponent();
                break;
            case TEXTURE:
                TextureComponent texture = new TextureComponent();
                res = texture;
                break;
            case ANIMATION:
                res = new AnimationComponent();
                break;
            case BODY:
                //TODO make initiation of body component
                res = new BodyComponent();
                break;
            case COLLISION:
                res = new CollisionComponent();
                break;
            case PLAYER:
                res = new PlayerComponent();
                break;
            default:
                throw new RuntimeException("No such component");
        }

        return res;
    }


    public enum ComponentType {
        TRANSFORM,
        ENTITY_STAT,
        TEXTURE,
        ANIMATION,
        BODY,
        COLLISION,
        PLAYER
    }
}
