package com.studio.nsg.Tools.box2dBuilders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class BodyBuilder {
    private BodyDef bodyDef;
    public BodyBuilder(){
        bodyDef = new BodyDef();
    }
    public Body build(World world){
        Body body = world.createBody(bodyDef);
        bodyDef = new BodyDef();
        return body;
    }
    public BodyBuilder setAllowSleep(boolean allowSleep){
        bodyDef.allowSleep = allowSleep;
        return this;
    }
    public BodyBuilder setPosition(float x, float y){
        bodyDef.position.x = x;
        bodyDef.position.y = y;
        return this;
    }
    public BodyBuilder setPosition(Vector2 position){
        return setPosition(position.x,position.y);
    }
    public BodyBuilder setAngle(float angle){
        bodyDef.angle = angle;
        return this;
    }
    public BodyBuilder setActive(boolean active){
        bodyDef.active = active;
        return this;
    }
    public BodyBuilder setAngularDamping(float angularDamping){
        bodyDef.angularDamping = angularDamping;
        return this;
    }
    public BodyBuilder setAngularVelocity(float angularVelocity){
        bodyDef.angularVelocity = angularVelocity;
        return this;
    }
    public BodyBuilder setAwake(boolean awake){
        bodyDef.awake = awake;
        return this;
    }
    public BodyBuilder setBullet(boolean bullet){
        bodyDef.bullet = bullet;
        return this;
    }
    public BodyBuilder setFixedRotation(boolean fixedRotation){
        bodyDef.fixedRotation = fixedRotation;
        return this;
    }
    public BodyBuilder setGravityScale(float gravityScale){
        bodyDef.gravityScale = gravityScale;
        return this;
    }
    public BodyBuilder setActive(float linearDamping){
        bodyDef.linearDamping = linearDamping;
        return this;
    }
    public BodyBuilder setLinearVelocity(float x, float y){
        bodyDef.linearVelocity.x = x;
        bodyDef.linearVelocity.y = y;
        return this;
    }
    public BodyBuilder setLinearVelocity(Vector2 linearVelocity){
        return setLinearVelocity(linearVelocity.x,linearVelocity.y);
    }
    public BodyBuilder setType(BodyDef.BodyType type){
        bodyDef.type = type;
        return this;
    }
}
