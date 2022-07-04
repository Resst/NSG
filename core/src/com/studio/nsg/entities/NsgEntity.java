package com.studio.nsg.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.utils.ComponentFactory;

public class NsgEntity extends Entity {

    protected final TransformComponent transform;
    protected final TextureComponent texture;

    public NsgEntity(){
        add(ComponentFactory.ComponentType.TRANSFORM);
        add(ComponentFactory.ComponentType.TEXTURE);
        add(ComponentFactory.ComponentType.ENTITY_STAT);
        //add(ComponentFactory.ComponentType.ANIMATION);
        add(ComponentFactory.ComponentType.BODY);
        add(ComponentFactory.ComponentType.COLLISION);
        transform = getComponent(TransformComponent.class);
        texture = getComponent(TextureComponent.class);
    }

    public Entity add(ComponentFactory.ComponentType type) {
        return super.add(ComponentFactory.getComponent(type));
    }

    public void updateTransform(){
        Sprite sprite = texture.sprite;
        sprite.setOriginBasedPosition(transform.position.x, transform.position.y);
        sprite.setRotation(transform.rotation);
        sprite.setScale(transform.scale.x, transform.scale.y);
    }

    public Entity setPosition(Vector2 position){
        return setPosition(position.x, position.y);
    }
    public Entity setPosition(float x, float y) {
        transform.position.set(x, y);
        updateTransform();
        return this;
    }
    public Entity translate(Vector2 translation){
        return translate(translation.x, translation.y);
    }
    public Entity translate(float x, float y) {
        transform.position.add(x, y);
        updateTransform();
        return this;
    }


    public Entity setScale(Vector2 scale){
        return setScale(scale.x, scale.y);
    }
    public Entity setScale(float XY){
        return setScale(XY, XY);
    }
    public Entity setScale(float x, float y) {
        transform.scale.set(x, y);
        updateTransform();
        return this;
    }

    public Entity setRotation(float rot){
        transform.rotation = rot;
        updateTransform();
        return this;
    }
    public Entity rotate(float rot){
        transform.rotation += rot;
        updateTransform();
        return this;
    }

    public Entity setRegion(Texture texture){
        this.texture.sprite.setRegion(texture);
        this.texture.sprite.setSize(texture.getWidth(), texture.getHeight());
        return this;
    }
    public Entity setRegion(TextureRegion region){
        this.texture.sprite.setRegion(region);
        return this;
    }

}
