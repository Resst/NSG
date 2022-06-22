package com.studio.nsg;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.studio.nsg.systems.DrawingSystem;

public class GameEngine extends Engine {
    private final SpriteBatch batch;
    private final TmxMapLoader mapLoader;
    private final World world;
    public final DrawingSystem drawingSystem;

    public GameEngine(){
        super();

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        mapLoader = new TmxMapLoader();
        drawingSystem = new DrawingSystem(batch);
        addSystem(drawingSystem);
        //TODO init systems
    }
    @Override
    public void update(float deltaTime) {
        drawingSystem.update(deltaTime);
        super.update(deltaTime);
    }
}
