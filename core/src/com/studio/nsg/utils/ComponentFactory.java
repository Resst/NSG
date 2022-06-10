package com.studio.nsg.utils;

import com.badlogic.ashley.core.Component;
import com.studio.nsg.components.*;

public class ComponentFactory {
    public static Component getComponent(ComponentType componentType){
        switch (componentType){
            case TRANSFORM:
                return new TransformComponent();
            case ENTITY_STAT:
                return new EntityStatComponent();
            case TEXTURE:
                return new TextureComponent();
            case ANIMATION:
                return new AnimationComponent();
            case BODY:
                return new BodyComponent();
            case COLLISION:
                return new CollisionComponent();
            case PLAYER:
                return new PlayerComponent();
            default:
                throw new RuntimeException("No such component");
        }
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
