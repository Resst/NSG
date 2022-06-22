package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.utils.SystemPriorities;
import com.studio.nsg.utils.PriorityComparator;

public class DrawingSystem extends SortedIteratingSystem {

    static final float PPM = 16;

    static final float METERS_WIDTH = Gdx.graphics.getWidth() / PPM;
    static final float METERS_HEIGHT = Gdx.graphics.getHeight() / PPM;

    public static final float SCALE = 1 / PPM;

    public static float PixelsToMeters(float pixels){
        return pixels * SCALE;
    }

    private final OrthographicCamera cam;
    private final SpriteBatch batch;
    private final Sprite drawingSprite;
    private final OrthogonalTiledMapRenderer mapRenderer;

    public DrawingSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class).get(), new PriorityComparator(), SystemPriorities.DRAWING);
        this.batch = batch;

        mapRenderer = new OrthogonalTiledMapRenderer(null, SCALE);
        cam = new OrthographicCamera(METERS_WIDTH, METERS_HEIGHT);
        cam.position.set(METERS_WIDTH / 2, METERS_HEIGHT / 2,0);

        drawingSprite = new Sprite();
    }

    @Override
    public void update(float deltaTime) {
        cam.update();
        batch.setProjectionMatrix(cam.combined);

        if (mapRenderer.getMap() != null){
            mapRenderer.setView(cam);
            mapRenderer.render();
        }

        batch.begin();
        super.update(deltaTime);    //processes entities
        batch.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        Sprite sprite = entity.getComponent(TextureComponent.class).sprite;
        TransformComponent transform = entity.getComponent(TransformComponent.class);

        if (transform == null){
            sprite.draw(batch);
            return;
        }

        drawingSprite.set(sprite);
        drawingSprite.setOriginBasedPosition(transform.position.x, transform.position.y);
        drawingSprite.setScale(drawingSprite.getScaleX() * transform.scale.x, drawingSprite.getScaleY() * transform.scale.y);
        drawingSprite.rotate((float)Math.toDegrees(transform.rotation));
        drawingSprite.draw(batch);
    }

    public OrthographicCamera getCamera(){
        return cam;
    }

    public void setMap(TiledMap map){
        mapRenderer.setMap(map);
    }
}
