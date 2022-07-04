package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.studio.nsg.components.CollisionComponent;
import com.studio.nsg.utils.PriorityComparator;
import com.studio.nsg.utils.SystemPriorities;

public class CollisionSystem extends SortedIteratingSystem {

    public CollisionSystem(){
        super(Family.all(CollisionComponent.class).get(), new PriorityComparator(), SystemPriorities.DRAWING);
    }
    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
