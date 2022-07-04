package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.studio.nsg.components.AnimationComponent;
import com.studio.nsg.components.TextureComponent;
import com.studio.nsg.utils.PriorityComparator;
import com.studio.nsg.utils.SystemPriorities;

public class AnimationSystem extends SortedIteratingSystem {

    static float stateTime = 0f;
    private AnimationComponent animationComponent;
    private Animation<TextureRegion> animation;

    public AnimationSystem() {
        super(Family.all(TextureComponent.class, AnimationComponent.class).get(), new PriorityComparator(), SystemPriorities.ANIMATION);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        stateTime += deltaTime;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        animationComponent = entity.getComponent(AnimationComponent.class);
        animation = animationComponent.animation.get(animationComponent.state);
        entity.getComponent(TextureComponent.class).sprite.setRegion(animation.getKeyFrame(stateTime,!(animation.getPlayMode() == Animation.PlayMode.NORMAL)));
        /* Проклятая версия
         entity.getComponent(TextureComponent.class).sprite.setRegion(entity.getComponent(AnimationComponent.class).animation.get(entity.getComponent(AnimationComponent.class).state).getKeyFrame(stateTime,!(entity.getComponent(AnimationComponent.class).animation.get(entity.getComponent(AnimationComponent.class).state).getPlayMode() == Animation.PlayMode.NORMAL)));
         */
    }

    public void ResetStateTime() {
        stateTime = 0;
    }
}
