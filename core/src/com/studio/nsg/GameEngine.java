package com.studio.nsg;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.studio.nsg.systems.AnimationSystem;
import com.studio.nsg.systems.DrawingSystem;

public class GameEngine extends Engine {
    private final SpriteBatch batch;
    private final World world;

    public GameEngine(){
        super();

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        addSystem(new DrawingSystem(batch));
        addSystem(new AnimationSystem());

        //TODO init systems
    }
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        getSystem(DrawingSystem.class).update(deltaTime);
        getSystem(AnimationSystem.class).update(deltaTime);
    }
}
