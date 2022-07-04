package com.studio.nsg.Tools.box2dBuilders;

import com.badlogic.gdx.physics.box2d.*;

public class FixtureBuilder {
    private FixtureDef fixtureDef;
    public FixtureBuilder(){
        fixtureDef = new FixtureDef();
    }
    public Fixture build(Body body){
        Fixture fixture = body.createFixture(fixtureDef);
        fixtureDef = new FixtureDef();
        return fixture;
    }
    public FixtureBuilder setShape(Shape shape){
        fixtureDef.shape = shape;
        return this;
    }
    public FixtureBuilder setDensity(float density){
        fixtureDef.density = density;
        return this;
    }
    public FixtureBuilder setFriction(float friction){
        fixtureDef.friction = friction;
        return this;
    }
    public FixtureBuilder setIsSensor(boolean isSensor){
        fixtureDef.isSensor = isSensor;
        return this;
    }
    public FixtureBuilder setRestitution(float restitution){
        fixtureDef.restitution = restitution;
        return this;
    }
    public FixtureBuilder setFilter(Filter filter){
        fixtureDef.filter.set(filter);
        return this;
    }
}
