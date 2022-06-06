package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public class ExampleSystem extends IteratingSystem {

    public ExampleSystem(Family family){
        super(family);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
