package com.studio.nsg.utils;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.studio.nsg.components.TextureComponent;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Entity> {
    private final ComponentMapper<TextureComponent> mapper;

    public PriorityComparator(){
        mapper = ComponentMapper.getFor(TextureComponent.class);
    }

    @Override
    public int compare(Entity o1, Entity o2) {

        int z1 = mapper.get(o1).priority;
        int z2 = mapper.get(o2).priority;

        return Integer.compare(z1, z2);
    }
}

