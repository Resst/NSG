package com.studio.nsg.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.studio.nsg.components.PlayerComponent;
import com.studio.nsg.components.TransformComponent;
import com.studio.nsg.entities.Player;
import com.studio.nsg.utils.SystemPriorities;

public class PlayerControlSystem extends IteratingSystem {

    public PlayerControlSystem() {
        super(Family.all(PlayerComponent.class).get(), SystemPriorities.PLAYER_CONTROL);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Player player = (Player) entity;

        //TODO make it normal
        float xSpeed, ySpeed;
        xSpeed = ySpeed = 10;
        Vector2 translation = new Vector2();

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            translation.y += ySpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            translation.y -= ySpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            translation.x += xSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            translation.x -= xSpeed;
        }

        translation.scl(deltaTime);
        player.translate(translation);
    }
}
