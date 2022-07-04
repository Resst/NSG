package com.studio.nsg;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.studio.nsg.entities.Player;
import com.studio.nsg.systems.AnimationSystem;
import com.studio.nsg.systems.DrawingSystem;
import com.studio.nsg.systems.PlayerControlSystem;

public class GameEngine extends Engine {
    private final SpriteBatch batch;
    private final World world;

    public GameEngine(){
        super();

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        initEntities();
    }

    private void initEntities(){
        addEntity(new Player());
        addSystem(new DrawingSystem(batch));
        addSystem(new AnimationSystem());
        addSystem(new PlayerControlSystem());
        //TODO init systems
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
