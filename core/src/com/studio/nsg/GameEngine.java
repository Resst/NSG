package com.studio.nsg;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.studio.nsg.entities.Player;
import com.studio.nsg.systems.DrawingSystem;
import com.studio.nsg.systems.PlayerControlSystem;

public class GameEngine extends Engine {
    private final SpriteBatch batch;
    private final TmxMapLoader mapLoader;
    private final World world;
    public final DrawingSystem drawingSystem;
    public final PlayerControlSystem playerControlSystem;

    public GameEngine(){
        super();

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        mapLoader = new TmxMapLoader();

        drawingSystem = new DrawingSystem(batch);
        addSystem(drawingSystem);
        playerControlSystem = new PlayerControlSystem();
        addSystem(playerControlSystem);
        initEntities();
    }

    private void initEntities(){
        addEntity(new Player());
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
