package com.studio.nsg;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.entities.Player;
import com.studio.nsg.systems.AnimationSystem;
import com.studio.nsg.systems.DrawingSystem;
import com.studio.nsg.systems.PlayerControlSystem;
import com.studio.nsg.utils.MyContactListener;

public class GameEngine extends Engine {
    private final SpriteBatch batch;
    public final World world;
    Box2DDebugRenderer debugRenderer;

    public GameEngine(){
        super();

        batch = new SpriteBatch();
        world = new World(new Vector2(0,0),true);
        initEntities();
    }

    private void initEntities(){
        //TODO make it normal
        Player player = new Player();
        player.setScale(5, 5);
        player.getComponent(TextureComponent.class).sprite.setOriginCenter();
        player.initBody(world);
        player.setPosition(10, 10);
        addEntity(player);
        addSystem(new DrawingSystem(batch));
        addSystem(new AnimationSystem());
        addSystem(new PlayerControlSystem());
        world.setContactListener(new MyContactListener());
        debugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void update(float deltaTime) {
        world.step(1/60f,6,2);
        super.update(deltaTime);
        debugRenderer.render(world,batch.getProjectionMatrix());

    }
}
