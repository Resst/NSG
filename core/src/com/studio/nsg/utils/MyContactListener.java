package com.studio.nsg.utils;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.studio.nsg.components.CollisionComponent;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.utils.FixtureBits.FixtureCategoryBits;

public class MyContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        int bits1 = contact.getFixtureA().getFilterData().categoryBits;
        int bits2 = contact.getFixtureB().getFilterData().categoryBits;
        Entity e1 = (Entity)contact.getFixtureA().getUserData();
        Entity e2 = (Entity)contact.getFixtureB().getUserData();
        if(bits1 == FixtureCategoryBits.FRIENDLY_HIT_BOX || bits1 == FixtureCategoryBits.ENEMY_HIT_BOX){
            e1.getComponent(CollisionComponent.class).collided.add(e2);
        }
        if(bits2 == FixtureCategoryBits.FRIENDLY_HIT_BOX || bits1 == FixtureCategoryBits.ENEMY_HIT_BOX){
            e2.getComponent(CollisionComponent.class).collided.add(e1);
        }
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
